package Views;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Startscreen extends JComponent {

    private int width;
    private int height;
    private BufferedImage image;

    public Startscreen( int w, int h) {

	width = w;
	height = h;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, this);
    }

}
