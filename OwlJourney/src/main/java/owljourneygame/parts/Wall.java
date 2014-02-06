
package owljourneygame.parts;

import java.awt.Graphics;
import java.awt.Rectangle;


public class Wall extends Dot{
    private int width;
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
     * @return
     */
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
}
