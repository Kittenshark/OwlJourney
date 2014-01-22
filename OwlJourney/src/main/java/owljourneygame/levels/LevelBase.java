
package owljourneygame.levels;



public abstract class LevelBase {
    
    protected int width;
    protected int height;
    
    public LevelBase(){
        width = 380;
        height = 300;    //atm käyttöliittymän mukaan
        //printtaukseen vähän liian suuria numeroita
    }
    
    abstract void walls();
    
    abstract void mines();
    
    
}
