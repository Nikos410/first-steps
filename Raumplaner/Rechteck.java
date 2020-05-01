public class Rechteck
{
    private int x1, y1, breite, hoehe, lehne;
    private boolean aktiv;
    /**
     * Constructor for objects of class Rechteck
     */
    public Rechteck(int px1,int py1,int pb,int phoe)
    {
        x1 = px1;
        y1 = py1;
        breite = pb;
        hoehe = phoe;
        aktiv = false;
    }
    
    public Rechteck(int px1,int py1,int pb,int phoe, int pleh)
    {
        x1 = px1;
        y1 = py1;
        breite = pb;
        hoehe = phoe;
        lehne = pleh;
        aktiv = false;
    }

    public int getx1()
    {
        return x1;
    }
    
    public int gety1()
    {
        return y1;
    }
    
    public int getBreite()
    {
        return breite;
    }
    
    public int getHoehe()
    {
        return hoehe;
    }
    
    public int getLehne()
    {
        return lehne;
    }

    public void setzeAktiv(boolean pa)
    {
        aktiv = pa;
    }

    public boolean istAktiv()
    {
        return aktiv;
    }
    
    public void setzeScreenPos(int px, int py)
    {
        x1 = px;
        y1 = py;
    }
    
    public boolean getroffen(int mx, int my)
    {
        
        
        int hitboxgroesse = (breite + hoehe)/5;
        /** Hitbox in oben linken Ecke */
        if ((mx-x1) < hitboxgroesse && (my-y1) < hitboxgroesse && (mx-x1) > 0 && (my-y1) > 0){
                   
            return true;

        }  
        else
          return false;        
    }
}
