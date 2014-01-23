

package owljourneygame.parts;

public class Goal {
    private int x;
    private int y;
    
    public Goal(int x, int y){
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
        //goal, mine, owl sivun pituus 10, prob side muuttuja tulee tippumaan
    }
}
