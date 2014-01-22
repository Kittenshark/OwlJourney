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
        mine = new Mine(20, 35);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void mineGetXGivesRightNumber(){
        assertEquals(mine.getX(), 20);     
    }
    
    @Test
    public void mineGetYGivesRightNumber(){
        assertEquals(mine.getY(), 35);
    }
    
    @Test
    public void mineXIsRight(){
        assertEquals(mine.getX(), mine.x);
    }
    
    @Test
    public void mineYIsRight(){
        assertEquals(mine.getY(), mine.y);
    }
}
