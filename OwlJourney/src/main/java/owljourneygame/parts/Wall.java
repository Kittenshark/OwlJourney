
package owljourneygame.parts;

import java.awt.Graphics;


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
    
    public void draw(Graphics graphics){
        graphics.fillRect(super.getX(), super.getY(), width, height);
    }
    
}
