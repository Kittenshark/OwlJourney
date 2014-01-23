

package owljourneygame.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import owljourneygame.Game.GamePlatform;
import owljourneygame.draw.DrawWalls;


public class UserInterface implements Runnable{

    private JFrame frame;
    private GamePlatform game;    
    //private DrawWalls wallDraw;
    
    public UserInterface(GamePlatform game) {
        this.game = game;
    }

    @Override
    public void run() {
        frame = new JFrame("OwlJourney");
         
        frame.setPreferredSize(new Dimension(380, 300));
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        createComponents(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
                
    }
 
    public void createComponents(Container container) {

    }
 
 
    public JFrame getFrame() {
        return frame;
    }
    
    
}
