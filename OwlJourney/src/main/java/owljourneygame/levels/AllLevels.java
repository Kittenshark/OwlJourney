

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
    
    public void setWalls(){
        walls.add(new Wall(0, 0, 360, 20)); //ylälaita
        walls.add(new Wall(360, 0, 20, 280)); //oikea laita
        walls.add(new Wall(0, 20, 20, 280)); //vasen laita
        walls.add(new Wall(20, 280, 360, 20)); //alalaita
        //kaikilla leveleillä samat reunaseinät
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
    
    public void addWall(Wall wall){
        walls.add(wall);
    }
    
    public void addWalls(ArrayList<Wall> manyWalls){
        for (Wall w : manyWalls){
            walls.add(w);
        }
    }
    
    public void addMine(Mine mine){
        mines.add(mine);
    }
}
