
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuFactory extends JMenuBar implements ActionListener{

    public Funktionen ff;
    public MenuFactory(HashMap<String, ArrayList<String>> aufbau, Funktionen ff){
	
	super();
	this.ff = ff;
	for (String i: aufbau.keySet()){
	    
	    JMenu karte = baueReiter(i, aufbau.get(i));
	    this.add(karte);
	}
    }

	    

	 
    private JMenu baueReiter(String name,  ArrayList<String> subpunkte){

	JMenu reiter = new JMenu(name);


	for(String i: subpunkte){
	    
	    JMenuItem subdings = baueSubMenu(i);
	    reiter.add(subdings);
	    
	}
	return reiter;
    };


    private JMenuItem baueSubMenu(String name){

	JMenuItem ahasovielleicht = new JMenuItem(name);
	ahasovielleicht.addActionListener(this);
	ahasovielleicht.setActionCommand(name);
	return ahasovielleicht;

    }

    public void actionPerformed(ActionEvent e){

	if (e != null){
	    String sourceee = e.getActionCommand();
	    //ab hier dann Uebergabe an den Controller
	    ff.aufruf(sourceee);
	    

	}
    }

}
