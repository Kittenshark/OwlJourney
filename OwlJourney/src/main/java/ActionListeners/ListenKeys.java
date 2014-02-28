

package ActionListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import owljourneygame.Game.GamePlatform;
import owljourneygame.Game.MoveSide;

/**
 * KeyListener that listens keys a, s, d, w, 1 and 2
 */
public class ListenKeys implements KeyListener{
    GamePlatform game;

    
    public ListenKeys(GamePlatform game){
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!game.getBoom()){
          if (e.getKeyCode() == KeyEvent.VK_D){
            game.getOwl().setOwlDirection(MoveSide.R);
            game.setIsItMovingTime(true);
        } 
        if (e.getKeyCode() == KeyEvent.VK_A){
            game.getOwl().setOwlDirection(MoveSide.L);
            game.setIsItMovingTime(true);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_S){
            game.getOwl().setOwlDirection(MoveSide.D);
            game.setIsItMovingTime(true);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_W){
            game.getOwl().setOwlDirection(MoveSide.U);
            game.setIsItMovingTime(true);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_2){
            game.getOwl().setOwlDirection(MoveSide.U);
            if (game.getOwl().getEnergy() >= 20){
                game.setIsItMovingTime(true);
                game.moveOwl();
                game.moveOwl();
                game.moveOwl();
                game.getOwl().loseEnergy(20);
            }    
        }
        if (e.getKeyCode() == KeyEvent.VK_3){
            game.getOwl().setOwlDirection(MoveSide.U);
            if (game.getOwl().getEnergy() >= 50){
              game.setIsItMovingTime(true);
              for (int i=0; i<4; i++){
                  game.moveOwl();
              }  
              game.getOwl().loseEnergy(50);
            }
            
        }
        }
        
        
        if (e.getKeyCode() == KeyEvent.VK_4){
            game.repaintField();
            game.setBoom(false);
        }
        
        //oikea 0, vasen 1, alas 2, ylös 3
        
        game.PlayGame();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        }
    
}
