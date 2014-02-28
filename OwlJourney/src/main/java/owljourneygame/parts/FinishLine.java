/**
 * Goal
 * Level is complete if the owl reaches goal
 */

package owljourneygame.parts;

import java.awt.Rectangle;

public class FinishLine {
    /**
     * Coordinate of X-axis
     */
    private int x;
    /**
     * Coordinate of Y-axis
     */
    private int y;
    
    public FinishLine(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getSide(){
        return 20;
        //goal, mine, owl sivun pituus 10
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 20, 20);
    }
}
