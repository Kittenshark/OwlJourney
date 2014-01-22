
package owljourneygame.parts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DotTest {
    
    Dot dot;
    
    public DotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dot = new Dot(10, 15);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void dotGetXGivesRightNumber(){
        assertEquals(dot.getX(), 10);
        
    }
    
    @Test
    public void dotGetYGivesRightNumber(){
        assertEquals(dot.getY(), 15);
    }
    
    @Test
    public void dotXIsRight(){
        assertEquals(dot.getX(), dot.x);
    }
    
    @Test
    public void dotYIsRight(){
        assertEquals(dot.getY(), dot.y);
    }
}
