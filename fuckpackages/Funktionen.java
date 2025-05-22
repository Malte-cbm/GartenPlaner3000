
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Funktionen {
    public GartenController gc;

    public Funktionen (GartenController gc){
	this.gc = gc;
    }
    
    public void aufruf(String cmd){

	switch( cmd ){

	case "Neuer Garten":

	    
	    gc.neuGarten("MinLand");
	    break;
	    
	case "Laden":
	    JOptionPane.showMessageDialog(null, "Laden leider geschlossen");
	    break;

	case "Speichern":
	    JOptionPane.showMessageDialog(null, "Datei gespeichert");
	    break;

	case "Neues Beet":
	    JOptionPane.showMessageDialog(null, "Hallo Heinzi");
	    break;

	case "Beet bearbeiten":
	    JOptionPane.showMessageDialog(null, "Du bist 1 Motherfucker");
	    break;
	}
    }
}
