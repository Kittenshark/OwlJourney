

package ActionListeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import owljourneygame.Game.GamePlatform;
import owljourneygame.parts.Owl;


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
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            game.moveOwl(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            game.moveOwl(1);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            game.moveOwl(2);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP){
            game.moveOwl(3);
        }
        
        //oikea 0, vasen 1, alas 2, ylös 3, kein enum
    }

    @Override
    public void keyReleased(KeyEvent e) {
        }
    
}
