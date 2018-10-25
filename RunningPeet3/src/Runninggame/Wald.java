package Runninggame;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 *
 * @author Sven Rossmann
 */
public class Wald {
	private int yPos = 0;
	private int BlockNummer = 0;
	private int yBlockFaktor = 3;
	private int xBlockFaktor = 2;
	private Baum[] BaumLinie1 = null;
	private Baum[] BaumLinie2 = null;
	private ImageObserver myImageObserver = null;
	private SpielParameter mySpielParameter = null;	

	/**
	 * Generiert den Wald aus den Baum Objekten
	 * @param io
	 * @param mySpielParameter
	 * @param yPos
	 */
	public Wald(ImageObserver io, SpielParameter mySpielParameter,int yPos) {
		this.mySpielParameter = mySpielParameter;
		this.myImageObserver = io;
		this.yPos = yPos;

		BaumLinie1 = new Baum[mySpielParameter.AnzSpielbloecke];
		BaumLinie2 = new Baum[mySpielParameter.AnzSpielbloecke];
		for (int i = 0; i < mySpielParameter.AnzSpielbloecke; i++) {
			BaumLinie1[i] = new Baum(myImageObserver,mySpielParameter);
			BaumLinie2[i] = new Baum(myImageObserver,mySpielParameter);
		}
	}

	/**
	 * Animiert den Wald
	 * @param myGraphic
	 */
	public void Animi(Graphics myGraphic) {
		zeichneWald(myGraphic);
	}

	/**
	 * Zeichnet den Wald mit den einzelnen Baum Objekten
	 * @param myGraphic
	 */
	public void zeichneWald(Graphics myGraphic) {
		int Baumbreite = xBlockFaktor*mySpielParameter.VirtuelleBlockgroesse;
		BlockNummer = mySpielParameter.GlobalePosition / Baumbreite;
		int iXPos = -Baumbreite + (-(mySpielParameter.GlobalePosition - (BlockNummer * Baumbreite)));
		
		for (int i = 0; i < mySpielParameter.xSpielRaster+1; i++) {
			BaumLinie2[BlockNummer + i].paint(myGraphic, iXPos+mySpielParameter.VirtuelleBlockgroesse, yPos);
			iXPos = iXPos + Baumbreite;
		}

		iXPos = -Baumbreite + (-(mySpielParameter.GlobalePosition - (BlockNummer * Baumbreite)));
		for (int i = 0; i < mySpielParameter.xSpielRaster+1; i++) {
			BaumLinie1[BlockNummer + i].paint(myGraphic, iXPos, yPos);
			iXPos = iXPos + Baumbreite;
		}

	}
}
