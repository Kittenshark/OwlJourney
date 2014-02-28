/**
 * Mines are devils of the game. Mine can be visible or invisible.
 */
package owljourneygame.parts;

import java.awt.Rectangle;

public class Mine {
    /**
     * Coordinates of X-axis
     */
    protected int x;
    /**
     * Coordinates of Y-axis
     */
    protected int y;
    /**
     * Determines the size of the of the mine
     */
    protected int size;
    /**
     * Tells if the mine is active. If mine is active, it can hit and damage player
     */
    private boolean active;
    
    private boolean visible;
    
    /**
     * Sets mine values
     * When mine is created, it is active
     * @param x X-axis location
     * @param y Y-axis location
     * @param visible sets whether mine can be seen or not
     */
    public Mine(int x, int y, boolean visible){
        this.x = x;
        this.y = y;
        this.size = 15;
        this.visible = visible;
        active = true;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public boolean getVisible(){
        return visible;
    }
    
    public void setSize(int side){
        this.size = side;
    }
    
    /**
     * Sets mine active
     */
    public void setActive(){
        active = true;
    }
    
    /**
     * Sets mine inactive and invisible
     */
    public void setInActive(){
        visible = false;
        active = false;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, size, size);
    }
}
