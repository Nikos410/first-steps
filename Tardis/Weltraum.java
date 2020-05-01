import GLOOP.*;

class Weltraum {
    
    GLSchwenkkamera kamera;
    GLLicht licht1;
    GLLicht licht2;
    GLQuader tardis;
    GLQuader tardis2;
    GLQuader tardis3;
    GLHimmel himmel;
    GLTastatur dieTastatur;
    
    Weltraum() {
        kamera = new GLSchwenkkamera();
        licht1 = new GLLicht();
        himmel = new GLHimmel("sterne-159654.jpg");
        tardis = new GLQuader(0,0,0,10,20,10);
        tardis.setzeTextur("tardis_front.jpg");
        
        tardis2 = new GLQuader(0,10.01,0,10,0.001,10);
        
        dieTastatur=new GLTastatur(); 
        
        while (!dieTastatur.esc()){
            tardis.drehe(0,0.8,0);    
            tardis2.drehe(0,0.8,0);
            Sys.warte(6);
        }
        Sys.beenden();
        
    }
    
}