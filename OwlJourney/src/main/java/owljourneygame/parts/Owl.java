
package owljourneygame.parts;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Owl{
    /**
     * Determines size of the Owl
     */
    private int side;
    /**
     * Owl X-axis coordinates
     */
    private int x;
    /**
     * Owl Y-axis coordinates
     */
    private int y;
    
    public Owl(int x, int y, int side){
        this.side = side;
        this.x = x;
        this.y = y;
    }
    
    public int getSide(){
        return side;
    }  
    
    /**
     * Moves owl to wanted direction
     * @param where direction where owl will move
     */
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
    
    /**
     * Sets owl in a new position
     * Makes it possible to move owl to wanted direction without taking moving steps
     * @param x X-axis location
     * @param y Y-axis location
     */
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
