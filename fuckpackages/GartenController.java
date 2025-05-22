
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GartenController{

    //private DatabaseConnector dbconn;
    

    public void neuGarten(String name){

	try {
	    Class.forName("org.sqlite.JDBC");

	    String db = "jdbc:sqlite:" + name + ".db";
	
	    Connection conn = DriverManager.getConnection(db);

	    Statement stmt = conn.createStatement();

	    stmt.execute("CREATE TABLE IF NOT EXISTS Beete(id INTEGER PRIMARY KEY, name TEXT, positionX INTEGER, positionY INTEGER)");
	    stmt.execute("CREATE TABLE IF NOT EXISTS GartenDaten(id INTEGER PRIMARY KEY, adresse TEXT, breite INTEGER, tiefe INTEGER)");
	    stmt.close();
	    conn.close();
	}

	catch (ClassNotFoundException e){
	    System.err.println("Der Datenbanktreiber wurde nicht gefunden \n" + e.getMessage());
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
