import GLOOP.*;
class BallBoden {
    GLKamera Kamera;
    GLLicht Licht;
    //GLLicht Licht1
    GLKugel Ball;
    GLBoden Boden;
    GLHimmel Himmel;
    GLTastatur Tastatur;
    
    BallBoden () {
        Kamera = new GLSchwenkkamera();
        Licht = new GLLicht();
        //Licht = new GLLicht(10000,-10000,-10000);
        Licht.setzeHintergrundlicht(1,1,1);
        Tastatur = new GLTastatur();
        
        Ball = new GLKugel (0,250,0,50);
        Ball.setzeMaterial(GLMaterial.CHROM);
        Ball.setzeQualitaet (50);
        
        Boden = new GLBoden ("Erde.jpg");
        Himmel = new GLHimmel ("sterne-159654.jpg");
        
        while (!Tastatur.esc()) {
            double t = 0;
            while(Ball.gibY() > 25 && !Tastatur.esc()) {
            Ball.verschiebe(0,-0.2*t,0);
            t = t + 0.01;
            Sys.warte(6);
          }
        
            while(Ball.gibY() < 250 && !Tastatur.esc()) {
            Ball.verschiebe (0,+0.2*t,0);
            t = t - 0.01;
            Sys.warte(6);
          }
            
        }
    }
}

        
        
        