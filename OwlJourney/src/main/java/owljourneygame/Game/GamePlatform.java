
package owljourneygame.Game;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import owljourneygame.gui.Draw;
import owljourneygame.gui.UpdateGame;
import owljourneygame.gui.UserInterface;
import owljourneygame.levels.AllLevels;
import owljourneygame.levels.HoldLevel;
import owljourneygame.parts.Dot;
import owljourneygame.parts.FinishLine;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Owl;
import owljourneygame.parts.Wall;

public class GamePlatform {
    private ArrayList<AllLevels> levels;
    private int whichLevel;
    private Owl owl;
    private int lifepoints;
    private HoldLevel createL;
    private UserInterface draw;
    
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
     * Creates the levels of the game.
     * 
     **/
    public void createLevels(){
        //level 0
        levels.add(new AllLevels(0, 0, new FinishLine(350, 30)));
        
        //level 1
        levels.add(new AllLevels(170, 265, new FinishLine(210, 40))); 
        ArrayList<Wall> oneW = createL.getLevelOneWalls(); 
        levels.get(1).addWalls(oneW);
        levels.get(1).addMines(createL.getOneMines());
        
        //level2
        levels.add(new AllLevels(190, 150, new FinishLine(330, 40)));
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
            if (mine.getActive() == true){
                if (o.intersects(m) || m.contains(o)){
                    mine.setInActive();
                    System.out.println("osuttiin miinaan");
                    return true;
                } 
            }
            
        }  
        return false;
    }
    
    public boolean hitGoal(){
        Rectangle o = owl.getBounds();
        Rectangle f = levels.get(whichLevel).getGoal().getBounds();
        if (o.intersects(f)){
            System.out.println("Osuttiin maaliin");
                return true;

        }
        return false;
    }
    
    /**
     * Moves owl to left, right, up or down.
     * Checks first whether Owl will hit wall or not.
     */
    public void moveOwl(){
        if (!wallCollision()){
            owl.moveOwl();  
        }
        System.out.println("x = "+owl.getX()+" | y = "+owl.getY());
    }
    
    /**
    * Checks if owl hits any walls.
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
        
        Rectangle o = new Rectangle(owl.getX()+owlIsMovingX, owl.getY()+owlIsMovingY, owl.getSize(), owl.getSize());
        for (Wall wall : getLevel().getWalls()){
            Rectangle w = wall.getBounds();
            if (o.intersects(w) || w.contains(o)){
                System.out.println("osuttiin seinään");
                return true;
            }
        }
        return false;
    }
    
    public void PlayGame() {
        if (lifepoints <= 0){
            return;
            //game ends
        }
        
        if (whichLevel >= levels.size()){
            return;
            //out of levels
        }
        moveOwl();
        
        if (hitMine()){
            takeLives();
        }   
        
        if (hitGoal()){
            goNextLevel();
            owl.setOwl(levels.get(whichLevel).getOwlieStartX(), levels.get(whichLevel).getOwlieStartY());
        }
        
        draw.letsPaint();
    }   
    
    public void setDraw(UserInterface face){
        this.draw = face;
    }
}
