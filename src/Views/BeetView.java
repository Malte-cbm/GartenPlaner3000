package Views;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import Controller.*;
import ObjektModelle.*;
import Views.Subscriber;

public class BeetView extends JComponent implements Subscriber{

    private BeetModel bm;
    private GartenModel gm;

    public BeetView(BeetModel bm){
	this.bm = bm;
	this.bm.addObserver(this);
	this.gm = gm;
	this.setBounds(bm.getX(), bm.getY(), bm.getBreite(), bm.getTiefe());
	
    }
    

    @Override
    protected void paintComponent(Graphics g){

	Graphics2D g2d = (Graphics2D) g;

	RenderingHints rh = new RenderingHints(  RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.setRenderingHints(rh);

	
	Rectangle2D.Double beetflaeche = new Rectangle2D.Double( 0, 0, this.bm.getBreite(), this.bm.getTiefe());
	g2d.setColor(bm.isSelected() ? Color.YELLOW :  new Color(128, 99, 102));
	g2d.fill(beetflaeche);

	//this.repaintComponents()

	
   }

    @Override
    public void update (Object arg){
	if (arg instanceof BeetModel bn){
	    this.bm.removeObserver(this);
	    System.out.println("UJHKSDJFKJSDBGKSDGHBD");
	    this.bm = bn;
	    this.bm.addObserver(this);
	    this.setBounds(bm.getX(), bm.getY(), bm.getBreite(), bm.getTiefe());
	    repaint();
	}
    }
}
