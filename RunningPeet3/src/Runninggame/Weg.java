/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runninggame;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 *
 * @author rossmann
 */
public class Weg {
	private int yPos = 0;
	private int WegNummer = 0;
	private int yBlockFaktor = 1;
	private int xBlockFaktor = 1;
	private WegBlog[] WegLinie = null;
	private ImageObserver myImageObserver = null;
	private SpielParameter mySpielParameter = null;

	public Weg(ImageObserver io, SpielParameter mySpielParameter,int yPos) {
		this.mySpielParameter = mySpielParameter;		 
		this.myImageObserver = io;
		this.yPos = yPos;
		
		WegLinie = new WegBlog[mySpielParameter.AnzSpielbloecke];
		for (int i = 0; i <  mySpielParameter.AnzSpielbloecke; i++) {
			WegLinie[i] = new WegBlog(myImageObserver,mySpielParameter);
		}
	}

	public void Animi(Graphics myGraphic) {
		zeichneWeg(myGraphic);
	}

	public void zeichneWeg(Graphics myGraphic) {		
		int Wegbreite = xBlockFaktor*mySpielParameter.VirtuelleBlockgroesse;
		WegNummer = mySpielParameter.GlobalePosition / Wegbreite;
		int iXPos = -Wegbreite + (-(mySpielParameter.GlobalePosition - (WegNummer * Wegbreite)));
		
		for (int i = 0; i < mySpielParameter.xSpielRaster+2; i++) {
			WegLinie[WegNummer + i].paint(myGraphic, iXPos, yPos);
			iXPos = iXPos + Wegbreite;
		}
		mySpielParameter.aktionPosition= WegLinie[WegNummer+6].getType();
	}

	 
}
