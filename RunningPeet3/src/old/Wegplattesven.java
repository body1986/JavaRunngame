/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Wegplattesven {
////    private BufferedImage Wegobject = null;
////    private Random zufallsgenerator = new Random();
////    private static final String ImagePath = "Ressourcen/Weg.png";
////    private ImageObserver myImageObserver = null;
////    
////    public Wegplatte(ImageObserver io) {
////        myImageObserver = io;
////        int zahl = zufallsgenerator.nextInt(4) + 1;
////        try {
////            Wegobject = ImageIO.read(getClass().getClassLoader().getResource(ImagePath));
////        } catch (IOException ex) {
////            Logger.getLogger(Baum.class.getName()).log(Level.SEVERE, null, ex);
////        }
////    }
////
////    public void paint(Graphics myGraphic, int iXPos, int iYPos) {
////        myGraphic.drawImage(Wegobject, iXPos, iYPos,100,50, myImageObserver);
////    }
//	
//	
//	 private int WegNummer = 0;
//	    private int GlobalePosition = 0;
//	    private Wegsven[] WegLinie1 = null; 
//	     
//	    private ImageObserver myImageObserver = null;	    	    	    
//	    private int mySpeed = 1;
//	    private boolean visible = true;	    
//	    private int Verzoegerung = 0;
//	    
//	    private int yPos = 0;
//		private int BlockNummer = 0;
//		private int yBlockFaktor = 9;
//		private int xBlockFaktor = 1;
//	    private SpielParameter mySpielParameter = null;	
//
//	    public Wegplattesven(ImageObserver io,SpielParameter mySpielParameter,int yPos) {
//	    	this.mySpielParameter = mySpielParameter;
//	        this.myImageObserver = io;
//	        this.yPos = yPos;
//	        
//	        WegLinie1 = new Wegsven[mySpielParameter.AnzSpielbloecke];
//	        
//	        for (int i = 0; i < mySpielParameter.AnzSpielbloecke; i++) {
//	        	WegLinie1[i] = new Wegsven(myImageObserver);	        			            
//	        }
//	    }
//
//	    public void Animi(Graphics myGraphic) {
//	    	if (visible) {
//	            Verzoegerung++;
//	            if (Verzoegerung == mySpeed) {
//	                Verzoegerung = 0;	                
//	            }
//	            zeichneWeg(myGraphic);	            
//	        }
//	    }
//
//	    public void zeichneWeg(Graphics myGraphic) {
//	    	int Wegbreite = xBlockFaktor*mySpielParameter.VirtuelleBlockgroesse;
//			BlockNummer = mySpielParameter.GlobalePosition / Wegbreite;	    	
//	        int iXPos = -Wegbreite+(-(GlobalePosition-(WegNummer*Wegbreite)));	        
//	        for (int i = 0; i < 20; i++) {
//	        	WegLinie1[BlockNummer + i].paint(myGraphic, iXPos+mySpielParameter.VirtuelleBlockgroesse, yPos);
//	            iXPos = iXPos + Wegbreite;	        	
//	        }	        
//	    }
//
//	    public void Step(int GlobalePosition)
//	    {
//	        this.GlobalePosition = GlobalePosition;
//	    }
//	    	    
//	    public void setSpeed(int Speed) {
//	        mySpeed = Speed;
//	        Verzoegerung = 0;
//	    }
}
