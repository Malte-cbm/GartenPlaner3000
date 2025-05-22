package Views;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class DrawingCanvas extends JComponent {

    private int width;
    private int height;

    public DrawingCanvas( int w, int h) {

	width = w;
	height = h;
    }

    @Override
    protected void paintComponent(Graphics g){

	Graphics2D g2d = (Graphics2D) g;

	RenderingHints rh = new RenderingHints(
					       RenderingHints.KEY_ANTIALIASING,
					       RenderingHints.VALUE_ANTIALIAS_ON);

	g2d.setRenderingHints(rh);
	
	Rectangle2D.Double r = new Rectangle2D.Double(100,80,200,50);
	g2d.setColor(new Color(123,42,200));
	g2d.fill(r);
	Rectangle2D.Double rene = new Rectangle2D.Double(200,180,50,350);
	g2d.setColor(new Color(244,100,30));
	g2d.fill(rene);
   }

}
