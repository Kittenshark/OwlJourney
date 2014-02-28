
package owljourneygame.Game;

/**
 * Used to set moving direction for owl
 * Owl can move to four different directions: right, left, down and up
 */
public enum MoveSide {

    R(0), L(1), D(2), U(3);
    
    private final int where;
    
    private MoveSide(int where){
        this.where = where;
    }
    
    public int getWhere(){
        return where;
    }
          
}
