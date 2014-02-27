
package owljourneygame.parts;

public class MovingMine extends Mine{

    public MovingMine(int x, int y) {
        super(x, y, true);
    }
    
    public void MoveMine(int x, int y){
        this.x += x;
        this.y -= y;
        //miina liikkuu kentällä xy-koordinaatistolla
    }
    
}
