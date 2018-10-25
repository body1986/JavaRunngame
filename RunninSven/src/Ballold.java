
import java.awt.*;
import javax.swing.*;

public class Ballold {

    int x, y;
    int t1 = 0;
    int BildNr = 1;
    boolean Bild1 = false;

    Component comp;
    public boolean perreicht[] = new boolean[5];
    
    
    /**
     * Konstruktor Ball
     * @param x
     * @param y
     * @param comp
     */
    public Ballold(int x, int y, Component comp) {
        this.x = x;
        this.y = y;
        this.comp = comp;
    }
    
    /**
     * setzt die X und y Koordinaten
     * @param x
     * @param y
     */
    public void SetXY(int x, int y) {
        this.x = x;
        this.y = y;
        x = 40;
        y = 25;
        perreicht[0] = false;
        perreicht[1] = false;
        perreicht[2] = false;
        perreicht[3] = false;
        perreicht[4] = false;

    }

    /**
     * Erzeugt den Ball
     * @param gr
     */
    public void paintBall(Graphics gr) {    	
        gr.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Ball3.png")), x, y, comp);
    }

    /**
     * Erzeugt das Bild
     * @param gr
     */
    public void paintBild(Graphics gr) {
        t1++;
        if (t1 == 10) {
            t1 = 0;
            if (Bild1) {
                BildNr++;
                if (BildNr == 12) {
                    BildNr = 1;
                    Bild1 = false;
                }
            }
        }
        gr.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Ressourcen/Bild1/Bild" + BildNr + ".png")), 40, 25, comp);
    }

    /**
     * Bewegen
     */
    public void move() {
        boolean lr = false;
        boolean hr = false;
        if (x != 40 && perreicht[0] == false || y != 83 && perreicht[0] == false) {
            moveDirection("U");
        }
        if (x == 40 && y == 83) {
            perreicht[0] = true;
        }
        if (perreicht[0] == true) {
            if (x != 237) {
            	moveDirection("R");
            }
        }
        if (x == 237 && y == 83) {
            perreicht[1] = true;
        }
        if (perreicht[1] == true) {
            if (y != 206) {
            	moveDirection("D");
            }
        }
        if (x == 237 && y == 204) {
            perreicht[2] = true;
        }
        if (perreicht[2] == true) {
            if (x != 79) {
                lr = true;
                moveDirection("L");
            }
        }
        if (x == 79 && y == 205) {
            perreicht[3] = true;
        }
        if (perreicht[3] == true) {
            if (y != 350) {
            	moveDirection("U");
            }
        }
        if (x == 79 && y == 350) {
            perreicht[4] = true;
        }
        if (perreicht[4] == true) {
            x = 40;
            y = 25;
            perreicht[0] = false;
            perreicht[1] = false;
            perreicht[2] = false;
            perreicht[3] = false;
            perreicht[4] = false;
        }
    }

    /**
     * Bewegt den ball
     */
    public void moveBall() {
        x++;
        y++;
        if (x > 200) {
            x = 40;
        }
        if (y > 200) {
            y = 25;
        }
    }

    /**
     * Richtungs bewegung R=right L=left U=up D=down
     * @param richtung
     */
    public void moveDirection(String richtung) {
        if (richtung.equals("R")) {
            x++;
        }
        if (richtung.equals("L")) {
            x--;
        }
        
        if (richtung.equals("U")) {
            y++;
        }
        if (richtung.equals("D")) {
            y--;
        }
    }
}
