package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ObjektModelle.*;

public class GartenController{

    public GartenModel gm;
    
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
		System.out.println(b.getY());
	        pstmt.setInt(1, b.getX());
	        pstmt.setInt(2, b.getY());	    
		pstmt.setInt(3, b.getBreite());
		pstmt.setInt(4, b.getTiefe());
		pstmt.execute();
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
