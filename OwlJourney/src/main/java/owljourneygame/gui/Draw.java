
package owljourneygame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
import owljourneygame.Game.GamePlatform;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;


public class Draw extends JPanel{
    private GamePlatform game;
    
    public Draw(GamePlatform game){
        Color color = new Color(7, 100, 10);
        super.setBackground(color);
        this.game = game;
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        
        Color wallGreen = new Color(6, 51, 7);
        graphics.setColor(wallGreen);
        drawWalls(graphics);     
        
        drawGoal(graphics);
        
        drawMines(graphics);
        
        drawHealthBar(graphics);
        this.drawHealthMouse(graphics);
        
        drawOwl(graphics);
    }
    public void drawOwl(Graphics graphics){
        BufferedImage owliePicture = null;
        try {
           owliePicture = ImageIO.read(new File("src\\main\\pictures\\Owlie.gif"));  
        } catch(Exception e) {
            System.out.println("No image found");
        }
        graphics.drawImage(owliePicture, game.getOwl().getX()-2, game.getOwl().getY()-2, null);
    }
    
    public void drawGoal(Graphics graphics){
        BufferedImage goalPicture = null;
        try {
            goalPicture = ImageIO.read(new File(("src\\main\\pictures\\GoalFg.gif")));
            } catch(Exception e){
            System.out.println("No image found");
        }
        graphics.drawImage(goalPicture, game.getLevel().getGoal().getX()-3, game.getLevel().getGoal().getY()-3, null);
    }
    
    public void drawMines(Graphics graphics){
        BufferedImage minePicture = null;
        try {
            minePicture = ImageIO.read(new File("src\\main\\pictures\\MineRed.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        
        for (Mine mine : game.getLevel().getMines()){
            if (mine.getVisible()){
              graphics.drawImage(minePicture, mine.getX(), mine.getY(), null);  
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
        BufferedImage barPicture = null;
        try {
            barPicture = ImageIO.read(new File("src\\main\\pictures\\LifeBar2.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        
        graphics.drawImage(barPicture,20,0, null);
    }
    
    public void drawHealthMouse(Graphics graphics){
        BufferedImage mousePicture = null;
        try {
            mousePicture = ImageIO.read(new File("src\\main\\pictures\\MouseLife.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        
        if (game.getLifePoints() > 0){
            graphics.drawImage(mousePicture, 22, 2, this);
        }
        if (game.getLifePoints() > 1){
            graphics.drawImage(mousePicture, 36, 2, this);
        }
        if (game.getLifePoints() == 3){
            graphics.drawImage(mousePicture, 52, 2, this);
        }
    }
    
}
