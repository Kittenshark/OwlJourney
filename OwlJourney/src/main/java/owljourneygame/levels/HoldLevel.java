/**
 * Keeps all levels
 * Has information of all parts the game needs to create levels
 * Includes all mines, walls
 */

package owljourneygame.levels;

import java.util.ArrayList;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;


public class HoldLevel {
    ArrayList<Mine> zeroMine;
    ArrayList<Wall> oneWall;
    ArrayList<Mine> oneMine;
    ArrayList<Wall> twoWall;
    
    
    public HoldLevel(){   
        zeroMine = new ArrayList<Mine>();
        oneWall = new ArrayList<Wall>();
        oneMine = new ArrayList<Mine>();
        twoWall = new ArrayList<Wall>();
        createLevelZeroMines();
        createLevelOneWalls();
        createLevelOneMines();
        createLevelTwoWalls();
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
        oneMine.add(new Mine(160, 150, true)); //false
        oneMine.add(new Mine(160, 170, true)); //false
        oneMine.add(new Mine(165, 70, true)); //false
    }
    
    public ArrayList<Mine> getOneMines(){
        return oneMine;
    }
    
    public void createLevelTwoWalls(){
        twoWall.add(new Wall(170, 170, 60, 20));
        twoWall.add(new Wall(210, 120, 20, 60));
        twoWall.add(new Wall(120, 120, 110, 20));
        twoWall.add(new Wall(120, 120, 20, 100));
    }
    
    public ArrayList<Wall> getTwoWalls(){
        return twoWall;
    }
}
