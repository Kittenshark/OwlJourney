
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

public class GamePlatform implements ActionListener {
    private ArrayList<AllLevels> levels;
    private int whichLevel;
    private Owl owl;
    private int lifepoints;
    private UpdateGame update;
    private HoldLevel createL;
    
    public GamePlatform(){
        createL = new HoldLevel();
        lifepoints = 3;
        whichLevel = 1; //vaihda 0 
        levels = new ArrayList<AllLevels>();
        createOwl();
        createLevels();
    }
    
    public void createOwl(){
        owl = new Owl(30, 240, 15); //ensimmäisen levelin aloituspiste, vaihtuu per level 
    }
   
    /**
     * Creates the levels of the game.
     * 
     **/
    public void createLevels(){
        //level 0
        levels.add(new AllLevels(new FinishLine(350, 30)));
        
        //level 1
        levels.add(new AllLevels(new FinishLine(210, 40))); 
        ArrayList<Wall> oneW = createL.getLevelOneWalls(); 
        levels.get(1).addWalls(oneW);
        levels.get(1).addMines(createL.getOneMines());
    }
    
    public Owl getOwl(){
        return owl;
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
       
    public int getLifePoints(){
        return lifepoints;
    }
    
    public void setUpdate(UpdateGame update){
        this.update = update;
    }
    
    public void takeLives(){
        lifepoints--;
    }
    
    public void goNextLevel(){
        whichLevel++;
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
        Rectangle o = owl.getBounds();
        Rectangle f = levels.get(whichLevel).getGoal().getBounds();
        if (o.intersects(f)){
                owl.setOwl(185, 270);
                return  true;

        }
        return false;
    }
    
    /**
     * Moves owl to left, right, up or down.
     * Checks first whether Owl will hit wall or not.
     */
    public void moveOwl(){
        if (!wallCollision()){ //kein
            owl.moveOwl();  
        }
        System.out.println("x = "+owl.getX()+" | y = "+owl.getY());
    }
    
    /**
    * Method check if owl hits a wall.
    * If Owl hits the wall, it wont move across it.
    * @return does owl hit wall or not
    **/
    public boolean wallCollision(){
        int owlIsMovingX = 0;
        int owlIsMovingY = 0;
        if (owl.getMoveDirection().getWhere() == 0){
            owlIsMovingX = 10;
        } else if (owl.getMoveDirection().getWhere() == 1){
            owlIsMovingX = -10;
        } else if (owl.getMoveDirection().getWhere() == 2){
            owlIsMovingY = 10;
        } else if (owl.getMoveDirection().getWhere() == 3){
            owlIsMovingY = -10;
        }
        
        int owlFutureX = owl.getX()+owlIsMovingX;
        int owlFutureY = owl.getY()+owlIsMovingY;

        for (Wall wall : getLevel().getWalls()){
            //x, y = left top
            //x, ry = left bottom
            //rx, y = right top
            //rx, ry = right bottom
            int rx = wall.getX()+wall.getWidth(); //upper right coordinates
            int ry = wall.getY()+wall.getHeight(); //bottom left coordinates
            
            if (owlFutureX > wall.getX() && owlFutureY > wall.getY()){
                //if 
            }
            if (owlFutureX > wall.getX() && owlFutureY < ry){
                //
            }
            if (owlFutureX < rx && owlFutureY < ry){
                
            }


            if (wall.getX() <= owl.getX()+owlIsMovingX && owl.getX()+owlIsMovingX <= rx && wall.getY() >= owl.getY()+owlIsMovingY && owl.getY()+owlIsMovingY >= ry){
                return true;
            }
        }
        
        return false;
    }
    
    //kein listen, ei lue tänne
    @Override
    public void actionPerformed(ActionEvent e) {
        if (lifepoints <= 0){
            //game ends
        }
        System.out.println("HELLO");
        moveOwl();
        
        if (hitMine()){
            takeLives();
        }   
        
        if (hitGoal()){
            goNextLevel();
        }
        
        
        update.update();
    }        
}
