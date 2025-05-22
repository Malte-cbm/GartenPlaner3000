package Views;

import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Observer;
import Controller.GartenController;
import ObjektModelle.GartenModel;

/*  1:0:Datei
    2:0:Edit
    3:1:New File
    4:1:Open File
    5:2:Undo
*/			
public class Hauptfenster extends JFrame implements deimuddi{

    public GartenController gc;
    public Funktionen ff;
    public HashMap<String, ArrayList<String>> hashmenu;
    //public Planer pc;
    public Hauptfenster(GartenController gc, Funktionen ff){

	this.gc = gc;
	this.ff = ff;
	//this.pc = pc;
	
	int w = 1060;
	int h = 900;

	ArrayList<String> im1 = new ArrayList<String>();
	im1.add( "Neuer Garten" );
	im1.add( "Laden" );
	im1.add( "Speichern" );
	
	ArrayList<String> im2 = new ArrayList<String>();
	im2.add( "Neues Beet" );
	im2.add( "Beet bearbeiten" );

	ArrayList<String> im3 = new ArrayList<String>();
	im3.add( "Guckstu" );
	im3.add( "Settings" );

	
	
	HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

	hm.put("Garten", im1);
	hm.put("Beete", im2);
	hm.put("pifpaf", im3);
	this.hashmenu = hm;
	MenuFactory menubar = new MenuFactory(this.hashmenu, this.ff);
	this.setJMenuBar(menubar);
	
	this.setSize(1060,900);
	this.setTitle("Gartenplaner 3000 v0.3alpha");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setzeStart();
    }

    
    public void setzeStart(){


	Startscreen startscreen = new Startscreen(1060,900);

	BufferedImage image = null;
	
	try {
	    image = ImageIO.read(new File("./Views/relachs.jpg"));
	}
	catch(Exception e) {
	    System.out.println("Could not read file!");
	    e.printStackTrace();
	} 
	startscreen.setImage(image);
	this.add(startscreen);
	this.setVisible(true);
    }
    
    public void setzeBild(GartenView gv){
	
	//this.remove();
	this.setContentPane(gv);
	this.repaint();
	this.getContentPane().repaint();
	//this.frame.add(dc);
	//this.frame.setVisible(true);
	}
    
    @Override
    public void update(Object arg){
	if( arg instanceof GartenView gv ) {
	    
	}
    }

   
    
}
