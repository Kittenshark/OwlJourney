

package owljourneygame.Game;


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
