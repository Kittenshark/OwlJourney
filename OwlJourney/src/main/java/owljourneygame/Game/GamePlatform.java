
package owljourneygame.Game;

import java.util.ArrayList;
import owljourneygame.levels.LevelOne;
import owljourneygame.levels.Printable;
import owljourneygame.parts.Dot;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Owl;

public class GamePlatform {
    private ArrayList<Printable> levels;
    private int whichLevel = 1;
    private Owl owl;
    private int lifepoints;
    
    public GamePlatform(){
        lifepoints = 3;
        levels = new ArrayList<Printable>();
        createOwl();
        createLevels();
    }
    
    public void runGame(){
        while (whichLevel < 2){
            runLevels();
            whichLevel++;
        }
    }
    
    public void createOwl(){
        owl = new Owl(12, 270, 10); //ensimmäisen levelin aloituspiste, vaihtuu per level 
    }
    
    public Owl getOwl(){
        return owl;//tarkoitus muuttua
    }
    
    public void createLevels(){
        //LevelOne one = new LevelOne();
        levels.add(new LevelOne()); //level one
    }
    
    public void runLevels(){
        //levels.get(whichLevel-1).printLevel(); paperiprinttaukseen


    }
    
    public boolean hitWall(){
        ArrayList<Dot> walls = new ArrayList<Dot>();
        walls = levels.get(whichLevel-1).getWalls();
        
        for (Dot dot : walls){
            if (dot.getX() == owl.getX() && dot.getY() == owl.getY()){
                return true;    //Jos osutaan seinään, ei liikuta sen lävitse
            }
        }
        return false;   
    }
    
    public boolean hitMine(){
        ArrayList<Mine> mines = new ArrayList<Mine>();
        mines = levels.get(whichLevel-1).getMines();
        
        for (Mine mine : mines){
            if (mine.getX() == owl.getX() && mine.getY() == owl.getY() && mine.isActive()){
                mine.inActive(); //Jos kenttä aloitetaan alusta, kaikki miinat active ellei jotain lisafeature jos jaksaa/aikaa
                return true;    //Jos osutaan miinaan, hahmo kuolee (tai menettää elämän)
            }
        }
        return false;   
    }
    
    public boolean hitGoal(){
        return false;
    }
    
    public boolean moveOwl(){
        //action listeners sun muuta
        //left, right, up, down
        owl.moveOwl(1, 1);
        return false;
    }

            
}
