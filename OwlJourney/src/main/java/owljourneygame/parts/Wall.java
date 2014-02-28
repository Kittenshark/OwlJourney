
package owljourneygame.parts;

import java.awt.Rectangle;

/**
 * Wall. Limits area where owl can move
 */
public class Wall extends Dot{
    /**
     * Width of the wall
     */
    private int width;
    /**
     * Height of the wall
     */
    private int height;

    public Wall(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    /**
     * Sees whether two walls are equal or not
     * @param wall
     * @return boolean are walls equal or not
     */
    public boolean equals(Wall wall){
        if (wall.getX() == x && wall.getY() == y && wall.width == width && wall.height == height){
            return true;
        }
        return false;
    }
    /*
    public void paint(Graphics g){
        g.fillRect(x, y, width, height);
    }
    */

    /**
     *
     * @return Rectangle of Wall
     */
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
}
