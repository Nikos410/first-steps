import GLOOP.*;

public class Uhrenszene
{
    GLKamera kamera;
    GLSchwenkkamera skamera;
    
    Uhr london,berlin,moskau,usa;
    
    boolean aktiv;
    
    public Uhrenszene()
    {
        boolean aktiv = true;
        
        skamera = new GLSchwenkkamera();
        skamera.setzePosition(0,0,3500);
        
        /** (pos,t) **/
        berlin = new Uhr(0,0);
        london = new Uhr(-1,-1);
        moskau = new Uhr(1,1);
        
        while(aktiv){
            
            /** pos */
            berlin.starteDrehen(0);
            london.starteDrehen(-1);
            moskau.starteDrehen(1);
            
            /** 1000 = Echtzeit */ 
            Sys.warte(1000);
        }
    }
    
    
}
