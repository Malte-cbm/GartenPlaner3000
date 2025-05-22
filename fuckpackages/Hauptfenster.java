
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*  1:0:Datei
    2:0:Edit
    3:1:New File
    4:1:Open File
    5:2:Undo
*/			
public class Hauptfenster {

    public GartenController gc;
    public Funktionen ff;
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

	JFrame f = new JFrame();

	MenuFactory menubar = new MenuFactory(hm, this.ff);
	f.setJMenuBar(menubar);

	
	DrawingCanvas dc = new DrawingCanvas(w,h);
	f.setSize(w,h);
	f.setTitle("Gartenplaner 3000 v0.3alpha");
	f.add(dc);
	//f.add(button);
	//f.add(button2);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
    }

   
    
}
