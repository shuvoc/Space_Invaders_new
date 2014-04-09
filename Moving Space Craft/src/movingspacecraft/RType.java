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
		setSize(  ((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()) , ((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()) );
		
        setLocationRelativeTo(null);
        setTitle("Space Invader(By Shuvo)");
        setResizable(false);
        setVisible(true);
        
        try{
		    backSound = Applet.newAudioClip(this.getClass().getResource("/Sounds/a.wav"));
		    backSound.loop();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
				new RType();
	}

}
