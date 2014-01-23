

package owljourneygame.parts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class OwlTest {
    Owl owl;
    
    public OwlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        owl = new Owl(30, 35, 10);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void owlStartPositionIsRight(){
        assertEquals(owl.getX(), 30);
        assertEquals(owl.getY(), 35);
        assertEquals(owl.getX(), owl.x);
    }
    
    @Test
    public void owlSizeisRight(){
        assertEquals(owl.getSide(), 10);
    }
    
    @Test
    public void whenMovingOwlXIsRight(){
        owl.moveOwl(10, 15);
        
        assertEquals(owl.getX(), 40);
        assertEquals(owl.getY(), 50);
    }
    
    @Test
    public void movingOwlFiveTimesWorksX(){
        forLoopThatOwl();
        assertEquals(owl.getX(), 35);
        assertEquals(owl.getY(), 40);
    }
    
    public void forLoopThatOwl(){
        for (int i=0; i<5; i++){
            owl.moveOwl(1, 1);
        }
    }
}
