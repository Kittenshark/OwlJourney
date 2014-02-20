
package owljourneygame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
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
        
        drawHealthBar(graphics);
        this.drawHealthMouse(graphics);
        
    }
    public void drawOwl(Graphics graphics){
        BufferedImage owlie = null;
        try {
           owlie = ImageIO.read(new File("C:\\Users\\Emmi\\OwlJourney\\OwlJourney\\src\\main\\pictures\\Owlie2.gif"));  
        } catch(Exception e) {
            System.out.println("No image found");
        }
        graphics.drawImage(owlie, game.getOwl().getX()-2, game.getOwl().getY()-2, null);
        //ImageIcon owl = createImageIcon("");
    }
    
    public void drawGoal(Graphics graphics){
        BufferedImage goal = null;
        //String imagePath = "Owljourney/resources/GoalFlag2.gif";
        BufferedImage picture = null;
        
        try {
            picture = ImageIO.read((getClass().getClassLoader().getResource("resources/GoalFlag2.gif")));
            //goal = ImageIO.read(new File("pictures/GoalFlag.gif"));
            //Icon picture = Draw.class.getResource("pictures/GoalFlag.gif");
            //goal = ImageIO.read(new File("C:\\Users\\Emmi\\OwlJourney\\OwlJourney\\src\\main\\java\\owljourneygame\\pictures\\GoalFlag.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        graphics.drawImage(picture, game.getLevel().getGoal().getX()-3, game.getLevel().getGoal().getY()-3, null);
    }
    
    public void drawMines(Graphics graphics){
        BufferedImage mine = null;
        try {
            mine = ImageIO.read(new File("C:\\Users\\Emmi\\OwlJourney\\OwlJourney\\src\\main\\pictures\\MineP.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        
        for (Mine m : game.getLevel().getMines()){
            if (m.getActive()){
              graphics.drawImage(mine, m.getX(), m.getY(), null);  
            } 
        }
    }

    
    public void drawWalls(Graphics graphics){
        ArrayList<Wall> walls = new ArrayList<Wall>();
        
        walls = game.getLevel().getWalls();
        
        for (Wall wall : walls){
            graphics.fillRect(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight());
        }
    }
    
    public void drawHealthBar(Graphics graphics){
        BufferedImage bar = null;
        try {
            bar = ImageIO.read(new File("C:\\Users\\Emmi\\OwlJourney\\OwlJourney\\src\\main\\pictures\\LifeBar2.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        
        graphics.drawImage(bar,20,0, null);
    }
    
    public void drawHealthMouse(Graphics graphics){
        BufferedImage mouse = null;
        try {
            mouse = ImageIO.read(new File("C:\\Users\\Emmi\\OwlJourney\\OwlJourney\\src\\main\\pictures\\MouseLife.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        
        if (game.getLifePoints() > 0){
            graphics.drawImage(mouse, 22, 2, this);
        }
        if (game.getLifePoints() > 1){
            graphics.drawImage(mouse, 36, 2, this);
        }
        if (game.getLifePoints() == 3){
            graphics.drawImage(mouse, 52, 2, this);
        }
    }
    
    @Override
    public void update() {
        repaint();
    }

}
