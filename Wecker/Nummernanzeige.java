public class Nummernanzeige
{
    private int limit;
    private int wert;

    public Nummernanzeige(int anzeigeLimit)
    {
        limit = anzeigeLimit;
        wert = 0;
    }

    public int gibWert()
    {
        return wert;
    }

    public String gibAnzeigewert()
    {
        if(wert < 10) {
            return "0" + wert;
        }
        else {
            return "" + wert;
        }
    }

    public void setzeWert(int ersatzwert)
    {
        if((ersatzwert >= 0) && (ersatzwert < limit)) {
            wert = ersatzwert;
        }
    }

    public void erhoehen()
    {
        wert = (wert + 1) % limit;
    }
}
