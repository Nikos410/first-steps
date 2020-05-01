import GLOOP.*;
public class Uhr
{
    
    Zifferblatt zb;
    Zeiger zs,zm,zh;
    
    private boolean aktiv = true;
    
    public int pos,t;

    
    public Uhr(int pos, int t){
        zb = new Zifferblatt(pos);
        
        /** pos, l, b, h, t */
        zs = new Zeiger(pos,550,20,50,0);
        zm = new Zeiger(pos,480,40,45,0);
        zh = new Zeiger(pos,350,30,40,t);
        
    }   
    
    public void starteDrehen(int pos){

            /** pos, h, s */
           zs.Drehe(pos, 50, 6);
           zm.Drehe(pos, 45, 0.1);
           zh.Drehe(pos, 40, 0.008333);
        
    }
}