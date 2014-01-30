
package owljourneygame.Game;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import owljourneygame.gui.UpdateGame;
import owljourneygame.levels.AllLevels;
import owljourneygame.parts.Dot;
import owljourneygame.parts.FinishLine;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Owl;
import owljourneygame.parts.Wall;

public class GamePlatform implements ActionListener{
    private ArrayList<AllLevels> levels;
    private int whichLevel;
    private Owl owl;
    private int lifepoints;
    private UpdateGame update;
    
    public GamePlatform(){
        lifepoints = 3;
        whichLevel = 0;
        levels = new ArrayList<AllLevels>();
       // level = new GiefLevel();
        createOwl();
        createLevels();
        //runGame();
    }
    
    public void runGame(){
        //turha? ...
    }
    
    public void createOwl(){
        owl = new Owl(30, 240, 10); //ensimmäisen levelin aloituspiste, vaihtuu per level 
    }
    
    public Owl getOwl(){
        return owl;
    }
   
    public void createLevels(){
        //ei tule ongelmia, jos samaa luokkaa 
        levels.add(new AllLevels(new FinishLine(350, 30)));
        levels.add(new AllLevels(new FinishLine(180, 40)));
    }
    
    public AllLevels getLevel(){
        return levels.get(whichLevel);
    }
    
    public ArrayList<AllLevels> getAllLevels(){
        return levels;
    }
    
    public int getWhichLevel(){
        return whichLevel;
    }
    
    public boolean hitWall(){
        
        for (Wall wall : levels.get(whichLevel).getWalls()){
            if (wall.getX() == owl.getX() && wall.getY() == owl.getY()){
                return true;    //Jos osutaan seinään, ei liikuta sen lävitse
            }
        }
        return false;   
    }
    
    public boolean hitMine(){
        Rectangle o = owl.getBounds();
        for (Mine mine : getLevel().getMines()){
            Rectangle m = mine.getBounds();
            if (o.intersects(m)){
                return true;
            }
        }  
        return false;
    }
    
    public boolean hitGoal(){
        return false;
    }
    
    public void moveOwl(int side){
        if (!wallCollision()){ //kein
            owl.moveOwl(side);  
        }
        
        /*
        action listeners sun muuta
        left, right, up, down, miinus/plus etc
        1 liikkuminen liikkuu pöllön koko koon verran
                */
    }
    
    public boolean wallCollision(){
        Rectangle o = owl.getBounds();
        //hm
        for (Wall wall : getLevel().getWalls()){
            Rectangle w = wall.getBounds();
            System.out.println(w.intersection(w));
            if (w.intersects(o)){ //kein work yet, jos menee kokonaan sisään
                return true;
            }
        }
        
        return false;
    }
    
    //tbd later
    @Override
    public void actionPerformed(ActionEvent e) {
        if (hitMine()){
            takeLives();
        }
        if (hitWall()){
            
        }
        if (hitGoal()){
            goNextLevel();
        }
        
        update.update();
        //collision
    }

    
    public void takeLives(){
        lifepoints--;
    }
    
    public void goNextLevel(){
        whichLevel++;
    }

            
}
