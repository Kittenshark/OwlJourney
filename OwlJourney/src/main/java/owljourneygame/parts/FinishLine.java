

package owljourneygame.parts;

/**
 * Goal
 * Level is complete if the owl reaches goal
 */
import java.awt.Rectangle;

public class FinishLine extends Dot{
    final private int size = 20;
    
    public FinishLine(int x, int y){
        super(x, y);
        this.x = x;
        this.y = y;
    }
    
    public int getSide(){
        return size;
    }
    
    /**
     * 
     * @return Rectangle of goal
     */
    public Rectangle getBounds(){
        return new Rectangle(x, y, 20, 20);
    }
}
