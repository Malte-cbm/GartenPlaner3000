package Views;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import Controller.*;
import ObjektModelle.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Views.Subscriber;

public class GV2 extends JComponent implements Subscriber{

   
    private GartenModel gm;
    private BeetModel selectedBeet;
    
    public void addBeet( BeetView bv ) {
	this.add( bv );
	this.repaint();
    }
    

    public GV2(GartenModel gm){
	
	
	this.gm = gm;
	this.gm.addObserver(this);

	this.addMouseListener ( new MouseAdapter() {
		@Override
		public void mouseClicked( MouseEvent evt ) {

		    if(selectedBeet != null) {
			selectedBeet.setSelected(false);
			repaint();
		    }
		    selectedBeet = null;
		    BeetModel bm = gm.getBeet( evt.getX(), evt.getY() );
		    if(bm != null) {
			selectedBeet = bm;
		    }

		}
	    });

	this.addMouseMotionListener( new MouseAdapter() {
		@Override
		public void mouseMoved( MouseEvent evt ){

		    gm.deselectAll();

		    if(selectedBeet != null) {
			selectedBeet.setSelected(true);
		    }
		    //this.selectedBeet = null;
		    
		    BeetModel bm  = gm.getBeet( evt.getX(), evt.getY() );
		    if( bm != null ) {
			System.out.println( "Beet found");
			bm.setSelected( true );
			//this.selectedBeet = bm;
			repaint();
			
		    }
		    repaint();
		    System.out.println(evt.getX());
		}
	 });

	
    }

    

    
    @Override
    protected void paintComponent(Graphics g){
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;

	RenderingHints rh = new RenderingHints(  RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g2d.setRenderingHints(rh);
	Rectangle2D.Double rand = new Rectangle2D.Double(0, 0, (this.gm.getBreite() * 40) + 40 , (this.gm.getTiefe() * 40) +40 );
	
	g2d.setColor(new Color(182, 247, 153));
	g2d.fill(rand);
	
	Rectangle2D.Double grundflaeche = new Rectangle2D.Double(20, 20, (this.gm.getBreite() * 40) , (this.gm.getTiefe() * 40) );
	g2d.setColor(new Color(235, 222, 195));
	g2d.fill(grundflaeche);

   }

    @Override
    public void update (Object arg){
	if (arg instanceof GartenModel gm){
	    this.gm = gm;
	}
    }
}
