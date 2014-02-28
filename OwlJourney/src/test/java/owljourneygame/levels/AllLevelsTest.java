


package owljourneygame.levels;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import owljourneygame.parts.FinishLine;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Wall;


public class AllLevelsTest {
    AllLevels level;
    
    public AllLevelsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        level = new AllLevels(0, 0, new FinishLine (100, 100));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void beforeAddingWallsThereIsFourWalls(){
        assertEquals(4, level.getWalls().size());
    }
    
    @Test
    public void addingNewWallsWorks(){
        level.addWall(new Wall(100, 100, 20, 30));
        
        assertEquals(5, level.getWalls().size());
    }
    
    @Test
    public void addingOneMineWorks(){
        level.addMine(new Mine(60, 60, true));
        
        assertEquals(1, level.getMines().size());
        assertNotNull("Mine is not null", level.getMines().get(0));
    }
}
