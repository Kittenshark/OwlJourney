/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package owljourneygame.parts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emmi
 */
public class FinishLineTest {
    FinishLine win;
    
    public FinishLineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        win = new FinishLine(50, 50);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void FinishLineHasRightSize(){
        assertEquals(win.getSide(), 20);
    }
}
