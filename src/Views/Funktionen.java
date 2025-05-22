package Views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.*;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controller.*;
import ObjektModelle.*;

public class Funktionen {
    
    public GV2 gv;
    public Hauptfenster hf;
    public GartenController gc;
    public BeetController bc;
    
    public Funktionen (GartenController gc, BeetController bc){
	this.gc = gc;
	this.bc = bc;
    }
    public void setHauptfenster(Hauptfenster hf){
	this.hf = hf;
    }
    
    public Set<String> listFilesUsingJavaIO(String dir) {
    return Stream.of(new File(dir).listFiles())
      .filter(file -> !file.isDirectory())
	.filter(file -> file.getName().endsWith("db")) 
      .map(File::getName)
      .collect(Collectors.toSet());
    }
    
    public void aufruf(String cmd){

	switch( cmd ){

	case "Neuer Garten":
	    GartenMaske gm = new GartenMaske(gc);
	    GartenModel zwischendings = gc.neuGarten(gm.adresse, gm.breite, gm.tiefe);
	    this.bc.setGM( zwischendings );
	    this.gv = new GV2(zwischendings);
	    
	    hf.setzeBild(this.gv);

	    break;
	    
	case "Laden":
	    Set<String> asdf = listFilesUsingJavaIO("./");
	    for (String file: asdf){
		System.out.println(file);}
	    LadeBox lb = new LadeBox(asdf);
	    if (lb.wahl != null){
		GartenModel loadG = gc.ladeGarten(lb.wahl);
		this.bc.setGM(loadG);
		this.gv = new GV2(loadG);
		hf.setzeBild(this.gv);
	    }
	    break;

	case "Speichern":
	    gc.saveGarten();
	    JOptionPane.showMessageDialog(null, "Datei gespeichert");
	    break;

	case "Neues Beet":
	    if (gc.gm != null){

		BeetMaske bm = new BeetMaske(bc);

		
		BeetView zwischenbums = bc.neuBeetModel (bm.xPos+20, bm.yPos+20, bm.breite*40, bm.tiefe*40);
		
		this.gv.addBeet(zwischenbums);
		
	    }
	    else{
	    JOptionPane.showMessageDialog(null, "Ohne Garten keine Beete");
	    }
	    break;

	case "Beet bearbeiten":
	    JOptionPane.showMessageDialog(null, "Du bist 1 Motherfucker");
	    break;
	}
    }
}
