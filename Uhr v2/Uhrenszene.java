import GLOOP.*;

public class Uhrenszene
{
    GLKamera kamera;
    GLSchwenkkamera skamera;
    GLTastatur tastatur;

    Uhr u1,u2,u3;
    GLQuader hintergr1,hintergr2;

    private int Startzeit1,Startzeit2,Startzeit3,uhr,zeit;

    public Uhrenszene(int Startzeit1, int Startzeit2, int Startzeit3)
    {

        //kamera = new GLKamera();
        //kamera.setzePosition(0,0,3000);

        skamera = new GLSchwenkkamera();
        skamera.setzePosition(0,0,3000);
        
        tastatur = new GLTastatur();
        

        
        hintergr1 = new GLQuader(-2560,0,-100,5120,3840,10);
        hintergr2 = new GLQuader(2560,0,-100,5120,3840,10);
        hintergr1.setzeTextur("tapete1.jpg");
        hintergr2.setzeTextur("tapete1.jpg");

        /** (pos,t) **/
        u1 = new Uhr(-1,Startzeit1);
        u2 = new Uhr(0,Startzeit2);
        u3 = new Uhr(1,Startzeit3);

        starteUhren();

    }
    
    public void starteUhren(){
        while(!tastatur.esc()){

            /** pos */
            u1.starteDrehen(-1);
            u2.starteDrehen(0);
            u3.starteDrehen(1);

            /** 1000 = Echtzeit */ 
            Sys.warte(10);
        }
    }

    public void stelleUhrzeit(int uhr,int zeit){
        if(uhr == 1){
            u1.loescheUhr();
            u1 = new Uhr(-1,zeit);
        }
        else{
            if(uhr == 2){
                u2.loescheUhr();
                u2 = new Uhr(0,zeit);
            }
            else{
                if(uhr == 3){
                    u3.loescheUhr();
                    u3 = new Uhr(1,zeit);
                }
                else{
                    System.out.println("Uhr nicht vorhanden.");
                    System.out.println("Es gibt Uhren 1 - 3");
                }
            }
        }

    }
}
