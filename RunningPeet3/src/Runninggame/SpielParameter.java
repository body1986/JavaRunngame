package Runninggame;

public class SpielParameter {

	public Koordinatensystem myKoordinatensystem = null;
	
	private int Weg = 0;
	private int Pos = 0;
	public int Richtung = 1;
	public int GlobalePosition = 0;
	public int SpielblockLaenge = 0;
	public int SpielblockHoehe = 0;
	public int FrameHoehe = 0;
	public int FrameLaenge = 0;
	//----------------------------------------------------------------------------------------------------------------------------------
	// Globale Spieleparameter
	//----------------------------------------------------------------------------------------------------------------------------------
	public int AnzSpielbloecke = 500; 		// Größe der Ebene in Spieleblöcke
	public int VirtuelleBlockgroesse = 100; // Rastergröße 100 x 100
	public int xSpielRaster = 10; 			// X Rastegröße 
	public int ySpielRaster = 8;			// Y Rastergröße
	public int xFigur1 = ((xSpielRaster/2)*VirtuelleBlockgroesse)-VirtuelleBlockgroesse;
	public int yFigur1 = 150;
	public int yWeg = 100;
	public int yWald = 200;
	//----------------------------------------------------------------------------------------------------------------------------------
	public int aktionPosition =0; 
	public int sprung=0;
	
	
	
	public SpielParameter() {
		myKoordinatensystem = new Koordinatensystem(xSpielRaster, ySpielRaster,SpielblockLaenge,SpielblockHoehe,VirtuelleBlockgroesse);
	}

	
	public void GlobalPositionBerechnen(String Richtung) {
		if (Richtung == "R") { 
			if (GlobalePosition < (AnzSpielbloecke * SpielblockLaenge))
				GlobalePosition++;
		};
		if (Richtung == "L") {
			if (GlobalePosition > 0)
				GlobalePosition--;
		}
		Kolisionspruefung();
	}

	
	private void Kolisionspruefung() {
		
		switch (aktionPosition) {
		case 2:
			if (sprung==0) {
				System.out.println("wasser");
			}			
			break;
		case 3:
			if (sprung==0) {
				System.out.println("Bombe");
			}				
			break;
		default:
			System.out.println(" ");
			break;
		}	
	}


	public void setGroesse(int height, int width) {
		this.FrameHoehe = height;
		this.FrameLaenge = width;
		SpielblockHoehe = FrameHoehe/ySpielRaster;
		SpielblockLaenge = FrameLaenge/xSpielRaster;
		myKoordinatensystem.setKoordinatensystem(xSpielRaster, ySpielRaster,SpielblockLaenge,SpielblockHoehe,VirtuelleBlockgroesse);
	}
}
