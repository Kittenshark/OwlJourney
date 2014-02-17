
package owljourneygame.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import owljourneygame.Game.GamePlatform;
import owljourneygame.parts.FinishLine;
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
        
        graphics.setColor(Color.ORANGE);
        graphics.fillRect(game.getOwl().getX(), game.getOwl().getY(), game.getOwl().getSize(), game.getOwl().getSize());
        
        FinishLine goal = game.getLevel().getGoal();
        graphics.setColor(Color.red);
        graphics.fillRect(goal.getX(), goal.getY(), goal.getSide(), goal.getSide());
          
        Color wallGreen = new Color(6, 51, 7);
        graphics.setColor(wallGreen);
        
        drawWalls(graphics);
        
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
