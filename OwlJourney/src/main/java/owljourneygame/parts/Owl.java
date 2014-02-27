
package owljourneygame.parts;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import owljourneygame.Game.MoveSide;

public class Owl{
    /**
     * Determines size of the Owl
     */
    private int size;
    /**
     * Owl X-axis coordinates
     */
    private int x;
    /**
     * Owl Y-axis coordinates
     */
    private int y;
    private MoveSide move;
    
    public Owl(int x, int y, int side){
        this.size = side;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Moves owl to wanted direction
     * @param where direction where owl will move
     */
    public void moveOwl() {
        if (move.getWhere() == 0){
            x += 10;
        } else if(move.getWhere() == 1){ //vasen
            x -= 10;
        }else if (move.getWhere() == 2){ //alas
            y += 10;
        } else if (move.getWhere() == 3) { //ylös
            y -= 10;
        }
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
    
    public void setOwlDirection(MoveSide move){
        this.move = move;
    }
    //get
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    public int getSize(){
        return size;
    }
    
    public MoveSide getMoveDirection(){
        return move;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, size, size);
    }
}
