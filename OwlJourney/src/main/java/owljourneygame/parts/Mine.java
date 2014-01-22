package owljourneygame.parts;

public class Mine {
    protected int x;
    protected int y;
    protected int side;
    private boolean active;
    
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
    
    public int getSide(){
        return side;
    }
    
    public boolean isActive(){
        active = true;
        return true;
    }
    
    public boolean inActive(){
        active = false;
        return false;   //kun miinaan osutaan, siihen ei voi saman kentän aikana osua uudelleen(?)
    }

    /*
    Perusmiina ei liiku.
    Kentällä voi olla usea miina.
    Alustavaksi piirretään ihan pyöreiksi.
    Tällä hetkellä kaikki samankokoisia, mutta voi muuttua
    */
}
