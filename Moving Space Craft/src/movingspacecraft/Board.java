package movingspacecraft;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener{
	
	private AudioClip backSound;
	private Timer t1;
	private Craft c1;
	private Image img;
	private boolean inGame;
	private ArrayList aliens;
	private final int BOARD_WIDTH  = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int BOARD_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private int pos[][] = { 
            {2380, 29}, {2500, 599}, {1380, 89},
            {780, 109}, {580, 139}, {680, 239}, 
            {790, 259}, {760, 507}, {790, 150},
            {980, 209}, {560, 455}, {510, 70},
            {930, 459}, {590, 80}, {530, 60},
            {940, 559}, {990, 330}, {920, 200},
            {900, 360}, {660, 50}, {540, 90},
            {810, 640}, {860, 200}, {740, 180},
            {820, 700}, {490, 170}, {700, 30}
         };
	
	public Board() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setDoubleBuffered(true);
		inGame = true;
		
		ImageIcon ii = new ImageIcon(getClass().getResource("/Images/back.jpg"));
		img = ii.getImage();
		
		initAliens();
		c1 = new Craft();
		t1 = new Timer(7,this);
		
		try{
		    backSound = Applet.newAudioClip(this.getClass().getResource("/Sounds/a.wav"));
		    backSound.loop();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		t1.start();
	}
	
	public void initAliens(){
		aliens = new ArrayList();
		
		for (int i=0; i<pos.length; i++ ) {
            aliens.add(new Alien(pos[i][0], pos[i][1]));
        }
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
        // paint the background image and scale it to fill the entire space
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
        
        
        if(inGame)
        {
        	Graphics2D g2d = (Graphics2D)g;
    		if(c1.isVisible())g2d.drawImage(c1.getImage(), c1.getX(), c1.getY(),this);
        	
        	ArrayList ms = c1.getMissiles();
	
	        for (int i = 0; i < ms.size(); i++ ) {
	            Missile m = (Missile) ms.get(i);
	            g2d.drawImage(m.getMis(), m.getX(), m.getY(), this);
	        }
	        
	        for(int i=0;i<aliens.size();i++){
	        	Alien a = (Alien) aliens.get(i);
	        	g2d.drawImage(a.getAlienImg(), a.getX(),a.getY(), this);
	        }
	        g2d.setColor(Color.CYAN);
	        g2d.setFont(new Font("Tristan",Font.BOLD,14));
	        g2d.drawString("Score: " + (27-aliens.size())*5, BOARD_WIDTH-100,BOARD_HEIGHT-10);
        }
        else
        {
        	String msg;
        	if(aliens.isEmpty())msg = "Mission Successfully Completed.";
        	else msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 34);
            FontMetrics metr = this.getFontMetrics(small);

            g.setColor(Color.CYAN);
            g.setFont(small);
            g.drawString(msg, (BOARD_WIDTH - metr.stringWidth(msg)) / 2,
                         BOARD_HEIGHT / 2);
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
        
        for (int i = 0; i < aliens.size(); i++) {
            Alien a = (Alien) aliens.get(i);
            if (a.isVisible()) 
                a.move();
            else aliens.remove(i);
        }
        
        if(aliens.size()==0 || inGame==false){
        	inGame = false;
        	c1.setVisible(false);
        	c1.getBombSound().stop();
        	backSound.stop();
        }
		
		c1.move();
		checkCollisions();
		repaint();
	}
	public void checkCollisions() {

        Rectangle r3 = c1.getBounds();

        for (int j = 0; j<aliens.size(); j++) {
            Alien a = (Alien) aliens.get(j);
            Rectangle r2 = a.getBounds();

            if (r3.intersects(r2)) {
            	inGame = false;
            }
        }
        
        
        ArrayList ms = c1.getMissiles();

        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);

            Rectangle r1 = m.getBounds();

            for (int j = 0; j<aliens.size(); j++) {
                Alien a = (Alien) aliens.get(j);
                Rectangle r2 = a.getBounds();

                if (r1.intersects(r2)) {
                    m.setVisible(false);
                    a.setVisible(false);
                }
            }
        }
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





