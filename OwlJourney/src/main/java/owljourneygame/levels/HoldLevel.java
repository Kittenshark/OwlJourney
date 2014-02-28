

package owljourneygame.levels;

import java.util.ArrayList;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;

/**
 * Keeps all levels
 * Has information of all parts the game needs to create levels
 * Includes all mines, walls
 */
public class HoldLevel {
    ArrayList<Mine> zeroMine;
    ArrayList<Wall> oneWall;
    ArrayList<Mine> oneMine;
    ArrayList<Wall> twoWall;
    ArrayList<Mine> twoMine;
    
    
    public HoldLevel(){   
        zeroMine = new ArrayList<Mine>();
        oneWall = new ArrayList<Wall>();
        oneMine = new ArrayList<Mine>();
        twoWall = new ArrayList<Wall>();
        twoMine = new ArrayList<Mine>();
        createLevelZeroMines();
        createLevelOneWalls();
        createLevelOneMines();
        createLevelTwoWalls();
        createLevelTwoMines();
    }/**
     * Creates mines for help up level, level zero
     */
    private void createLevelZeroMines(){
        int helpNumber = 20;
        for (int i=0; i<15; i++){
            zeroMine.add(new Mine(helpNumber, 220, true));
            helpNumber += 20;
        }
        
        helpNumber = 60;
        for (int i=0; i<15; i++){
            zeroMine.add(new Mine(helpNumber, 185, true));
            helpNumber += 20;
        }
        
        helpNumber = 60;
        for (int i=0; i<15; i++){
            zeroMine.add(new Mine(helpNumber, 170, true));
            helpNumber += 20;
        }
    }
    
    public ArrayList<Mine> getZeroMines(){
        return zeroMine;
    }
    
    /**
     * Creates all the walls for the level one
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
        oneMine.add(new Mine(160, 150, false)); //false
        oneMine.add(new Mine(160, 170, false)); //false
        oneMine.add(new Mine(165, 70, false)); //false
    }
    
    public ArrayList<Mine> getOneMines(){
        return oneMine;
    }
    
    public void createLevelTwoWalls(){
        twoWall.add(new Wall(170, 170, 60, 20));
        twoWall.add(new Wall(210, 120, 20, 60));
        twoWall.add(new Wall(120, 120, 110, 20));
        twoWall.add(new Wall(120, 120, 20, 100));
        
        twoWall.add(new Wall(120, 220, 140, 20));
        twoWall.add(new Wall(260, 100, 20, 140));
        twoWall.add(new Wall(80, 80, 200, 20));
    }
    
    public void createLevelTwoMines(){
        twoMine.add(new Mine(105, 65, false));
        twoMine.add(new Mine(115, 50, false));
        twoMine.add(new Mine(100, 30, false));
        
        int helpNumber = 280;
        for (int i=0; i<3; i++){
            twoMine.add(new Mine(helpNumber, 220, true));
            helpNumber += 30;
        }
        helpNumber = 280;
        for (int i=0; i<3; i++){
            twoMine.add(new Mine(helpNumber, 180, true));
            helpNumber += 30;
        }
        helpNumber = 280;
        for (int i=0; i<3; i++){
            twoMine.add(new Mine(helpNumber, 140, true));
            helpNumber += 30;
        }
        helpNumber = 280;
        for (int i=0; i<4; i++){
            twoMine.add(new Mine(helpNumber, 60, true));
            helpNumber += 20;
        }
    }
    
    public ArrayList<Wall> getTwoWalls(){
        return twoWall;
    }
    
    public ArrayList<Mine> getTwoMines(){
        return twoMine;
    }
}
