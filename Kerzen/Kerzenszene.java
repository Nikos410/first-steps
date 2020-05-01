import GLOOP.*;
class Kerzenszene{
    GLKamera kamera;
    GLTastatur tastatur;

    int r;
    int h;
    boolean an1,an2,an3;

    Kerze k1,k2,k3;
    Kerzenszene(){
        System.out.println("Zum Anzünden der Kerzen die Pfeiltasten verwenden!");
        
        kamera = new GLKamera(1280,1024);     
        kamera.setzePosition(0,300,500);       
        new Untergrund();

        k1 = new Kerze(200,0,50,80);
        k2 = new Kerze(-200,0,40,90);
        k3 = new Kerze(0,-200,30,100);
        

        Brennen();
    }

    public void Brennen(){
        tastatur = new GLTastatur();
        boolean an1 = false;
        boolean an2 = false;
        boolean an3 = false;
        while(!tastatur.esc()){
            if(tastatur.rechts()){
                if(an1 == true){
                    an1 = false;
                }
                else{
                    an1 = true;
                }
                if(an1 == true){
                    k1.An();
                }
                else{
                    k1.Aus();
                }

            }
            if(tastatur.links()){
                if(an2 == true){
                    an2 = false;
                }
                else{
                    an2 = true;
                }
                if(an2 == true){
                    k2.An();
                }
                else{
                    k2.Aus();
                }

            }
            if(tastatur.oben()){
                if(an3 == true){
                    an3 = false;
                }
                else{
                    an3 = true;
                }
                if(an3 == true){
                    k3.An();
                }
                else{
                    k3.Aus();
                }

            }
            
            k1.Brennen();
            k2.Brennen();
            k3.Brennen();
            
            Sys.warte(100);
        }
    }
}
