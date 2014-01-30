

package owljourneygame.levels;

//ei käytössä

import java.util.ArrayList;
import owljourneygame.parts.FinishLine;

public interface Printable {
    
    public ArrayList getWalls();
    
    public ArrayList getMines();
    
    public FinishLine getGoal();
}
