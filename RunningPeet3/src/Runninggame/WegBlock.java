package Runninggame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Sven Rossmann
 */
public class WegBlock {
	private int yAnzBloecke = 1;
	private int xAnzBloecke = 1;
	private BufferedImage Wegobject = null;
	private Random zufallsgenerator = new Random();
	private static final String ImagePath = "Ressourcen/Weg/Weg";
	private ImageObserver myImageObserver = null;
	private SpielParameter mySpielParameter = null;
	private int blockType =0;
	
	/**
	 * Erstellt jeden einzelnen Wegblock
	 * @param ioSpielParameter
	 * @param mySpielParameter
	 */
	public WegBlock(ImageObserver ioSpielParameter ,SpielParameter mySpielParameter) {
		this.myImageObserver = ioSpielParameter;
		this.mySpielParameter = mySpielParameter;
		
		int zahl = zufallsgenerator.nextInt(6) + 1;			
		try {			
			switch (zahl) {
			case 1:
				Wegobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath +"2"+".png"));
				blockType=2;
				break;
			case 2:
				Wegobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath +"3"+".png"));
				blockType=3;
				break;

			default:
				Wegobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath +"1"+".png"));
				blockType=1;
				break;
			}
		} catch (IOException ex) {
			Logger.getLogger(Baum.class.getName()).log(Level.SEVERE, null, ex);
		}		
	}

	/**
	 * Erzeugt das Objekt
	 * @param myGraphic
	 * @param iXPos
	 * @param iYPos
	 */
	public void paint(Graphics myGraphic, int iXPos, int iYPos) {
		
		int x = mySpielParameter.myKoordinatensystem.getFrameX(iXPos);
		int y = mySpielParameter.myKoordinatensystem.getFrameY(iYPos)-((yAnzBloecke)*mySpielParameter.SpielblockHoehe);
		
		myGraphic.drawImage(Wegobject, x, y, xAnzBloecke*mySpielParameter.SpielblockLaenge, yAnzBloecke*mySpielParameter.SpielblockHoehe, myImageObserver);
	}

	/**
	 * gibt den Typ des Wegblock Objecktes zurueck
	 * @return
	 */
	public int getType() {
		return blockType;				
	}
}
