

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
    public void owlStartingPositionIsRight(){
        assertEquals(game.getOwl().getX(), 12);
        assertEquals(game.getOwl().getY(), 270);
    }
    
    @Test
    public void owlIsRightSize(){
        assertEquals(game.getOwl().getSide(), 10);
    }
    
    @Test
    public void hittingMineMakesMineInactive(){
        //game.hitMine();
    }
    
    @Test
    public void movingOwlMovesOwl(){
        game.moveOwl();
        
        assertEquals(game.getOwl().getX(), 22);
        assertEquals(game.getOwl().getY(), 280);
    }
    
    @Test
    public void movingOwlSeveralTimesWorks(){
        moveOwl();
        
        assertEquals(game.getOwl().getX(), 62);
        assertEquals(game.getOwl().getY(), 320);
    }
    
    public void moveOwl(){
        for (int i=0; i<5; i++){
            game.moveOwl();
        }
    }

    
    
}
