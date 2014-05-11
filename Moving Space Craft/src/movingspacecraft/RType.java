package movingspacecraft;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Toolkit;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RType extends JFrame{

	AudioClip backSound;
	
	public RType() {
		add(new Board());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setUndecorated(true);
	    
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
				new RType();
	}

}
