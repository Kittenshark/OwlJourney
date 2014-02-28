
package owljourneygame.Game;

import java.awt.Rectangle;
import java.util.ArrayList;
import owljourneygame.gui.UserInterface;
import owljourneygame.levels.AllLevels;
import owljourneygame.levels.HoldLevel;
import owljourneygame.parts.FinishLine;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Owl;
import owljourneygame.parts.Wall;

/**
 * Main game happens here.
 * Logic of the game is implemented here
 */
public class GamePlatform {
    /**
     * Includes all playable levels
     */
    private ArrayList<AllLevels> levels;
    /**
     * Indicates current level
     */
    private int whichLevel;
    private Owl owl;
    /**
     * How much life owl has
     */
    private int lifepoints;
    /**
     * Will owl move or not
     */
    private boolean isItMovingTime = false;
    private HoldLevel createL;
    private UserInterface draw;
    private boolean gameover = false;
    private boolean boom = false;
    
    public GamePlatform(){
        createL = new HoldLevel();
        lifepoints = 3;
        whichLevel = 0; //vaihda 0 
        levels = new ArrayList<AllLevels>();
        createOwl();
        createLevels();
    }
    
    public void createOwl(){
        owl = new Owl(30, 240, 15); //ensimmäisen levelin aloituspiste, vaihtuu per level 
    }
   
    /**
     * Creates all levels for the game.
     * 
     **/
    public void createLevels(){
        //level 0
        levels.add(new AllLevels(0, 0, new FinishLine(340, 30)));
        levels.get(0).addMines(createL.getZeroMines());
        
        //level 1
        levels.add(new AllLevels(170, 265, new FinishLine(210, 40))); 
        ArrayList<Wall> oneW = createL.getLevelOneWalls(); 
        levels.get(1).addWalls(oneW);
        levels.get(1).addMines(createL.getOneMines());
        
        //level2
        levels.add(new AllLevels(190, 150, new FinishLine(330, 40)));
        levels.get(2).addWalls(createL.getTwoWalls());
        levels.get(2).addMines(createL.getTwoMines());
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
    
    public boolean getGameOver(){
        return gameover;
    }
    
    public boolean getBoom(){
        return boom;
    }
    
    /**
     * Decreases owls lifepoints.
     */
    public void takeLives(){
        lifepoints--;
    }
    
    /**
     * When level is completed, method sets next level for the player.
     * If player is playing last level game will end insted of moving to next level.
     */
    public void goNextLevel(){
        if ((whichLevel + 1) < levels.size()){
            whichLevel++; 
        } else {
            gameover = true;
        }
    }
    /**
     * Checks if player hits a mine.
     * 
     * @return Whether owl hits mines or not
     */
    public boolean hitMine(){
        Rectangle o = owl.getBounds();
        for (Mine mine : getLevel().getMines()){
            Rectangle m = mine.getBounds();
            if (mine.getActive() == true){
                if (o.contains(m) || o.intersects(m)){
                    mine.setInActive();
                    //draw.mineWasHit();
                    return true;
                } 
            }
            
        }  
        return false;
    }
    
    /**
     * Checks if player hits the goal
     * @return whether owl hit goal or not
     */
    public boolean hitGoal(){
        Rectangle o = owl.getBounds();
        Rectangle f = levels.get(whichLevel).getGoal().getBounds();
        if (f.contains(o)){
                return true;

        }
        return false;
    }
    
    /**
     * Moves owl to left, right, up or down.
     * Checks first whether Owl will hit wall or not.
     * Owl will move only if it does not hit any walls
     */
    public void moveOwl(){
        if (!wallCollision()){
            owl.moveOwl();  
        }
    }
    
    /**
    * Checks if owl hits any walls.
    * If Owl hits the wall, it wont move across it.
    * @return does owl hit a wall or not
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
        
        Rectangle o = new Rectangle(owl.getX()+owlIsMovingX, owl.getY()+owlIsMovingY, owl.getSize(), owl.getSize());
        for (Wall wall : getLevel().getWalls()){
            Rectangle w = wall.getBounds();
            if (o.intersects(w)){
                return true;
            }
        }
        return false;
    }
    /**
     * Plays the game.
     * If player runs out of lifepoints, game ends. Game also ends if player clears all levels.
     * Method triggers moving of owl and everything related to it.
     * Also checks if owl hit any mines or goal.
     * If goal is reached owl will get full energy.
     * If player clicks any keys other than intentioned keys, owl will not move.
     * After method is completed, isItMovingTime is set false so player can not move without playing along game mechanics.
     */
    public void PlayGame() {
        if (lifepoints <= 0){
            gameover = true;
            //out of life
        }
        
        if (gameover == true){
            draw.gameEnded();
        }
        
        if (isItMovingTime){
           moveOwl(); 
        }
        
        if (hitMine()){
            boom = true;
            takeLives();
        }   
        
        if (hitGoal()){
            goNextLevel();
            owl.setEnergy();
            owl.setOwl(levels.get(whichLevel).getOwlieStartX(), levels.get(whichLevel).getOwlieStartY());
        }
        
        isItMovingTime = false;
           
        repaintField(); 
    }   
    
    public void repaintField(){
        draw.letsPaint();
    }
    
    public void setDraw(UserInterface face){
        this.draw = face;
    }
    
    public void setIsItMovingTime(boolean moveOrNot){
        isItMovingTime = moveOrNot;
    }
    
    public void setBoom(boolean boom){
        this.boom = boom;
    }
}
