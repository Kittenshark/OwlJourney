

package owljourneygame.owljourney;

import javax.swing.SwingUtilities;
import owljourneygame.Game.GamePlatform;
import owljourneygame.gui.UserInterface;


public class App {
    public static void main( String[] args ){
        
        GamePlatform game = new GamePlatform();
        
        UserInterface face = new UserInterface(game);
        
        SwingUtilities.invokeLater(face);
        
        game.runGame();
    }
}
