/**
 * Main character of the game. Owl has coordinates and size.
 */
package owljourneygame.parts;

import java.awt.Rectangle;
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
    private MoveSide move = null;
    private int energy;
    
    public Owl(int x, int y, int side){
        this.size = side;
        this.x = x;
        this.y = y;
        energy = 100;
    }
    
    /**
     * Moves owl to direction that has been set before
     * Method does not work if owl has no set direction
     */
    public void moveOwl() {
        if (move != null){
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
    
    public void setEnergy(){
        energy = 100;
    }
    
    /**
     * Decreases owls energy
     * Energy will go down only if owl has enough energy that it needs to use
     * @param lose how much energy owl will lose
     */
    public void loseEnergy(int lose){
        if (energy - lose >= 0){
            energy -= lose;
        }
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
    
    public int getEnergy(){
        return energy;
    }
    
    public MoveSide getMoveDirection(){
        return move;
    }
    
    /**
     * 
     * @return Rectangle of Owl
     */
    public Rectangle getBounds(){
        return new Rectangle(x, y, size, size);
    }
}
