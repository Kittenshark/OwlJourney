
package owljourneygame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import javax.swing.JPanel;
import owljourneygame.Game.GamePlatform;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;


/**
 * Drawing platform.
 * Draws all game graphics
 */
public class Draw extends JPanel{
    private GamePlatform game;
    private Graphics graphics;
    
    public Draw(GamePlatform game){
        this.game = game;
    }
    
    @Override
    protected void paintComponent(Graphics graphics){
        this.graphics = graphics;
        super.paintComponent(graphics);
        BufferedImage background = null;
        try {
           background = ImageIO.read(getClass().getClassLoader().getResource("pictures/Background.gif"));  
        } catch(Exception e) {
            System.out.println("No image found");
        }
        graphics.drawImage(background, 0, 0, this);
        
        Color wallGreen = new Color(6, 51, 7);
        graphics.setColor(wallGreen);
        drawWalls(graphics);     
        
        drawHealthBar(graphics);
        this.drawHealthMouse(graphics);
        
        drawEnergyBar(graphics);
        
        drawGoal(graphics);
        
        drawMines(graphics);
        
        drawOwl(graphics);
        
        if (game.getBoom()){
           drawBoom();
        }
        
    }
    public void drawOwl(Graphics graphics){
        
        Image owliePicture = null;
        
        try {
 
            owliePicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/Owlie.gif"));
           
        } catch(Exception e) {
            System.out.println("No image found");
        }
        graphics.drawImage(owliePicture, game.getOwl().getX()-2, game.getOwl().getY()-2, null);
    }
    
    public void drawGoal(Graphics graphics){
        BufferedImage goalPicture = null;
        try {
            goalPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/GoalFg.gif"));;
            } catch(Exception e){
            System.out.println("No image found");
        }
        graphics.drawImage(goalPicture, game.getLevel().getGoal().getX()-3, game.getLevel().getGoal().getY()-3, null);
    }
    
    public void drawMines(Graphics graphics){
        BufferedImage minePicture = null;
        try {
            minePicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/MineRed.gif"));
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
            barPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/LifeBar2.gif"));
        } catch(Exception e){
            System.out.println("No image found");
        }
        
        graphics.drawImage(barPicture,20,0, null);
    }
    
    /**
     * Draws lifepoints.
     * Drawing depends on how many lifepoints player has left
     * @param graphics 
     */
    public void drawHealthMouse(Graphics graphics){
        BufferedImage mousePicture = null;
        try {
            mousePicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/MouseLife.gif"));
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
    
    /**
     * Draws energybar based on how much energy player has left
     * @param graphics 
     */
    public void drawEnergyBar(Graphics graphics){
        BufferedImage energyBarPicture = null;
        if (game.getOwl().getEnergy() == 20 || game.getOwl().getEnergy() == 30){
            try {
                energyBarPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/Energy20.gif"));
            } catch(Exception e){
                System.out.println("No image found");
                }
        } else if (game.getOwl().getEnergy() == 40 ){
            try {
                energyBarPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/Energy40.gif"));
            } catch(Exception e){
                System.out.println("No image found");
                }
        } else if (game.getOwl().getEnergy() == 50){
            try {
                energyBarPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/EnergyHalf.gif"));
            } catch(Exception e){
                System.out.println("No image found");
            }
        } else if (game.getOwl().getEnergy() == 60){
            try {
                energyBarPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/Energy60.gif"));
            } catch(Exception e){
                System.out.println("No image found");
            }
        } else if (game.getOwl().getEnergy() == 80){
            try {
                energyBarPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/Energy80.gif"));
            } catch(Exception e){
                System.out.println("No image found");
            }
        } else if (game.getOwl().getEnergy() == 100){
            try {
                energyBarPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/EnergyFull.gif"));
            } catch(Exception e){
                System.out.println("No image found");
            }
        } else if (game.getOwl().getEnergy() < 20) {
            try {
                energyBarPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/EmptyEnergy.gif"));
            } catch(Exception e){
                System.out.println("No image found");
            }
        }
        graphics.drawImage(energyBarPicture, 80, 0, this);
    }
    
    public void drawBoom(){
        BufferedImage boomPicture = null;
        try {
                boomPicture = ImageIO.read(getClass().getClassLoader().getResource("pictures/Boom.gif"));
            } catch(Exception e){
                System.out.println("No image found");
            }
        graphics.drawImage(boomPicture, 0, 0, this);
    }
    
}
