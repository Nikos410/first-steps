import GLOOP.*;
class Landeplatzszene{
    GLKamera kamera;
    GLLicht licht;
    GLHimmel himmel;
    GLBoden boden;
    GLTastatur tastatur;

    GLZylinder landeplatz;
    GLKugel[] lampe;
    
    boolean aktiv = true;
    int laufzahl = 0;
    int blinkzahl = 0;

    Landeplatzszene(){
        kamera  = new GLSchwenkkamera(1440,900);
        licht   = new GLLicht();
        himmel  = new GLHimmel("Himmel.jpg");
        boden   = new GLBoden("Gras.jpg");
        tastatur = new GLTastatur();

        //Landeplatz erstellen
        landeplatz = new GLZylinder(0,0,0,300,20);
        landeplatz.drehe(90,0,0);
        landeplatz.setzeTextur("Feld.jpg");

        //Lampen erstellen
        lampe = new GLKugel[20];
        int i = 0;
        while (i < 20){
            lampe[i] = new GLKugel(290,20,0,10);
            lampe[i].drehe(0,i*360/20,0, 0,0,0);
            i++;
        }
        
        Lauflichter();

    }

    void Lauflichter(){
        
        int i = 0;
        
        while(i <= 19){
            lampe[i].setzeFarbe(1,0,0);
            Sys.warte(80);                 //Drehgeschwindigkeit (kleiner = schneller)
            lampe[i].setzeFarbe(1,1,1);
            i++;
            
            if (i >= 20){
                laufzahl++;
                i = 0;
                if(laufzahl <=2){ //Anzahl Umdrehungen -1
                    Lauflichter();
                }
                else{
                    laufzahl = 0;
                    Blinken();
                }

            }
        }
    }

    void Blinken(){
        int i = 0;
        while(aktiv = true){
            lampe[i].setzeFarbe(1,0,0);
            i++;
            if(i >= 20) {
                i = 0;
                Sys.warte(100);                 //Zeit Rot
                while(aktiv = true){
                    lampe[i].setzeFarbe(1,1,1);
                    i++;
            
                    if(i >= 20) {
                        blinkzahl++;
                        if(blinkzahl <=2){ //Anzahl Blinken -1 
                            i = 0;
                            Sys.warte(500); //Zeit Weiss
                            Blinken();
                        }
                        else{
                            i = 1;
                            blinkzahl = 0;
                            Lauflichter();
                        }
              
                    }
                }
        
            }
        }
    }
}