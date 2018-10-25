package Runninggame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Sven Rossmann
 */
public class Figur {

	private int yAnzBloecke = 2;
	private int xAnzBloecke = 2;
	private BufferedImage[] BildfolgeLinks = null;
	private BufferedImage[] BildfolgeRechts = null;
	private BufferedImage[] BildfolgeRechtsSprung = null;
	private ImageObserver myImageObserver = null;
	private SpielParameter mySpielParameter = null;
	private int myBildNr = 0;
	private int Verzoegerung = 0;
	private int mySpeed = 10;
	private boolean myAnimiStart = false;
	private static final String ImagePathLinks = "Ressourcen/Figur1/LaufenLinks/Bild";
	private static final String ImagePathRechts = "Ressourcen/Figur1/LaufenRechts/Figur";
	private static final String ImagePathRechtsSprung = "Ressourcen/Figur1/LaufenRechts/Sprung1_";
	private int iXPos = 0;
	private int iYPos = 0;
	private boolean visible = false;
	private boolean richtung = false;
	private String myRichtung = "";
	private boolean sprung = false;

	public boolean isSprung() {
		return sprung;
	}

	public void setSprung(boolean sprung) {
		this.sprung = sprung;
	}

	public Figur(ImageObserver io, SpielParameter mySpielParameter) {
		this.mySpielParameter = mySpielParameter;
		try {
			this.myImageObserver = io;
			BildfolgeLinks = new BufferedImage[12];
			BildfolgeRechts = new BufferedImage[12];
			BildfolgeRechtsSprung = new BufferedImage[3];
			LadeImage();
		} catch (IOException ex) {
			Logger.getLogger(Figur.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public int Animi(Graphics myGraphic) {
		if (visible) {
			Verzoegerung++;
			if (Verzoegerung == mySpeed) {
				Verzoegerung = 0;
				if (myAnimiStart){
						myBildNr++;
						if (myBildNr == 12) {
							myBildNr = 1;
							myAnimiStart = false;
						}	
					}					
				}
			}			
			if (richtung) {				
				paintRechts(myGraphic, myBildNr, iXPos, iYPos);
			} else {
				paintLinks(myGraphic, myBildNr, iXPos, iYPos);
			}		
		mySpielParameter.GlobalPositionBerechnen(myRichtung);
		return myBildNr;
	}	
	
	
	public int AnimiSprung(Graphics myGraphic) {
		if (visible) {
					if (sprung) {						
							if (myAnimiStart){
									myBildNr=1;
									if (myBildNr == 3) {
										myBildNr = 1;
										myAnimiStart = false;
									}	
								}					
														
					}					
				}
			if (sprung) {
				paintRechtssprung(myGraphic, myBildNr, iXPos, iYPos);
						
		}
		mySpielParameter.GlobalPositionBerechnen(myRichtung);
		return myBildNr;
	}	
	
	
	public void setSpeed(int Speed) {
		mySpeed = Speed;
		Verzoegerung = 0;
	}

	public void setPosition(boolean visible, int iXPos, int iYPos) {
		this.iXPos = iXPos;
		this.iYPos = iYPos;
		this.visible = visible;
	}

	public void StartAnimi(String Richtung) {
		myRichtung = Richtung;
		if (Richtung == "L") {
			richtung = false;
		}
		if (Richtung == "R") {
			richtung = true;
		}
		myAnimiStart = true;
	}
	public void StartAnimiSprung() {		
		myAnimiStart  = true;
	}

	private void LadeImage() throws IOException {
		int i1 = 0;
		int is = 0;
		for (int i = 0; i < 12; i++) {
			i1++;
			BildfolgeLinks[i] = ImageIO.read(getClass().getClassLoader().getResource(ImagePathLinks + i1 + ".png"));
			BildfolgeRechts[i] = ImageIO.read(getClass().getClassLoader().getResource(ImagePathRechts + i1 + ".png"));
		}
		for (int i = 0; i < 3; i++) {
			is++;
			BildfolgeRechtsSprung[i] = ImageIO.read(getClass().getClassLoader().getResource(ImagePathRechtsSprung + is + ".png"));
		}
	}

	private void paintRechts(Graphics myGraphic, int BildNr, int iXPos, int iYPos) {
		
		int x = mySpielParameter.myKoordinatensystem.getFrameX(iXPos);
		int y = mySpielParameter.myKoordinatensystem.getFrameY(iYPos)-((yAnzBloecke)*mySpielParameter.SpielblockHoehe);
		
		myGraphic.drawImage(BildfolgeRechts[BildNr], x, y,xAnzBloecke*mySpielParameter.SpielblockLaenge, yAnzBloecke*mySpielParameter.SpielblockHoehe, myImageObserver);
	}

	private void paintLinks(Graphics myGraphic, int BildNr, int iXPos, int iYPos) {
		int x = mySpielParameter.myKoordinatensystem.getFrameX(iXPos);
		int y = mySpielParameter.myKoordinatensystem.getFrameY(iYPos)-((yAnzBloecke)*mySpielParameter.SpielblockHoehe);
		
		myGraphic.drawImage(BildfolgeLinks[BildNr], x, y,xAnzBloecke*mySpielParameter.SpielblockLaenge, yAnzBloecke*mySpielParameter.SpielblockHoehe, myImageObserver);
	}
	
	private void paintRechtssprung(Graphics myGraphic, int BildNr, int iXPos, int iYPos) {
		
		int x = mySpielParameter.myKoordinatensystem.getFrameX(iXPos);
		int y = mySpielParameter.myKoordinatensystem.getFrameY(iYPos)-((yAnzBloecke)*mySpielParameter.SpielblockHoehe);
		
		myGraphic.drawImage(BildfolgeRechtsSprung[BildNr], x, y,xAnzBloecke*mySpielParameter.SpielblockLaenge, yAnzBloecke*mySpielParameter.SpielblockHoehe, myImageObserver);
	}

}
