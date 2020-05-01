import GLOOP.*;
public class Zifferblatt
{
    GLZylinder blatt, mitte;
    GLTorus ring;
    GLLicht licht;
    
    public int pos;
    
    public Zifferblatt(int pos){
        
       blatt = new GLZylinder(pos*1500,0,0,588,40);
       blatt.setzeTextur("Zifferblatt 588.png");
       
       mitte = new GLZylinder(pos*1500,0,40,30,60);
       mitte.setzeFarbe(0,0,0);
       //Zeiger
       
       ring = new GLTorus(pos*1500,0,0,590,10);
       ring.skaliere(1,1,4);
       ring.setzeFarbe(0,0,0);
       
       licht = new GLLicht(pos*1300,0,1000);
    }   
}
