

package owljourneygame.gui;

import ActionListeners.ListenKeys;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import owljourneygame.Game.GamePlatform;


public class UserInterface implements Runnable{

    private JFrame frame;
    private GamePlatform game;    
    private Draw draw;
    
    public UserInterface(GamePlatform game) {
        this.game = game;
    }

    @Override
    public void run() {
        frame = new JFrame("OwlJourney");
        
        frame.setPreferredSize(new Dimension(395, 335));
        //380, 300
        
        //frame.getContentPane().setBackground(Color.green);
        
 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        createComponents(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);    
    }
 
    public void createComponents(Container container) {
         draw = new Draw(game);
         container.add(draw);
         
         ListenKeys listen = new ListenKeys(game);
         frame.addKeyListener(listen);
    }
 
 
    public JFrame getFrame() {
        return frame;
    }
    
    
}
