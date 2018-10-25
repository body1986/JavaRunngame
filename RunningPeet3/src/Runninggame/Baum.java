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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.Random;

/**
 *
 * @author rossmann
 */
public class Baum {

	private int yAnzBloecke = 4;
	private int xAnzBloecke = 2;
	private BufferedImage Baumobject = null;
	private Random zufallsgenerator = new Random();
	private static final String ImagePath = "Ressourcen/Wald/Baum";
	private ImageObserver myImageObserver = null;
	private SpielParameter mySpielParameter = null;

	public Baum(ImageObserver io, SpielParameter mySpielParameter) {
		this.myImageObserver = io;
		this.mySpielParameter = mySpielParameter;
		int zahl = zufallsgenerator.nextInt(4) + 1;
		try {
			Baumobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath + zahl + ".png"));
		} catch (IOException ex) {
			Logger.getLogger(Baum.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void paint(Graphics myGraphic, int iXPos, int iYPos) {
		
		int x = mySpielParameter.myKoordinatensystem.getFrameX(iXPos);
		int y = mySpielParameter.myKoordinatensystem.getFrameY(iYPos)-((yAnzBloecke)*mySpielParameter.SpielblockHoehe);
		
		
		
		myGraphic.drawImage(Baumobject, x, y, xAnzBloecke*mySpielParameter.SpielblockLaenge, yAnzBloecke*mySpielParameter.SpielblockHoehe, myImageObserver);
	}

}
