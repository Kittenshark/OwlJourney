

package owljourneygame.levels;

import java.util.ArrayList;
import owljourneygame.parts.Dot;
import owljourneygame.parts.FinishLine;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;

public class LevelOne extends LevelBase implements Printable{
    
    private ArrayList<Wall> walls;
    private ArrayList<Mine> mines;
    private FinishLine goal;
    
    public LevelOne(){
        walls = new ArrayList<Wall>();
        mines = new ArrayList<Mine>();
    }
    
    public void walls(){
        walls.add(new Wall(1, 1, 368, 10)); //ylälaita
        walls.add(new Wall(369, 1, 10, 288)); //oikea laita
        walls.add(new Wall(1, 11, 10, 288)); //vasen laita
        walls.add(new Wall(11, 289, 268, 10)); //alalaita
        //first level is simple and easy
        //tbd
    }
    
    public void mines(){
        mines.add(new Mine(359, 22));
        mines.add(new Mine(37, 270));
        //tbd
    }
    
    public void goal(){
        goal = new FinishLine(359, 11);
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
    
    public void printLevel(){ //väliaikainen
       
        for (int i=0; i<width;i++){
            for (int j=0; j<height; j++){
                System.out.print("o");
            }
            System.out.println();
        }
        
        /*
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                boolean printed = false;
                for (Dot avain : lista){
                    if (avain.getX() == i && avain.getY() == j){
                        System.out.print("o");
                        printed = true;
                    }
                } if (!printed){
                    System.out.print("-");
                    printed = false;
                }
            }
            System.out.println();
        }
                */
    }
}
