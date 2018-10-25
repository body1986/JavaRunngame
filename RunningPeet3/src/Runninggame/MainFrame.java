/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runninggame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/**
 *
 * @author rossmann
 */
public class MainFrame extends javax.swing.JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Himmel myHimmel = null;
	public Figur myFigur = null;
	public Wald myWald = null;
	public Weg myWeg = null;
	public Fadenkreuz myFadenkreuz = null;
	public JPanel myJPanel;
	private Graphics myGraphics=null;
	
	private SpielParameter mySpielParameter = null;

	/**
	 * Creates new form MainFrame
	 */
	@SuppressWarnings("deprecation")
	public MainFrame() {
		initComponents();

		mySpielParameter = new SpielParameter();
		
		
		// ----------------------------------------------------------------------
		// Ein neues JPanel zum zeichnen
		// ----------------------------------------------------------------------
		myJPanel = new JPanel() {
			
			
			private static final long serialVersionUID = 1L;

			@Override
			public void paint(final Graphics g) {
//				Graphics2D g2d = (Graphics2D) g;
//				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));				
				super.paint(g);				
				ZeicheLeinwand(g);
			};
		};
		
		
		
		mySpielParameter.setGroesse(getContentPane().getSize().height,getContentPane().getSize().width);
		
		myHimmel = new Himmel(this, mySpielParameter, 0);
		myFigur = new Figur(this, mySpielParameter);
		myFigur.setPosition(true, mySpielParameter.xFigur1, mySpielParameter.yFigur1);
		myWald = new Wald(this,mySpielParameter,mySpielParameter.yWald);
		myFadenkreuz = new Fadenkreuz(600, 300, this);// Fadenkreuz(this, mySpielParameter);
		myWeg = new Weg(this,mySpielParameter,mySpielParameter.yWeg);

		//myHimmel.Animi(myJPanel.getGraphics());
		// ----------------------------------------------------------------------
		// Tastatureingaben
		// ----------------------------------------------------------------------
		getContentPane().addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
//				System.out.println("1" + e.paramString());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("2" + e.getKeyChar());
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {					
					myFigur.setSprung(true);		
					mySpielParameter.sprung=1;
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {//										
					myFadenkreuz.movev(true);					
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {//										
					myFadenkreuz.movev(false);					
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					myFadenkreuz.moveh(false);
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {					
					myFadenkreuz.moveh(true);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
//				System.out.println("3" + e.getKeyChar());
				
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {					
					myFigur.setSprung(false);			
					mySpielParameter.sprung=0;
				}				
			}
		});
		// ----------------------------------------------------------------------
		//
		// ----------------------------------------------------------------------
		getContentPane().add(myJPanel);
		pack();
		setVisible(true);
		getContentPane().setFocusable(true);
		StartTimer();
	}

	// ----------------------------------------------------------------------
	// Auf der Leinwand zeichnen
	// ----------------------------------------------------------------------
	private void ZeicheLeinwand(Graphics g) {
		myHimmel.Animi(g);	
		myWald.Animi(g);
		myWeg.Animi(g);		
		myFadenkreuz.paintcreep(g);
		
		if (myFigur.isSprung()==true) {
			int Pos = myFigur.AnimiSprung(g);	
		}
		else {
			int Pos = myFigur.Animi(g);	
		}
		
		
		
//		if (Pos > 0) {
//			mySpielParameter.GlobalPositionBerechnen();
//		}
	}

	// ----------------------------------------------------------------------
	// Auf der Leinwand zeichnen
	// ----------------------------------------------------------------------
	
	public void StartTimer() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		}, 0, 10);

		Timer timer2 = new Timer();
		timer2.schedule(new TimerTask() {
			@Override
			public void run() {
				myFigur.StartAnimi("R");
			};
		}, 0, 50);
	}
	
	@SuppressWarnings("unchecked")
	
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setSize(new java.awt.Dimension(600, 400));
		addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentResized(java.awt.event.ComponentEvent evt) {
				FormGroesseGeaendert(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1000, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 600, Short.MAX_VALUE));

		setMaximumSize(new Dimension(1000, 600));
		pack();
		setLocationRelativeTo(null);
	}

	private void FormGroesseGeaendert(java.awt.event.ComponentEvent evt) {// GEN-FIRST:event_FormGroesseGeaendert
		
		myGraphics = evt.getComponent().getGraphics();
//		try {
//			g.drawImage(ImageIO.read(getClass().getClassLoader().getResource("Ressourcen/Himmel.png")), 0, 0, this);			
//		} catch (IOException e) {
//			// TODO Automatisch generierter Erfassungsblock
//			e.printStackTrace();
//		}
		
		if (mySpielParameter!=null) {
			myJPanel.setSize(this.getWidth(),this.getHeight());
			mySpielParameter.setGroesse(getContentPane().getSize().height,getContentPane().getSize().width);
		}

	}// GEN-LAST:event_FormGroesseGeaendert

	// ----------------------------------------------------------------------
	// Hauptfunktion
	// ----------------------------------------------------------------------
	public static void main(String args[]) {
		MainFrame myFrame = new MainFrame();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables
}
