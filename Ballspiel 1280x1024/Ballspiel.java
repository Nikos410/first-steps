import GLOOP.*;
class Ballspiel{

    GLKamera kamera;
    GLTastatur tastatur;
    GLLicht licht0,licht1,licht2,licht3,licht4;

    GLQuader ball1,ball2;
    GLQuader hintergrund; 
    GLQuader randl,randr,rando,randu;

    boolean aktiv = true;
    int runde = 0;
    int anzahl = 0;
    int rot = 0;
    int blau = 0;

    public Ballspiel(){
        System.out.println("Zum starten Leertaste. Rot mit WASD steuern, Blau mit Pfeiltasten. \nZiel: Der aktive Spieler muss den anderen 'Fangen' oder ins Aus drängen");
        
        kamera = new GLKamera(1280,1024);
        kamera.setzePosition(0,0,2500);
        tastatur = new GLTastatur();
        hintergrund = new GLQuader(-100,0,-110,3280,1844,10);

        ball1 = new GLQuader(-600,-400,0,100,100,1);
        ball1.setzeFarbe(100,0,0);

        ball2 = new GLQuader(820,-400,0,100,100,1);
        ball2.setzeFarbe(0,0,100);

        rando = new GLQuader(0,1470,-110,10000,100,20);
        rando.setzeFarbe(0,1,1);
        randu = new GLQuader(0,-1400,-110,10000,100,20);
        randu.setzeFarbe(0,1,1);
        randl = new GLQuader(-1880,0,-110,100,10000,20);
        randl.setzeFarbe(0,1,1);
        randr = new GLQuader(1860,0,-110,100,10000,20);
        randr.setzeFarbe(0,1,1);

         
        licht0 = new GLLicht(1000000,1000000,1000000);
        licht1 = new GLLicht(-1000000,1000000,1000000);
        licht2 = new GLLicht(1000000,-1000000,1000000);
        licht3 = new GLLicht(1000000,1000000,-1000000);
        licht4 = new GLLicht(-1000000,-1000000,-1000000); 

        Start();
    }

    public void Start(){
        if(rot >= 5 || blau >= 5){
            ball1.loescheDich();
            ball2.loescheDich();
            if(rot > blau){
                hintergrund.setzeTextur("Rot g.png");
                System.out.println("Rot gewinnt mit " + rot + " zu " + blau + " Punkten!");
            }     
            else{
                hintergrund.setzeTextur("Blau g.png");
                System.out.println("Blau gewinnt mit " + blau + " zu " + rot + " Punkten!");
            }            
            while(aktiv = true){
                if(tastatur.esc()){
                    hintergrund = new GLQuader(-100,0,-110,3280,1844,10);

                    ball1 = new GLQuader(-600,-400,0,100,100,1);
                    ball1.setzeFarbe(100,0,0);

                    ball2 = new GLQuader(820,-400,0,100,100,1);
                    ball2.setzeFarbe(0,0,100);

                    int anzahl = 0;
                    int rot = 0;
                    int blau = 0;

                    Start();
                }
            }
        }
        else{

            hintergrund.setzeTextur("Hintergrund2.png");
            while(aktiv = true){
                if(tastatur.istGedrueckt(' ')){
                    if(runde <= 0){
                        hintergrund.setzeTextur("Rot_d.png");
                        runde++;
                        Spiel();
                    }
                    else{
                        hintergrund.setzeTextur("Blau_d.png");
                        runde--;
                        Spiel();
                    }
                }
            }

        }
    }

