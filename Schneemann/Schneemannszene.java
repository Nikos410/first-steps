import GLOOP.*;
public class Schneemannszene {
    private GLKamera kamera;
    private GLLicht  licht;  
    private GLHimmel himmel;
    private GLBoden  boden;

    private Schneemann schneemann1,schneemann2,schneemann3,schneemann4,schneemann5;
    private Hut hut1,hut2,hut3,hut4,hut5;
    private Indianer indianer;

    public Schneemannszene(){
        kamera = new GLSchwenkkamera();
        kamera.setzePosition(-600,400,800);
        licht  = new GLLicht();  
        boden  = new GLBoden("Schnee.jpg");
        himmel = new GLHimmel("Himmel.jpg");

        schneemann1 = new Schneemann(-500,0);
        schneemann2 = new Schneemann(-250,0);
        schneemann3 = new Schneemann(0,0);
        schneemann4 = new Schneemann(250,0);
        schneemann5 = new Schneemann(500,0);
        
        hut1 = new Hut(-500,0);
        hut2 = new Hut(-250,0);
        hut3 = new Hut(0,0);
        hut4 = new Hut(250,0);
        hut5 = new Hut(500,0);

        indianer = new Indianer(0,250);
        
        
    }
}
