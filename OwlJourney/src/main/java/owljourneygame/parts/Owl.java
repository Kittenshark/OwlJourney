
package owljourneygame.parts;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Owl{
    private int side;
    private int x;
    private int y;
    
    public Owl(int x, int y, int side){
        //Pöllön aloituskoordinaatit ja sivun pituus
        //super(x, y); //aloituspiste
        this.side = side;
        this.x = x;
        this.y = y;
    }
    
    public int getSide(){
        return side;
    }  
    
    public void moveOwl(int where) {
        if (where == 0){
            x += 10;
        } else if(where == 1){ //vasen
            x -= 10;
        }else if (where == 2){ //alas
            y += 10;
        } else if (where == 3) { //ylös
            y -= 10;
        }
        /*pöllö liikkuu pelikentällä uusiin koordinaatteihin
            vielä ei varmaa, kuinka liikkuminen tapahtuu.
            Action listener tarvitaan.
            todennäköisesti x ja y montako askelta mihinkin suuntaan
        */
    }
    
    public void setOwl(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, side, side);
    }
    
    
}
