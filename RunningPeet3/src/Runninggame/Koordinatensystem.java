package Runninggame;

import java.awt.image.BufferedImage;

/**
 *
 * @author Sven Rossmann
 */
public class Koordinatensystem {

	public int FormHeight = 0;
	public int FormWidth = 0;

	public int xSpielRaster = 0;
	public int ySpielRaster = 0;
	public int VirtuelleBlockgroesse = 0;
	public int SpielblockLaenge = 0;
	public int SpielblockHoehe = 0;
	private double xFactor;
	private double yFactor;
	

	public Koordinatensystem(int xRaster, int yRaster, int SpielblockLaenge, int SpielblockHoehe,int VirtuelleBlockgroesse) {
		setKoordinatensystem(xRaster, yRaster, SpielblockLaenge, SpielblockHoehe,VirtuelleBlockgroesse);
	}

	public void setKoordinatensystem(int xRaster, int yRaster, int SpielblockLaenge, int SpielblockHoehe,int VirtuelleBlockgroesse) {
		this.VirtuelleBlockgroesse = VirtuelleBlockgroesse;
		this.SpielblockLaenge = SpielblockLaenge;
		this.SpielblockHoehe = SpielblockHoehe;
		this.xSpielRaster = xRaster;
		this.ySpielRaster = yRaster;
		this.FormHeight = yRaster * SpielblockHoehe;
		this.FormWidth = xRaster * SpielblockLaenge;
		this.xFactor = (double)((double)FormWidth/((double)xSpielRaster*(double)VirtuelleBlockgroesse));
		this.yFactor = (double)((double)FormHeight/((double)ySpielRaster*(double)VirtuelleBlockgroesse));
	}

	public int getFrameX(int iXPos) {
		int x = (int)(iXPos*xFactor);
		return x;
	}

	public int getFrameY(int iYPos) {
		int y = FormHeight-(int)(iYPos*yFactor);
		return y;
	}

	public class Size {
		public int GFXPos = 0;
		public int GFYPos = 0;
		public double xFactor = 0;
		public double yFactor = 0;
	}
}
