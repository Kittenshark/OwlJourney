

package ActionListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import owljourneygame.Game.GamePlatform;
import owljourneygame.Game.MoveSide;
import owljourneygame.parts.Owl;


public class ListenKeys implements KeyListener{
    GamePlatform game;
    Owl owl;
    
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
            game.whereToMove(MoveSide.R);
            //game.moveOwl(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            game.whereToMove(MoveSide.L);
            //game.moveOwl(1);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            game.whereToMove(MoveSide.D);
            //game.moveOwl(2);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP){
            game.whereToMove(MoveSide.U);
            //game.moveOwl(3);
        }
        
        //oikea 0, vasen 1, alas 2, ylös 3
    }

    @Override
    public void keyReleased(KeyEvent e) {
        }
    
}
