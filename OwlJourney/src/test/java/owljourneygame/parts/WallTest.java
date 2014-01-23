

package owljourneygame.parts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class WallTest {
    Wall wall;
    
    public WallTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        wall = new Wall(10, 5, 20, 25);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void wallPositionIsRight(){
        assertEquals(wall.getX(), 10);
        assertEquals(wall.getY(), 5);
        assertEquals(wall.getX(), wall.x);
        assertEquals(wall.getY(), wall.y);
    }
    
    @Test
    public void wallWidthIsRight(){
        assertEquals(wall.getWidth(), 20);
    }
    
    @Test
    public void wallHeightisRight(){
        assertEquals(wall.getHeight(), 25);
    }
    
}
