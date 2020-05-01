import GLOOP.*;
public class Zeiger
{
    GLQuader zeiger;

    public int pos,l,b,h,t;
    public double s;

    public Zeiger(int pos,int l, int b, int h, int t){
        zeiger = new GLQuader(pos*1500,l/2,h,b,l,4);
        zeiger.setzeFarbe(0,0,0);
        zeiger.drehe(0,0,-30*t,pos*1500,0,h);
    }  

    public void Drehe(int pos, int h, double s ){
        zeiger.drehe(0,0,-s,pos*1500,0,h);

    }

    public void loeschezeiger(){
        zeiger.loescheDich();
    }
}
