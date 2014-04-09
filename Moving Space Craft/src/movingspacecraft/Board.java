package movingspacecraft;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener{

	private Timer t1;
	private Craft c1;
	private Image img;
	
	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon ii = new ImageIcon(getClass().getResource("/Images/back.jpg"));
		img = ii.getImage();
		
		c1 = new Craft();
		t1 = new Timer(7,this);
		t1.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//super.paintComponent(g);
        // paint the background image and scale it to fill the entire space
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(c1.getImage(), c1.getX(), c1.getY(),this);
		
		ArrayList ms = c1.getMissiles();

        for (int i = 0; i < ms.size(); i++ ) {
            Missile m = (Missile) ms.get(i);
            g2d.drawImage(m.getMis(), m.getX(), m.getY(), this);
        }
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent e){
		
		ArrayList ms = c1.getMissiles();

        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);
            if (m.isVisible()) 
                m.move();
            else ms.remove(i);
        }
		
		c1.move();
		repaint();
	}
	
	
	private class TAdapter extends KeyAdapter{
		
		public void keyReleased(KeyEvent e) {
	        c1.keyReleased(e);
	    }

	    public void keyPressed(KeyEvent e) {
	        c1.keyPressed(e);
	    }
	}
}





