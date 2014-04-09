package movingspacecraft;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Missile {

	private int x,y;
	private Image mis;
	private boolean visible;
	
	private final int BOARD_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final int MISSILE_SPEED = 2;
	
	public Missile(int x,int y) {
		
		ImageIcon ii = new ImageIcon(getClass().getResource("/Images/missile.png"));
		mis = ii.getImage();
		
		visible = true;
		this.x = x;
		this.y = y;
	}
	/*getter and setter starts*/
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

	public Image getMis() {
		return mis;
	}

	public void setMis(Image mis) {
		this.mis = mis;
	}
	/*getter and setter ends*/
	
	public boolean isVisible(){
		return visible;
	}
	
	public void move(){
		x += MISSILE_SPEED;
		if(x> BOARD_WIDTH)visible = false;
	}
}
