import GLOOP.*;
class Schachfeld{
    GLKamera kamera;
    GLLicht licht;
    GLBoden boden;

    GLQuader [] [] feld;

    Schachfeld(){
        kamera = new GLSchwenkkamera();
        kamera.setzePosition(0,400,2000);
        licht = new GLLicht();
        boden = new GLBoden("Boden.jpg");

        feld = new GLQuader [8] [8];

        int x = 0;
        int y = 0;
        int f = 1; // 0 weiß 1 schwarz
        boolean aktiv = true;

        Sys.warte(1000);

        while(y < 8){
            for(x = 0; x < 8; x++){
                feld [x] [y] = new GLQuader(x*100,5,y*100,98,10,98);    
                if(f >= 1){
                    feld [x] [y].setzeFarbe(0,0,0);
                    f--;
                }
                else{
                    feld [x] [y].setzeFarbe(1,1,1);
                    f++;
                }
                Sys.warte(50);
            }
            y++;
            if(f >= 1){
                f--;
            }
            else{
                f++;
            }
            Sys.warte(50);
        }

    }
}