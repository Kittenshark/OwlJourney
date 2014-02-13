

package owljourneygame.levels;

import java.util.ArrayList;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;


public class HoldLevel {
    ArrayList<Wall> oneWall;
    ArrayList<Mine> oneMine = new ArrayList<Mine>();
    
    public HoldLevel(){      
        oneWall = new ArrayList<Wall>();
        createLevelOneWalls();
        createLevelOneMines();
    }
    
    /**
     * Creates all the walls for the first level
     */
    private void createLevelOneWalls(){
        oneWall.add(new Wall(10, 10, 80, 280));
        oneWall.add(new Wall(280, 10, 80, 280));
        
        oneWall.add(new Wall(90, 240, 70, 50));
        oneWall.add(new Wall(190, 240, 90, 50));
        
        oneWall.add(new Wall(90, 10, 110, 50));
        oneWall.add(new Wall(230, 10, 90, 50));
        
        oneWall.add(new Wall(110, 100, 50, 100));
        oneWall.add(new Wall(180, 100, 50, 100));
    }
    
    public ArrayList<Wall> getLevelOneWalls(){
        return oneWall;
    }
    
    /**
     * Creates all the mines for level one 
     */
    private void createLevelOneMines(){
        
    }
    
    public ArrayList<Mine> getOneMines(){
        return oneMine;
    }
}