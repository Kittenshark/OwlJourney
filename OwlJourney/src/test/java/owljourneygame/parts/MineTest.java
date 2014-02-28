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
public class MineTest {
    
    Mine mine;
    
    public MineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mine = new Mine(20, 35, true);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void minePositionIsRight(){
        assertEquals(mine.getX(), 20); 
        assertEquals(mine.getY(), 35);
    }
    
    @Test
    public void minePositionIsRight2(){
        assertEquals(mine.getX(), mine.x);
        assertEquals(mine.getY(), mine.y);
    }
    
    @Test
    public void mineHasRightSize(){
        mine.setSize(10);
        assertEquals(mine.getSize(), 10);
    }
    
    @Test
    public void visibleMineIsVisible(){
        assertTrue(mine.getVisible());
    }
    
    @Test
    public void settingMineInactiveWorks(){
        mine.setInActive();
        
        assertFalse(mine.getActive());
    }
    
    @Test
    public void settingMineActiveWorks(){
        mine.setActive();
        
        assertTrue(mine.getActive());
    }
}
