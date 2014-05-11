package movingspacecraft;

import java.awt.*;

import javax.swing.*;

public class Alien {
	
	private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image alienImg;
    private final int BOARD_WIDTH  = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int BOARD_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public Alien(int x,int y) {
		ImageIcon ii = new ImageIcon(getClass().getResource("/Images/alien.png"));
		alienImg = ii.getImage();
		
		width = alienImg.getWidth(null);
		height = alienImg.getHeight(null);
		visible = true;
		
		this.x = x;
		this.y = y;
	}
	
	public void move(){
		if(x<0) x= BOARD_WIDTH;
		x--;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,width,height);
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Image getAlienImg() {
		return alienImg;
	}

	public void setAlienImg(Image alienImg) {
		this.alienImg = alienImg;
	}
}





