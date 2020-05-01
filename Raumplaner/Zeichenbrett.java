import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Zeichenbrett extends JPanel
{
    private int rot, gruen, blau;
    private int rot_h, gruen_h, blau_h;

    private int x,y;  //Koordinaten des Mausklicks
    private int r,k,s;

    private Rechteck[] re;    //Rechteck
    private Rechteck[] kr;    //Kreis
    private Rechteck[] sa,si; //Sofa innen und außen

    private boolean rotAn;

    public Zeichenbrett()//Konstruktor
    {
        rot = 0;            //Normale Farbe schwarz
        blau = 0;
        gruen = 0;
        rot_h = 200;        //Hintergrundfarbe hellgrau
        gruen_h = 200;
        blau_h =200;

        rotAn = false;

        addMouseMotionListener(new MouseMoveBearbeiter());
        addMouseListener(new KlickBearbeiter());

        re = new Rechteck[100];
        kr = new Rechteck[100];
        sa = new Rechteck[100];
        si = new Rechteck[100];
        r = 0;
        k = 0;
        s = 0;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int ra = 0;
        while(ra < 100){
            if (re[ra] != null){
                if (re[ra].istAktiv()){
                    g.setColor(new Color(rot_h,gruen_h,blau_h));   
                    g.drawRect(re[ra].getx1(),re[ra].gety1(),re[ra].getBreite(),re[ra].getHoehe());
                    re[ra].setzeScreenPos(x,y);
                    g.setColor(new Color(rot,gruen,blau)); 
                    g.drawRect(re[ra].getx1(),re[ra].gety1(),re[ra].getBreite(),re[ra].getHoehe());
                }
                else{
                    g.setColor(new Color(rot,gruen,blau)); 
                    g.drawRect(re[ra].getx1(),re[ra].gety1(),re[ra].getBreite(),re[ra].getHoehe());
                }    
            }   
            ra++;
        }

        int ka = 0;
        while(ka < 100){
            if (kr[ka] != null){
                if (kr[ka].istAktiv()){
                    g.setColor(new Color(rot_h,gruen_h,blau_h));   
                    g.drawOval(kr[ka].getx1(),kr[ka].gety1(),kr[ka].getBreite(),kr[ka].getHoehe());
                    kr[ka].setzeScreenPos(x,y);
                    g.setColor(new Color(rot,gruen,blau)); 
                    g.drawOval(kr[ka].getx1(),kr[ka].gety1(),kr[ka].getBreite(),kr[ka].getHoehe());
                }
                else{
                    g.setColor(new Color(rot,gruen,blau)); 
                    g.drawOval(kr[ka].getx1(),kr[ka].gety1(),kr[ka].getBreite(),kr[ka].getHoehe());
                }    
            }   
            ka++;
        }

        /**Sofa, d.h. 2 Rechtecke*/ 
        int sofaa = 0;
        while(sofaa < 100){
            if (sa[sofaa] != null && si != null){
                if (sa[sofaa].istAktiv() && si[sofaa].istAktiv()){
                    g.setColor(new Color(rot_h,gruen_h,blau_h));   
                    g.drawRect(sa[sofaa].getx1(),sa[sofaa].gety1(),sa[sofaa].getBreite(),sa[sofaa].getHoehe());
                    sa[sofaa].setzeScreenPos(x,y);
                    g.setColor(new Color(rot,gruen,blau)); 

                    g.setColor(new Color(rot_h,gruen_h,blau_h)); 
                    g.drawRect(si[sofaa].getx1() + si[sofaa].getLehne(),si[sofaa].gety1(),si[sofaa].getBreite(),si[sofaa].getHoehe());
                    si[sofaa].setzeScreenPos(x,y);
                    g.setColor(new Color(rot,gruen,blau));                 
                }
                else{
                    g.setColor(new Color(rot,gruen,blau)); 
                    g.drawRect(sa[sofaa].getx1(),sa[sofaa].gety1(),sa[sofaa].getBreite(),sa[sofaa].getHoehe());
                    g.drawRect(si[sofaa].getx1() + si[sofaa].getLehne(),si[sofaa].gety1(),si[sofaa].getBreite(),si[sofaa].getHoehe());
                }    
            }   
            sofaa++;
        }
    }   

    public void setzeFarbe(int r, int g, int b)
    {
        rot = r;
        gruen = g;
        blau = b;
        repaint();
    }    

    public void rotSchwarz(){
        if (rotAn){  
            rotAn = false; 
            setzeFarbe(0,0,0);   
        }
        else {
            rotAn = true; 
            setzeFarbe(255,0,0);  
        }    

    }

    public void rotSchwarzCycle(){
        rotSchwarz();
        new java.util.Timer().schedule(new java.util.TimerTask(){
                public void run(){
                    rotSchwarz();
                }},200);  
    }

    public void erzeugeRechteck(int px1, int py1, int pBreite, int pHoehe)
    {
        re[r] = new Rechteck(px1,py1,pBreite, pHoehe);
        r++;
        repaint();
    }

    public void erzeugeKreis(int px1, int py1, int pDurchm)
    {        
        kr[k] = new Rechteck(px1,py1,pDurchm, pDurchm);
        k++;
        repaint();        
    }

    public void erzeugeSofa(int px1, int py1, int pBreite, int pHoehe, int pLehneBreite)
    {        
        sa[s] = new Rechteck(px1, py1, pBreite, pHoehe);
        si[s] = new Rechteck(px1, py1, pBreite - pLehneBreite*2, pHoehe - pLehneBreite, pLehneBreite);
        s++;
        repaint();
    }

    //innere Listener-Klasse fuer Mausereignisse  
    class MouseMoveBearbeiter extends MouseMotionAdapter
    {
        public void mouseDragged(MouseEvent e)  
        {
            //Speichern der Koordinaten der aktuellen Mauszeigerposition
            x = e.getX();
            y = e.getY();
            repaint();
        } 
    }
    class KlickBearbeiter extends MouseAdapter
    {       
        public void mouseClicked(MouseEvent e)
        {     //Aktiviert den getroffenen Gegenstand       
            x = e.getX(); 
            y = e.getY();
            int rb = 0;
            while(rb < 100){
                if (re[rb] != null)
                { 
                    if (re[rb].getroffen(x,y))
                        re[rb].setzeAktiv(true); 
                    else
                        re[rb].setzeAktiv(false);

                } 
                rb++;
            }

            int kb = 0;
            while(kb < 100){
                if (kr[kb] != null)
                { 
                    if (kr[kb].getroffen(x,y))
                        kr[kb].setzeAktiv(true); 
                    else
                        kr[kb].setzeAktiv(false);

                }
                kb++;
            }

            int sofab = 0;
            while(sofab < 100){
                if (sa[sofab] != null && si[sofab] != null)
                { 
                    if (sa[sofab].getroffen(x,y)){
                        sa[sofab].setzeAktiv(true); 
                        si[sofab].setzeAktiv(true);
                    }
                    else{
                        sa[sofab].setzeAktiv(false); 
                        si[sofab].setzeAktiv(false);
                    }
                } 
                sofab++;
            }

            repaint();
        }
    }
}
