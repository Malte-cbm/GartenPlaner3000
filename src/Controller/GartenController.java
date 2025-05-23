package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ObjektModelle.*;
import Views.*;

public class GartenController{

    public GartenModel gm;
    private BeetController bc;

    public void setBC(BeetController bc){
	this.bc = bc;
    }

    public void changeBeet(ChangeBeet cb){
	for (BeetModel beet : this.gm.zeigeAlleBeete()){
	    if (beet.isSelected()){
		beet.setNew();
		beet.setzeMasse(cb.breite * 40, cb.tiefe* 40);
		beet.setzePos( (cb.xPos * 40 +20), (cb.yPos* 40 +20));
		
	    }
	}
    }
	
			
    public GartenModel neuGarten(String name, int breite, int tiefe){

	try {
	    Class.forName("org.sqlite.JDBC");

	    String db = "jdbc:sqlite:" + name + ".db";
	
	    Connection conn = DriverManager.getConnection(db);

	    Statement stmt = conn.createStatement();

	    stmt.execute("CREATE TABLE IF NOT EXISTS Beete(id INTEGER PRIMARY KEY,  positionX INTEGER, positionY INTEGER, breite INTEGER, tiefe INTEGER)");
    	    stmt.execute("CREATE TABLE IF NOT EXISTS GartenDaten(id INTEGER PRIMARY KEY, adresse TEXT, breite INTEGER, tiefe INTEGER)");

	    stmt.close();

	    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO GartenDaten(adresse, breite, tiefe) VALUES(?,?,?)");
			
	    
	    pstmt.setString(1, name);
	    pstmt.setInt(2, breite);
	    pstmt.setInt(3, tiefe);
	    pstmt.execute();
	    pstmt.close();
	    
	    conn.close();

	    GartenModel gamo = new GartenModel();
	    gamo.setzeAdresse(name);
	    gamo.setzeMasse(breite, tiefe);
	    this.gm = gamo;

	}

	catch (ClassNotFoundException e){
	    System.err.println("Der Datenbanktreiber wurde nicht gefunden");
	}

	catch(SQLException e) {
	    System.err.println("Ein Fehler in der Abfrage ist aufgetreten: " + e.getMessage());
	}
	    return this.gm;
    }

    public void saveGarten(){
	try {
	
	    Class.forName("org.sqlite.JDBC");
	
	    String db = "jdbc:sqlite:" + this.gm.nenneAdresse() + ".db";

	    Connection conn = DriverManager.getConnection(db);
	
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Beete(positionX, positionY, breite, tiefe) VALUES(?,?,?,?)");

	    for(BeetModel b :this.gm.zeigeAlleBeete()){
	        if (b.isNew()){
	        pstmt.setInt(1, translateToMeters(b.getX()));
	        pstmt.setInt(2, translateToMeters(b.getY()));	    
		pstmt.setInt(3, (b.getBreite()/40));
		pstmt.setInt(4, (b.getTiefe()/40));
		pstmt.execute();}
	    }

	    pstmt.close();
	    conn.close();
	}
	
	catch (ClassNotFoundException e){
	    System.err.println("Der Datenbanktreiber wurde nicht gefunden");
	}

	catch(SQLException e) {
	    System.err.println("Ein Fehler in der Abfrage ist aufgetreten: " + e.getMessage());
	}

	
    }

    public int translateToMeters (int px) {
	return ((px -20)/40);
    }

    public int translateToPX ( int m ) {
	return m*40 +20;
    }
    
    public GartenModel ladeGarten(String name){
	
    try {
	
	GartenModel gamo = new GartenModel();

	Class.forName("org.sqlite.JDBC");
	
	String db = "jdbc:sqlite:" + name;

	Connection conn = DriverManager.getConnection(db);

	Statement stmt = conn.createStatement();
 
	stmt.close();

	PreparedStatement pstmt = conn.prepareStatement("SELECT adresse, breite, tiefe from GartenDaten");
			
	ResultSet rs = pstmt.executeQuery();
	
	while(rs.next()) {
	    gamo.setzeAdresse(rs.getString(1));
	    gamo.setzeMasse(rs.getInt(2), rs.getInt(3));
	}
	
	rs.close();
	pstmt.close();
	
	conn.close();
	    
	this.gm = gamo;

	}

    catch (ClassNotFoundException e){
	System.err.println("Der Datenbanktreiber wurde nicht gefunden");
	}

    catch(SQLException e) {
	System.err.println("Ein Fehler in der Abfrage ist aufgetreten: " + e.getMessage());
	}

    return this.gm;
    
    
    }

    public void ladeBeete(GV2 gv){

	try {

	Class.forName("org.sqlite.JDBC");
	
	String db = "jdbc:sqlite:" + this.gm.nenneAdresse() + ".db";

	Connection conn = DriverManager.getConnection(db);
	
	PreparedStatement pstmt = conn.prepareStatement("SELECT positionX, positionY, breite, tiefe, id from Beete");
	ResultSet rs = pstmt.executeQuery();
	
	while(rs.next()) {

	    int pos_x_px = translateToPX(rs.getInt(1));
	    int pos_y_px = translateToPX(rs.getInt(2));
	    int breite_px = translateToPX(rs.getInt(3))-20;
	    int tiefe_px = translateToPX(rs.getInt(4))-20;
	    int id = rs.getInt(5);
	    System.out.println("x ist: " +pos_x_px);
	    BeetView hmmm = bc.neuBeetModel(pos_x_px, pos_y_px, breite_px, tiefe_px, false, id);
	    bc.addBV( hmmm, gv);
	}

	rs.close();
	pstmt.close();
	conn.close();
	}

    catch (ClassNotFoundException e){
	System.err.println("Der Datenbanktreiber wurde nicht gefunden");
	}

    catch(SQLException e) {
	System.err.println("Ein Fehler in der Abfrage ist aufgetreten: " + e.getMessage());
	}

	

    }
    
    public boolean formValidator(String adresse, String b, String t){

	try {
	    Integer.parseInt(b);
	    Integer.parseInt(t);
	    return true;
	}
	catch (NumberFormatException e){
	    return false;
	}
    }
}
