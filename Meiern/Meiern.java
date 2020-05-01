
public class Meiern
{
    Spieler sp1, sp2, sp3;
    Wuerfelbecher becher;

    public Meiern()
    {
        becher = new Wuerfelbecher();
        
        sp1 = new Spieler("Doris",becher);
        sp2 = new Spieler("Dieter",becher);
        sp3 = new Spieler("Siglinde",becher);
        
        spiel();
    }

    public void spiel(){
        reihenfolgeSetzen();
        
        double dezimalZahl = Math.random()*2;
		int start = (int)Math.round(dezimalZahl) + 1;
        
		switch(start){
		    case 1: sp1.starteSpielrunde();
		    break;
		    case 2: sp2.starteSpielrunde();
		    break;
		    case 3: sp3.starteSpielrunde();
		    break;
		    
		    default: System.err.println("Error: Zufallszahl nicht zwischen 1 und 3");
		  }
    }
    
    private void reihenfolgeSetzen(){
        sp1.setzeVorgaenger(sp3);
        sp1.setzeNachfolger(sp2);
        
        sp2.setzeVorgaenger(sp1);
        sp2.setzeNachfolger(sp3);
        
        sp3.setzeVorgaenger(sp2);
        sp3.setzeNachfolger(sp1);
    }
}
