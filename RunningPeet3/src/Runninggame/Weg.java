package Runninggame;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 *
 * @author Sven Rossmann
 */
public class Weg {
	private int yPos = 0;
	private int WegNummer = 0;
	private int yBlockFaktor = 1;
	private int xBlockFaktor = 1;
	private WegBlock[] WegLinie = null;
	private ImageObserver myImageObserver = null;
	private SpielParameter mySpielParameter = null;

	/**
	 * Erzeugt einen Weg aus den einzelnen WegBloecken
	 * @param io
	 * @param mySpielParameter
	 * @param yPos
	 */
	public Weg(ImageObserver io, SpielParameter mySpielParameter,int yPos) {
		this.mySpielParameter = mySpielParameter;		 
		this.myImageObserver = io;
		this.yPos = yPos;
		
		WegLinie = new WegBlock[mySpielParameter.AnzSpielbloecke];
		for (int i = 0; i <  mySpielParameter.AnzSpielbloecke; i++) {
			WegLinie[i] = new WegBlock(myImageObserver,mySpielParameter);
		}
	}

	/**
	 * Animiert den Weg
	 * @param myGraphic
	 */
	public void Animi(Graphics myGraphic) {		
		zeichneWeg(myGraphic);
	}

	/**
	 * Zeichnet den Weg aus den einzelnen Wegbloecken
	 * @param myGraphic
	 */
	public void zeichneWeg(Graphics myGraphic) {		
		try {
			int Wegbreite = xBlockFaktor*mySpielParameter.VirtuelleBlockgroesse;
			WegNummer = mySpielParameter.GlobalePosition / Wegbreite;
			int iXPos = -Wegbreite + (-(mySpielParameter.GlobalePosition - (WegNummer * Wegbreite)));
			
			for (int i = 0; i < mySpielParameter.xSpielRaster+2; i++) {
				WegLinie[WegNummer + i].paint(myGraphic, iXPos, yPos);
				iXPos = iXPos + Wegbreite;
			}
			mySpielParameter.aktionPosition= WegLinie[WegNummer+6].getType();
		} catch (Exception e) {			
			
		}
	}	 
}
