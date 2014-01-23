

package owljourneygame.draw;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import owljourneygame.parts.Wall;


public class DrawWalls extends JPanel{
    private Wall wall;
    
    public DrawWalls(Wall wall) {
        this.wall = wall;
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        wall.draw(graphics);
        

    }
}
