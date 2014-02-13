

package owljourneygame.parts;

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
        return 10;
        //goal, mine, owl sivun pituus 10
    }
}