    public void Spiel(){
        Sys.warte(1000);
        anzahl++;
        hintergrund.loescheDich();
        while(aktiv = true){
            //blauer Ball

            if (tastatur.links()){
                ball2.verschiebe(-2,0,0);
            }

            if (tastatur.rechts()){
                ball2.verschiebe(2,0,0);
            }

            if (tastatur.oben()){
                ball2.verschiebe(0,2,0);
            }

            if (tastatur.unten()){
                ball2.verschiebe(0,-2,0);
            }

            //roter Ball

            if (tastatur.istGedrueckt('a')){
                ball1.verschiebe(-2,0,0);
            }

            if (tastatur.istGedrueckt('d')){
                ball1.verschiebe(2,0,0);
            }

            if (tastatur.istGedrueckt('w')){
                ball1.verschiebe(0,2,0);
            }

            if (tastatur.istGedrueckt('s')){
                ball1.verschiebe(0,-2,0);
            }

            //Reset

            if (tastatur.esc()){

                /*hintergrund.loescheDich();

                Sys.warte(1);*/

                hintergrund = new GLQuader(-100,0,-110,3280,1844,10);

                ball1.setzePosition(-600,-400,0);
                ball2.setzePosition(820,-400,0);

                anzahl--;

                Start();
            }

            //Kollisionsabfrage
            float distanzX = Math.abs(ball2.gibX() - ball1.gibX());
            float distanzY = Math.abs(ball2.gibY() - ball1.gibY());

            if (distanzX <= 100) {

                if (distanzX >= -100) {

                    if (distanzY <= 100) {

                        if (distanzY >= -100){

                            ball1.setzeFarbe(0,100,0);
                            ball2.setzeFarbe(0,100,0);

                            Sys.warte(400);

                            ball1.setzeFarbe(100,0,0);
                            ball2.setzeFarbe(0,0,100);

                            Sys.warte(400);

                            ball1.setzeFarbe(0,100,0);
                            ball2.setzeFarbe(0,100,0);

                            Sys.warte(250);

                            ball1.setzePosition(-600,-400,0);
                            ball2.setzePosition(820,-400,0);

                            ball1.setzeFarbe(100,0,0);
                            ball2.setzeFarbe(0,0,100);

                            if(runde <= 0){
                                hintergrund = new GLQuader(-100,0,-110,3280,1844,10);
                                hintergrund.setzeTextur("Blau P.png");
                                blau++;
                                Sys.warte(1000);
                                Start();
                            }
                            else{
                                hintergrund = new GLQuader(-100,0,-110,3280,1844,10);
                                hintergrund.setzeTextur("Rot P.png");
                                rot++;
                                Sys.warte(1000);
                                Start();
                            }
                        }
                    }
                }
            }
            //Randabfrage
            if(ball1.gibY() >= 1320 || ball1.gibY() <= -1250 || ball1.gibX() >= 1700 || ball1.gibX() <= -1710){

                ball1.setzeFarbe(0,100,0);

                Sys.warte(400);

                ball1.setzeFarbe(100,0,0);

                Sys.warte(400);

                ball1.setzeFarbe(0,100,0);

                Sys.warte(250);

                ball1.setzePosition(-600,-400,0);
                ball2.setzePosition(820,-400,0);

                ball1.setzeFarbe(100,0,0);
                ball2.setzeFarbe(0,0,100);

                hintergrund = new GLQuader(-100,0,-110,3280,1844,10);
                hintergrund.setzeTextur("Blau P.png");
                blau++;

                Sys.warte(1000);                

                Start();
            }

            if(ball2.gibY() >= 1320 || ball2.gibY() <= -1250 || ball2.gibX() >= 1700 || ball2.gibX() <= -1710){

                ball2.setzeFarbe(0,100,0);

                Sys.warte(400);

                ball2.setzeFarbe(0,0,100);

                Sys.warte(400);

                ball2.setzeFarbe(0,100,0);

                Sys.warte(250);

                ball1.setzePosition(-600,-400,0);
                ball2.setzePosition(820,-400,0);

                ball1.setzeFarbe(100,0,0);
                ball2.setzeFarbe(0,0,100);

                hintergrund = new GLQuader(-100,0,-110,3280,1844,10);
                hintergrund.setzeTextur("Rot P.png");
                rot++;

                Sys.warte(1000);

                Start();
            }

            Sys.warte();
        }
    }
}
