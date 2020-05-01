import GLOOP.*;
public class Hut{
    GLZylinder zylinder,krempe,band;
    public Hut(double pX, double pZ){
        zylinder = new GLZylinder(pX,270,pZ,30,80);
        zylinder.setzeFarbe(0,0,0);
        zylinder.drehe(90,0,0);
        
        krempe = new GLZylinder(pX,235,pZ,40,10);
        krempe.setzeFarbe(0,0,0);
        krempe.drehe(90,0,0);
        
        band = new GLZylinder(pX,235,pZ,42,10);
        band.setzeFarbe(1,0,0);
        band.drehe(90,0,0);
    }
    }