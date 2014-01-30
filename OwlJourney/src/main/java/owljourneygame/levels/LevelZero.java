

package owljourneygame.levels;

//ei käytössä

import java.util.ArrayList;
import owljourneygame.parts.Dot;
import owljourneygame.parts.FinishLine;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;

public class LevelZero implements Printable{
    
    private ArrayList<Wall> walls;
    private ArrayList<Mine> mines;
    private FinishLine goal;
    
    public LevelZero(){
        walls = new ArrayList<Wall>();
        mines = new ArrayList<Mine>();
    }
    
    public void walls(){ 
        walls.add(new Wall(0, 0, 360, 20)); //ylälaita
        walls.add(new Wall(360, 0, 20, 280)); //oikea laita
        walls.add(new Wall(0, 20, 20, 280)); //vasen laita
        walls.add(new Wall(20, 280, 360, 20)); //alalaita
        //first level is simple and easy
        //tbd
    }
    
    public void mines(){
        mines.add(new Mine(359, 22));
        mines.add(new Mine(37, 270));
        //tbd
    }
    
    public void goal(){
        goal = new FinishLine(350, 30);
    }
    
    public ArrayList getWalls(){
        return walls;
    }
    
    public ArrayList getMines(){
        return mines;
    }
    
    public FinishLine getGoal(){
        return goal;
    }
}
