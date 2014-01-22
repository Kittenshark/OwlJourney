

package owljourneygame.Game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import owljourneygame.parts.Owl;


public class GamePlatformTest {
    GamePlatform game;
    
    public GamePlatformTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new GamePlatform();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void OwlIsCreatedInRightPlaceX(){
        assertEquals(game.getOwl().getX(), 12);
    }
    
    @Test
    public void OwlIsCreatedInRightPlaceY(){
        assertEquals(game.getOwl().getY(), 270);
    }
    
    @Test
    public void OwlIsRightSize(){
        assertEquals(game.getOwl().getSide(), 10);
    }
    
    @Test
    public void hittingMineMakesMineInactive(){
        //game.hitMine();
    }

    
    
}