/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author rossmann
 */
public class WegBlog {
	private int yAnzBloecke = 1;
	private int xAnzBloecke = 1;
	private BufferedImage Wegobject = null;
	private Random zufallsgenerator = new Random();
	private static final String ImagePath = "Ressourcen/Weg/Weg";
	private ImageObserver myImageObserver = null;
	private SpielParameter mySpielParameter = null;
	private int blockType =0;
	
	public WegBlog(ImageObserver ioSpielParameter ,SpielParameter mySpielParameter) {
		this.myImageObserver = ioSpielParameter;
		this.mySpielParameter = mySpielParameter;
		
		int zahl = zufallsgenerator.nextInt(6) + 1;
//		try {
//			Wegobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath));
//		} catch (IOException ex) {
//			Logger.getLogger(Baum.class.getName()).log(Level.SEVERE, null, ex);
//		}
		
//		int modzahl = zahl % 20;
		
		//System.out.println("modzahl: "+ modzahl);
			
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
			
			
//			if (zahl == 2) {
//				// Wasser
//				Wegobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath +"3"+".png"));
//				System.out.println("wasser");
//			}
//			if (zahl == 3) {
//				// Bombe
//				Wegobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath +"2"+".png"));// ImagePath + zahl +
//				//System.out.println("bombe");
//			}
//			else{
//				Wegobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath +"1"+".png"));// ImagePath + zahl +
//				// ".png"));
//				//System.out.println("Graﬂ");
//			}
			
			
		} catch (IOException ex) {
			Logger.getLogger(Baum.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	public void paint(Graphics myGraphic, int iXPos, int iYPos) {
		
		int x = mySpielParameter.myKoordinatensystem.getFrameX(iXPos);
		int y = mySpielParameter.myKoordinatensystem.getFrameY(iYPos)-((yAnzBloecke)*mySpielParameter.SpielblockHoehe);
		
		myGraphic.drawImage(Wegobject, x, y, xAnzBloecke*mySpielParameter.SpielblockLaenge, yAnzBloecke*mySpielParameter.SpielblockHoehe, myImageObserver);
	}

	public int getType() {
		return blockType;				
	}
}
