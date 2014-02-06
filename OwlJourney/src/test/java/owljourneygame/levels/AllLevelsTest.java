


package owljourneygame.levels;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import owljourneygame.parts.FinishLine;
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
        level = new AllLevels(new FinishLine (100, 100));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void beforeAddingWallsThereIsFourWalls(){
        assertEquals(level.getWalls().size(), 4);
    }
    
    @Test
    public void addingNewWallsWorks(){
        level.addWall(new Wall(100, 100, 20, 30));
        
        assertEquals(level.getWalls().size(), 5);
    }
}
