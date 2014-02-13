
package owljourneygame.Game;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import owljourneygame.gui.UpdateGame;
import owljourneygame.levels.AllLevels;
import owljourneygame.levels.HoldLevel;
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
    private MoveSide where;
    private HoldLevel createL;
    
    public GamePlatform(){
        createL = new HoldLevel();
        lifepoints = 3;
        whichLevel = 0; //vaihda 0 
        levels = new ArrayList<AllLevels>();
        createOwl();
        createLevels();
    }
    
    public void createOwl(){
        owl = new Owl(30, 240, 10); //ensimmäisen levelin aloituspiste, vaihtuu per level 
    }
    
    public Owl getOwl(){
        return owl;
    }
   
    /**
     * Creates the levels of the game.
     * 
     **/
    public void createLevels(){
        //ei tule ongelmia, jos samaa luokkaa 
        //level 0
        levels.add(new AllLevels(new FinishLine(350, 30)));
        
        //level 1
        levels.add(new AllLevels(new FinishLine(210, 40))); 
        ArrayList<Wall> oneW = createL.getLevelOneWalls(); 
        //oneW = createL.getLevelOneWalls();
        levels.get(1).addWalls(oneW);
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
    
    /**
     * Checks if the owl hits a mine.
     * 
     * @return Whether owl hit the mine or not
     */
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
    
    /**
     * Moves owl to left, right, up or down.
     * Checks first whether Owl will hit wall or not.
     */
    public void moveOwl(){
        if (!wallCollision()){ //kein
            owl.moveOwl(where.getWhere());  
        }
        System.out.println("x = "+owl.getX()+" | y = "+owl.getY());
    }
    /**
    * Method check if owl hits a wall.
    * If Owl hits the wall, it wont move across it.
    * @return does owl hit wall or not
    **/
    public boolean wallCollision(){
        int wherex = 0;
        int wherey = 0;
        if (where.getWhere() == 0){
            wherex = 10;
        } else if (where.getWhere() == 1){
            wherex = -10;
        } else if (where.getWhere() == 2){
            wherey = 10;
        } else {
            wherey = -10;
        }

        for (Wall wall : getLevel().getWalls()){
            int rx = wall.getX()+wall.getWidth(); //upper right coordinates
            int ry = wall.getY()+wall.getHeight(); //bottom left coordinates

            if (wall.getX() <= owl.getX()+wherex && owl.getX()+wherex <= rx && wall.getY() >= owl.getY()+wherey && owl.getY()+wherey >= ry){
                return true;
            }
        }
        
        return false;
    }
    
    public void whereToMove(MoveSide where){
        this.where = where;
    }
    
    //tbd later, kein listen
    @Override
    public void actionPerformed(ActionEvent e) {
        moveOwl();
        
        if (hitMine()){
            takeLives();
        }   
        
        if (hitGoal()){
            goNextLevel();
        }
        
        update.update();
    }

    
    public void takeLives(){
        lifepoints--;
    }
    
    public void goNextLevel(){
        whichLevel++;
    }

            
}
