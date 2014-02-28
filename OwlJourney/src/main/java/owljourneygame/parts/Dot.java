

package owljourneygame.parts;
/**
 * X and Y coordinates
 */
public class Dot {
    protected int x;
    protected int y;
    
    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
