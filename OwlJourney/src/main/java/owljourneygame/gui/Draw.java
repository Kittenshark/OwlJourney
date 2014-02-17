
package owljourneygame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import owljourneygame.Game.GamePlatform;
import owljourneygame.parts.FinishLine;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;


public class Draw extends JPanel implements UpdateGame{
    private GamePlatform game;
    
    public Draw(GamePlatform game){
        Color color = new Color(7, 100, 10);
        super.setBackground(color);
        this.game = game;
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        
        drawOwl(graphics);
        //graphics.setColor(Color.ORANGE);
        //graphics.fillRect(game.getOwl().getX(), game.getOwl().getY(), game.getOwl().getSize(), game.getOwl().getSize());
        
        drawGoal(graphics);
        //FinishLine goal = game.getLevel().getGoal();
        //graphics.setColor(Color.red);
        //graphics.fillRect(goal.getX(), goal.getY(), goal.getSide(), goal.getSide());
          
        drawMines(graphics);
        
        Color wallGreen = new Color(6, 51, 7);
        graphics.setColor(wallGreen);
        
        drawWalls(graphics);
        
    }
    public void drawOwl(Graphics graphics){
        BufferedImage owlie = null;
        try {
           owlie = ImageIO.read(new File("C:\\Users\\Emmi\\OwlJourney\\OwlJourney\\src\\main\\java\\owljourneygame\\pictures\\Owlie2.gif"));  
        } catch(Exception e) {
            System.out.println("No image found");
        }
        graphics.drawImage(owlie, game.getOwl().getX(), game.getOwl().getY(), null);
        //ImageIcon owl = createImageIcon("");
    }
    
    public void drawGoal(Graphics graphics){
        BufferedImage goal = null;
        try {
            goal = ImageIO.read(new File("C:\\Users\\Emmi\\OwlJourney\\OwlJourney\\src\\main\\java\\owljourneygame\\pictures\\GoalFlag.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        graphics.drawImage(goal, game.getLevel().getGoal().getX(), game.getLevel().getGoal().getY(), null);
    }
    
    public void drawMines(Graphics graphics){
        BufferedImage mine = null;
        try {
            mine = ImageIO.read(new File("C:\\Users\\Emmi\\OwlJourney\\OwlJourney\\src\\main\\java\\owljourneygame\\pictures\\MineP.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        
        for (Mine m : game.getLevel().getMines()){
            graphics.drawImage(mine, m.getX(), m.getY(), null);
        }
    }

    
    public void drawWalls(Graphics graphics){
        ArrayList<Wall> walls = new ArrayList<Wall>();
        
        walls = game.getLevel().getWalls();
        
        for (Wall wall : walls){
            graphics.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
        }
    }
    
    @Override
    public void update() {
        repaint();
    }

}
