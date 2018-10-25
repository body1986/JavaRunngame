package Runninggame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

/**
 *
 * @author rossmann
 */
public class Himmel {
	private int yAnzBloecke = 8;
	private int xAnzBloecke = 10;
	private int yPos = 0;
	private BufferedImage Himmelobject = null;
	private ImageObserver myImageObserver = null;
	private SpielParameter mySpielParameter = null;
	private String ImagePath = "Ressourcen/Himmel.png";

	public Himmel(ImageObserver io, SpielParameter mySpielParameter,int yPos) {
		this.mySpielParameter = mySpielParameter;		 
		this.myImageObserver = io;
		this.yPos = yPos;
		
		try {
			Himmelobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath));
		} catch (IOException ex) {
			 
			Logger.getLogger(Baum.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void Animi(Graphics myGraphic) {
		
//		int x = mySpielParameter.myKoordinatensystem.getFrameX(1);
//		int y = mySpielParameter.myKoordinatensystem.getFrameY(800);
		
		myGraphic.drawImage(Himmelobject,0, 0, xAnzBloecke*mySpielParameter.SpielblockLaenge, yAnzBloecke*mySpielParameter.SpielblockHoehe, myImageObserver);
	}

	
	 
}
