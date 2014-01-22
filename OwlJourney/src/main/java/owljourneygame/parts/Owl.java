
package owljourneygame.parts;

import java.awt.Graphics;
import java.util.ArrayList;

public class Owl extends Dot{
    private int side;
    
    public Owl(int x, int y, int side){
        //Pöllön aloituskoordinaatit ja sivun pituus
        super(x, y); //aloituspiste
        this.side = side;
    }
    
    public int getSide(){
        return side;
    }
    
    public void moveOwl(int x, int y){
        this.x += x;
        this.y += y;
        /*pöllö liikkuu pelikentällä uusiin koordinaatteihin
            vielä ei varmaa, kuinka liikkuminen tapahtuu.
            Action listener tarvitaan.
            todennäköisesti x ja y montako askelta mihinkin suuntaan
        */
    }
    
}
