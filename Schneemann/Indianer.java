import GLOOP.*;
public class Indianer extends Schneemann{
    private GLTorus stirnband;
    private GLKugel feder;
    
    public Indianer(double pX, double pZ){
        super(pX,pZ);
        
        stirnband  = new GLTorus(0,220,0,30,5);
        stirnband.setzeFarbe(0,0.2,1);
        stirnband.drehe(90,0,0);
        stirnband.verschiebe(pX,0,pZ);
        
        feder = new GLKugel(0,240,-30,30);
        feder.skaliere(0.2,1,0.1);
        feder.setzeFarbe(1,0,0);
        feder.verschiebe(pX,0,pZ);
    }
}