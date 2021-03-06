package movingspacecraft;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.applet.*;

public class Craft {

	private String  craft = "/Images/craft.png";
	private int dx,dy,x,y;
	private Image image;
	private AudioClip bombSound;
	private ArrayList missiles;
    private final int BOARD_WIDTH  = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int BOARD_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    
    private boolean visible;
    private int width;
    private int height;
	
	public Craft() {
		ImageIcon ii = new ImageIcon(getClass().getResource(craft));
		image = ii.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
		visible = true;
		
		missiles = new ArrayList();
		x = 0;
		y = (BOARD_HEIGHT-110)/2;
		
		try{
		    bombSound = Applet.newAudioClip(this.getClass().getResource("/Sounds/bomb.wav"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	
	/* getter and setter description*/
	
	

	public int getDx() {
		return dx;
	}
	
	public boolean isVisible() {
		return visible;
	}



	public void setVisible(boolean visible) {
		this.visible = visible;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public ArrayList getMissiles() {
		return missiles;
	}



	public void setMissiles(ArrayList missiles) {
		this.missiles = missiles;
	}



	public void setDx(int dx) {
		this.dx = dx;
	}

	public String getCraft() {
		return craft;
	}
	public void setCraft(String craft) {
		this.craft = craft;
	}
	

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public AudioClip getBombSound() {
		return bombSound;
	}



	public void setBombSound(AudioClip bombSound) {
		this.bombSound = bombSound;
	}
	
	/*getter and setter description end*/
	
	



	public void move(){
		if((dx>0 && x<BOARD_WIDTH-90) || (dx<0 && x>0))x += dx;
		if((dy>0 && y<BOARD_HEIGHT-90) || (dy<0 && y>-5))y += dy;
	}
	
	public void keyPressed(KeyEvent e){
		//JOptionPane.showMessageDialog(null,e.getKeyCode());
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT)dx--;
		if(key == KeyEvent.VK_RIGHT)dx++;
		if(key == KeyEvent.VK_UP)dy--;
		if(key == KeyEvent.VK_DOWN)dy++;
		if (key == KeyEvent.VK_SPACE) fire();
	}
	
	public void keyReleased(KeyEvent e){
		//JOptionPane.showMessageDialog(null,e.getKeyCode());
int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT)dx = 0;
		if(key == KeyEvent.VK_RIGHT)dx = 0;
		if(key == KeyEvent.VK_UP)dy = 0;
		if(key == KeyEvent.VK_DOWN)dy = 0;
	}
	
	public void fire() {
		bombSound.stop();
		bombSound.play();
	    missiles.add(new Missile(x + width, y + height/2-8));
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}





