

package owljourneygame.levels;

import java.util.ArrayList;
import owljourneygame.parts.FinishLine;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;


public class AllLevels {
    FinishLine goal;
    ArrayList<Mine> mines;
    ArrayList<Wall> walls;
    
    public AllLevels(FinishLine goal){
        this.goal = goal;
        walls = new ArrayList<Wall>();
        mines = new ArrayList<Mine>();
        setWalls();
    }
    
    /**
     * Creates side walls for the game that every level has
     */
    public void setWalls(){
        walls.add(new Wall(0, 0, 360, 20)); //ylälaita
        walls.add(new Wall(360, 0, 20, 280)); //oikea laita
        walls.add(new Wall(0, 20, 20, 280)); //vasen laita
        walls.add(new Wall(20, 280, 360, 20)); //alalaita
    }
    
    public FinishLine getGoal(){
        return goal;
    }
    
    public ArrayList<Mine> getMines(){
        return mines;
    }
    
    public ArrayList<Wall> getWalls(){
        return walls;
    }
    
    /**
     * Method adds one wall to the wanted level
     * @param wall single wall that is being added
     */
    public void addWall(Wall wall){
        walls.add(wall);
    }
    
    /**
     * Method adds new walls to the wanted level
     * @param manyWalls List of walls that are being added
     */   
    public void addWalls(ArrayList<Wall> manyWalls){
        for (Wall w : manyWalls){
            walls.add(w);
        }
    }
    
    /**
     * Adds one mine to the wanted level
     * @param mine Mine that is being added
     */
    public void addMine(Mine mine){
        mines.add(mine);
    }
    
    /**
     * Adds many mines in a list to the wanted level
     * @param manyMines List of mines
     */
    public void addMines(ArrayList<Mine> manyMines){
       for (Mine m : manyMines){
            mines.add(m);
        } 
    }
}
