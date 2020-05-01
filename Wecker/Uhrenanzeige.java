public class Uhrenanzeige
{
    private Nummernanzeige stunden;
    private Nummernanzeige minuten;
    private Nummernanzeige sekunden;
    private String zeitanzeige;    // simuliert die tatsächliche Anzeige
    
     public Uhrenanzeige()
    {
        stunden = new Nummernanzeige(24);
        minuten = new Nummernanzeige(60);
        sekunden = new Nummernanzeige(60);
        anzeigeAktualisieren();
    }

     public Uhrenanzeige(int stunde, int minute, int sekunde)
    {
        stunden = new Nummernanzeige(24);
        minuten = new Nummernanzeige(60);
        sekunden = new Nummernanzeige(60);
        setzeUhrzeit(stunde, minute,sekunde);
    }

     public void gibTaktsignal()
    {
        sekunden.erhoehen();
        if (sekunden.gibWert() ==0) {
            minuten.erhoehen();
            if(minuten.gibWert() == 0) {  // Limit wurde erreicht!
                stunden.erhoehen();
            }
        }    
        anzeigeAktualisieren();
    }

     public void setzeUhrzeit(int stunde, int minute, int sekunde)
    {
        stunden.setzeWert(stunde);
        minuten.setzeWert(minute);
        sekunden.setzeWert(sekunde);
        anzeigeAktualisieren();
    }

    public String gibUhrzeit()
    {
        return zeitanzeige;
    }
    
    public void anzeigeAktualisieren()
    {
        zeitanzeige = stunden.gibAnzeigewert() 
            + ":"
            + minuten.gibAnzeigewert() 
            + ":" 
            + sekunden.gibAnzeigewert();
    }
}
