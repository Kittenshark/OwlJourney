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
    protected int side;
    /**
     * Tells if the mine is active. If mine is active, it can hit and damage player
     */
    private boolean active;
    
    /**
     * Sets mine values
     * When mine is created, it is active
     * @param x X-axis location
     * @param y Y-axis location
     */
    public Mine(int x, int y){
        this.x = x;
        this.y = y;
        active = true;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setSide(int side){
        this.side = side;
    }
    
    public int getSide(){
        return side;
    }
    
    /**
     * Sets mine active
     */
    public void setActive(){
        active = true;
    }
    
    /**
     * Sets mine inactive
     */
    public void setInActive(){
        active = false;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, side, side);
    }

    /*
    Perusmiina ei liiku.
    Kentällä voi olla usea miina.
    Alustavaksi piirretään ihan pyöreiksi.
    Tällä hetkellä kaikki samankokoisia, mutta voi muuttua
    */
}
