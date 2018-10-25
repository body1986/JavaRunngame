package Runninggame;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Sven Rossmann
 */
public class Fadenkreuz {
  int x, y;
    Component comp;
    boolean perreicht [] = new boolean [5];
  
    public Fadenkreuz(int x, int y, Component comp){
        this.x=x;
        this.y=y;
        this.comp=comp;
    }

    public void SetXY(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public void paintcreep(Graphics gr){
        gr.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Ressourcen/fadenkreuz.png")), x, y, comp);
    }
    
    public void move(){
        boolean lr=false;
        boolean hr=false;
        if(x!=40 && perreicht[0]==false || y!=83 && perreicht[0]==false){
            movev(hr);
        }
        if(x==40 && y==83){
            perreicht[0]=true;
        }
        if(perreicht[0]==true){
            if(x!=237){
                moveh(lr);
            }
        }
        if(x==237 && y==83){
            perreicht[1]=true;
        }
        if(perreicht[1]==true){
            if(y!=206){
                movev(hr);
            }
        }
        if(x==237 && y==204){
            perreicht[2]=true;
        }
        if(perreicht[2]==true){
            if(x!=79){
                lr=true;
                moveh(lr);
            }
        }
        if(x==79 && y==205){
            perreicht[3]=true;
        }
        if(perreicht[3]==true){
            if(y!=350){
                movev(hr);
            }
        }
        if(x==79 && y==350){
            perreicht[4]=true;
        }
        if(perreicht[4]==true){
            
        }
    }
    public void moveh(boolean lr){//lr=left or right
        if(lr==false)
            x++;
        if(lr==true)
            x--;
    }

    public void movev(boolean hr){//hr = hoch oder runter
        if(hr==false)
            y++;
        if(hr==true)
            y--;
        
    }  
}
