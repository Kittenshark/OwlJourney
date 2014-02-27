

package ActionListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import owljourneygame.Game.GamePlatform;
import owljourneygame.Game.MoveSide;
import owljourneygame.parts.Owl;


public class ListenKeys implements KeyListener{
    GamePlatform game;

    
    public ListenKeys(GamePlatform game){
        this.game = game;
        //this.owl = owl;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            game.getOwl().setOwlDirection(MoveSide.R);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            game.getOwl().setOwlDirection(MoveSide.L);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            game.getOwl().setOwlDirection(MoveSide.D);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP){
            game.getOwl().setOwlDirection(MoveSide.U);
        }
        
        //oikea 0, vasen 1, alas 2, ylös 3
        
        game.PlayGame();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        }
    
}
