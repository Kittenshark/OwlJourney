

package owljourneygame.Game;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import owljourneygame.levels.AllLevels;
import owljourneygame.parts.Mine;
import owljourneygame.parts.Owl;
import owljourneygame.parts.Wall;


public class GamePlatformTest {
    GamePlatform game;
    ArrayList<Wall> setUpWalls1;
    
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
        setUpWalls1 = new ArrayList<Wall>();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void owlStartingPositionIsRight(){
        assertEquals(game.getOwl().getX(), 30);
        assertEquals(game.getOwl().getY(), 240);
        //30, 240, 10
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
        game.whereToMove(MoveSide.R);
        game.moveOwl();
        
        assertEquals(game.getOwl().getX(), 40);
        assertEquals(game.getOwl().getY(), 240);
    }
    
    @Test
    public void movingOwlSeveralTimesWorks(){
        moveOwl();
        
        assertEquals(game.getOwl().getX(), 80);
        assertEquals(game.getOwl().getY(), 240);
    }
    
    public void moveOwl(){
        game.whereToMove(MoveSide.R);
        for (int i=0; i<5; i++){
            game.moveOwl();
        }
    }
    
    @Test
    public void gameStartsAtLevelZero(){
        
        assertEquals(game.getLevel().getGoal().getX(), 350);
        assertEquals(game.getLevel().getGoal().getY(), 30);
        //350, 30
        //goal sijainti vastaa
    }
    
    @Test
    public void levelReturnGivesRightLevel(){
        if (game.getWhichLevel() == 0){
            assertEquals(game.getLevel().getGoal().getX(), 350);
            assertEquals(game.getLevel().getGoal().getY(), 30);
        }
        
        if (game.getWhichLevel() == 1){
            assertEquals(game.getLevel().getGoal().getX(), 180);
            assertEquals(game.getLevel().getGoal().getY(), 40);
            //180, 40
        }
    }
    
    @Test
    public void firstLevelWallsAreCorrect(){
        ArrayList<Wall> walls = new ArrayList<Wall>();
        walls = game.getAllLevels().get(0).getWalls();
        Wall one = new Wall(0, 0, 360, 20);
        Wall two = new Wall(360, 0, 20, 280);
        Wall three = new Wall(0, 20, 20, 280);
        Wall four = new Wall(20, 280, 360, 20);
        
        assertTrue(walls.get(0).equals(one));
        assertTrue(walls.get(1).equals(two));
        assertTrue(walls.get(2).equals(three));
        assertTrue(walls.get(3).equals(four));

        // 0, 0, 360, 20
        // 360, 0, 20, 280
        // 0, 20, 20, 280
        // 20, 280, 360, 20
    }
    
    
    @Test
    public void owlNotMoveOverWalls(){
        game.whereToMove(MoveSide.L);
        game.moveOwl();
        game.moveOwl();
        
        assertEquals(20, game.getOwl().getX());
        assertEquals(240, game.getOwl().getY());
    }
    
    @Test
    public void hittingMineWorks(){
        Owl owlie = new Owl(50, 50, 10);
        Mine mine = new Mine(60, 60);
        owlie.moveOwl(0);  
    }
    
    @Test
    public void afterFirstLevel0YouGetSecondLevel1(){
        game.goNextLevel();
        assertEquals(game.getWhichLevel(), 1);
        
        for (int i=0; i<setUpWalls1.size(); i++){
            assertTrue(setUpWalls1.get(i).equals(game.getLevel().getWalls().get(i)));
        }
    }
    
    public void reCreateLevelOneWalls(){
        setUpWalls1.add(new Wall(0, 0, 360, 20));
        setUpWalls1.add(new Wall(360, 0, 20, 280));
        setUpWalls1.add(new Wall(0, 20, 20, 280));
        setUpWalls1.add(new Wall(20, 280, 360, 20));
        
        setUpWalls1.add(new Wall(10, 10, 80, 280));
        setUpWalls1.add(new Wall(280, 10, 80, 280));
        
        setUpWalls1.add(new Wall(90, 240, 70, 50));
        setUpWalls1.add(new Wall(190, 240, 90, 50));
        
        setUpWalls1.add(new Wall(90, 10, 110, 50));
        setUpWalls1.add(new Wall(230, 10, 90, 50));
        
        setUpWalls1.add(new Wall(110, 100, 50, 100));
        setUpWalls1.add(new Wall(180, 100, 50, 100));
    }
    
 
    

    
    
}
