
package owljourneygame.parts;


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
    
}
