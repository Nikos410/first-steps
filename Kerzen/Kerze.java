import GLOOP.*;
class Kerze{
    GLZylinder koerper, docht;
    GLLicht flamme;
    GLTastatur tastatur;

    double r;

    boolean brennen;

    Kerze(double xm,double zm,double r,double  h){
        //Kerzenkörper erstellen
        koerper = new GLZylinder (xm,0.5*h,zm,r,h);
        koerper.drehe(90,0,0);  
        koerper.setzeFarbe(1,0,0);

        //Docht erstellen
        docht = new GLZylinder (xm, h+h*0.05, zm, 3,h*0.10);
        docht.drehe(90,0,0); 
        docht.setzeFarbe(0,0,0);   

        //Flamme erstellen
        flamme = new GLLicht(xm,h+h*0.05+25,zm);
        //flamme.setzeSichtbarkeit(true);
        flamme.setzeFarbe(1,1,0.5);  
        flamme.skaliere(1,2,1);

        boolean brennen = false;
    }

    public void Brennen(){
        if(docht.gibY() >= 30 && brennen == true){
            flamme.setzeSichtbarkeit(true);
            koerper.verschiebe(0,-0.8,0);
            docht.verschiebe(0,-0.8,0);
            flamme.verschiebe(0,-0.8,0);


        }
        else{
            Aus();
        }
    }

    public void Aus(){
        brennen = false;
        flamme.setzeSichtbarkeit(false);
    }
    public void An(){
        brennen = true;
    }
}

