import GLOOP.*;
public class Zifferblatt
{
    GLZylinder blatt, narbe;
    GLTorus ring;
    GLLicht licht;
    
    public int pos;
    
    public Zifferblatt(int pos){
        
       blatt = new GLZylinder(pos*1500,0,0,588,40);
       blatt.setzeTextur("Zifferblatt 588.png");
       
       narbe = new GLZylinder(pos*1500,0,40,30,60);
       narbe.setzeFarbe(0,0,0);
       
       ring = new GLTorus(pos*1500,0,0,590,10);
       ring.skaliere(1,1,4);
       ring.setzeFarbe(0,0,0);
       
       licht = new GLLicht(pos*1500,0,1000); 
       //licht.setzeSichtbarkeit(true);
    }   
    
    public void loescheblatt(){
        blatt.loescheDich();
        narbe.loescheDich();
        ring.loescheDich();
        licht.loescheDich();
    }

}
