package Views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controller.GartenController;
import ObjektModelle.*;

public class Funktionen {
    
    public GartenController gc;
    public Hauptfenster hf;
    public GartenView gv;
    
    public Funktionen (GartenController gc){
	this.gc = gc;
    }
    public void setHauptfenster(Hauptfenster hf){
	this.hf = hf;
    }
    public void aufruf(String cmd){

	switch( cmd ){

	case "Neuer Garten":
	    GartenMaske gm = new GartenMaske(gc);
	    GartenModel zwischendings = gc.neuGarten(gm.adresse, gm.breite, gm.tiefe);
	    this.gv = new GartenView(zwischendings);
	    this.gv.addObserver(hf);
	    hf.setzeBild(this.gv);

	    break;
	    
	case "Laden":
	    hf.setzeBild(this.gv);
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
