package Views;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import Controller.*;
import ObjektModelle.*;

public class GartenView extends JComponent implements deimuddi{

   
    private GartenModel gm;
       
    private ArrayList<deimuddi> listeDerZuschauer;

    public GartenView(GartenModel gm){
	this.listeDerZuschauer = new ArrayList<deimuddi>();
	
	this.gm = gm;
	this.gm.addObserver(this);
    }

    public void addObserver(deimuddi aha) {
        this.listeDerZuschauer.add(aha);
	System.out.println("Observer hinzugefügt in der GartenView!");
    }

    public void removeObserver(deimuddi soso) {
        this.listeDerZuschauer.remove(soso);
    }
    
    public void sendUpdate() {
        for (deimuddi pifpaf : this.listeDerZuschauer) {
            pifpaf.update(this);
        }
    }


    @Override
    public void update (Object arg){
	if (arg instanceof GartenModel){}
    }
    
    @Override
    protected void paintComponent(Graphics g){

	Graphics2D g2d = (Graphics2D) g;

	RenderingHints rh = new RenderingHints(  RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.setRenderingHints(rh);

	
	Rectangle2D.Double grundflaeche = new Rectangle2D.Double(50, 50, (this.gm.getBreite() * 10) , (this.gm.getTiefe() * 10) );
	g2d.setColor(new Color(255,209,204));
	g2d.fill(grundflaeche);
   }

}
