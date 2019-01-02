package Runninggame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Button extends JButton {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String buttonImmage = "Button1";
	
	public Button (String buttonImmage) {
		try {
			loadImage(buttonImmage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	private static void loadImage(String buttonImmage) throws IOException {
        int newWidth = 80;
        int newHeight = 40;
        //bi = ImageIO.read(Button.class.getResource("Ressourcen/"+buttonImmage+".png"));
        //bi = bi.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
    }            
}