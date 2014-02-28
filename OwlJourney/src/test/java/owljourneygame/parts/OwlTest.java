

package owljourneygame.parts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import owljourneygame.Game.MoveSide;


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
        owl = new Owl(30, 35, 15);
    }
    
    @After
    public void tearDown() {
    }

    //Moving owl
    @Test
    public void owlStartPositionIsRight(){
        assertEquals(owl.getX(), 30);
        assertEquals(owl.getY(), 35);
    }
    
    @Test
    public void owlSizeisRight(){
        assertEquals(owl.getSize(), 15);
    }
    
    @Test
    public void whenMovingOwlXIsRight(){
        owl.setOwlDirection(MoveSide.D);
        owl.moveOwl();
        
        assertEquals(owl.getX(), 30);
        assertEquals(owl.getY(), 45);
    }
    
    @Test
    public void movingOwlFiveTimesWorksX(){
        owl.setOwlDirection(MoveSide.R);
        forLoopThatOwl();
        assertEquals(owl.getX(), 80);
        assertEquals(owl.getY(), 35);
    }
    
    public void forLoopThatOwl(){
        for (int i=0; i<5; i++){
            owl.moveOwl();
        }
    }
    
    @Test
    public void owlCanMoveUp(){
        owl.setOwlDirection(MoveSide.U);
        owl.moveOwl();
        
        assertEquals(30, owl.getX());
        assertEquals(25, owl.getY());
    }
    
    //Energy
    @Test
    public void owlDoesNotLoseEnergyUnder0(){
        owl.loseEnergy(50);
        owl.loseEnergy(60);
        
        assertTrue("Owl loses too much energy", owl.getEnergy() >= 0);
    }
    
    @Test
    public void owlDoesNotLoseEnergyIfItHasTooLittle(){
        owl.loseEnergy(50);
        owl.loseEnergy(60);
        
        assertEquals(50, owl.getEnergy());
    }
    
    @Test
    public void owlLosesRightAmountOfEnergy(){
        owl.loseEnergy(20);
        
        assertEquals(80, owl.getEnergy());
    }
}
