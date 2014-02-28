/**
 * Main game happens here.
 */
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

public class GamePlatform {
    private ArrayList<AllLevels> levels;
    private int whichLevel;
    private Owl owl;
    private int lifepoints;
    private boolean isItMovingTime = false;
    private HoldLevel createL;
    private UserInterface draw;
    private boolean gameover = false;
    
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
    
    public void takeLives(){
        lifepoints--;
    }
    
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
     * @return Whether owl hit the mine or not
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
     * Plays the game
     * If player runs out of lifepoints game ends
     * Game ends if player clears all levels
     * Method triggers moving of owl and everything related to it
     * If goal is reached owl will get full energy
     */
    public void PlayGame() {
        if (lifepoints <= 0){
            gameover = true;
            //out of life
        }
        
        if (whichLevel >= levels.size()){
            gameover = true;
            System.out.println("YOU CLEARED THE GAME!");
            //out of levels
        }
        
        if (gameover == true){
            draw.gameEnded();
        }
        
        if (isItMovingTime){
           moveOwl(); 
        }
        
        if (hitMine()){
            takeLives();
        }   
        
        if (hitGoal()){
            goNextLevel();
            owl.setEnergy();
            owl.setOwl(levels.get(whichLevel).getOwlieStartX(), levels.get(whichLevel).getOwlieStartY());
        }
        
        isItMovingTime = false;
           
        draw.letsPaint(); 
    }   
    
    public void setDraw(UserInterface face){
        this.draw = face;
    }
    
    public void setIsItMovingTime(boolean moveOrNot){
        isItMovingTime = moveOrNot;
    }
}
