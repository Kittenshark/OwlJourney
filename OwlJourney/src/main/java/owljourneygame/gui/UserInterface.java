

package owljourneygame.gui;

import ActionListeners.ListenKeys;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        
        //frame.getContentPane().setLayout(new FlowLayout());
        //frame.setPreferredSize(new Dimension(395, 335));
        //380, 300

 
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        createComponents(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);    
    }
 
    public void createComponents(Container container) {
         draw = new Draw(game);
         draw.setPreferredSize(new Dimension(380, 300));
         container.add(draw);
         
         ListenKeys listenKeys = new ListenKeys(game);
         frame.addKeyListener(listenKeys);
    }
 
    public JFrame getFrame() {
        return frame;
    }
    
    public void letsPaint(){
        frame.getContentPane().repaint();
    }
    
    public void gameEnded(){
        frame.setVisible(false);
        JFrame frame2 = new JFrame("Game Over!");
        frame2.setSize(200, 50);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponentsForSecondFrame(frame2);
        frame2.pack();
        frame2.setVisible(true);
    }
    
    public void createComponentsForSecondFrame(Container container){
        JLabel text = new JLabel("Game Over!");
        text.setHorizontalAlignment(JLabel.CENTER);
        container.add(text);
    }
    
    public void mineWasHit(){
        JButton kaboom = new JButton("BOOM!");
        ButtonGroup ainoa = new ButtonGroup();
        ainoa.add(kaboom);
        frame.getContentPane().add(kaboom);
    }
}
