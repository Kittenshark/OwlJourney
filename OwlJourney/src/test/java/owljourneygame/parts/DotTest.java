
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
    public void dotIsRight(){
        assertEquals(dot.getX(), 10);
        assertEquals(dot.getY(), 15);
    }
    
    @Test
    public void dotIsRight2(){
        assertEquals(dot.getX(), dot.x);
        assertEquals(dot.getY(), dot.y);
    }

}
