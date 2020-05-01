public class Spieler {
    // Bezugsobjekte
    private Spieler vorgaenger;
    private Spieler nachfolger;
    private Wuerfelbecher becher;

    // Attribute
    private String name; 
    private int vorgaengerzahl;
    private int eigeneZahl;


    // Konstruktor
    public Spieler(String pName,Wuerfelbecher b) {
        name = pName;
        becher = b;

    }

    // Dienste/Methoden
    public void merkeVorgaengerzahl(int pZahl) {
        vorgaengerzahl = pZahl;
    }

    public void leseGewuerfelteZahl() {
        eigeneZahl = becher.zeigeWuerfelergebnis();
    }

    public int nenneEigeneZahl() {
        return eigeneZahl;
    }

    public String gibName() { 
        return name;
    }

    public int gibVorgaengerzahl() {
        return vorgaengerzahl;
    }

    public void schuettleBecher() {
        becher.schuettelDich();
    }

    public void setzeVorgaenger(Spieler pVorgaenger) {
        vorgaenger = pVorgaenger;
    }

    public void setzeNachfolger(Spieler pNachfolger) {
        nachfolger = pNachfolger;
    }

    public void starteSpielrunde() { 
        // Der aktive Spieler schüttelt den Becher, merkt sich die Zahl und gibt ihn an den Nachfolger weiter
        System.out.println("--- Neue Spielrunde ---");
        System.out.println("Es beginnt " + name);
        this.schuettleBecher();
        System.out.println(name + " würfelt " + becher.zeigeWuerfelergebnis());
        this.leseGewuerfelteZahl();
        nachfolger.fuehreZugAus();
    }

    public void fuehreZugAus() { 
        System.out.println(" ");
        System.out.println(name + " ist am Zug");
        this.merkeVorgaengerzahl(vorgaenger.nenneEigeneZahl());
        System.out.println(name + " erhält vom Vorgänger " + vorgaengerzahl + " genannt");

        entscheideDich();

    }

    public void entscheideDich(){

        if(Math.random()*150 > gibWert(vorgaengerzahl)){
            //wuerfeln + weitergeben
            glauben();
        }
        else{
            //anzweifeln
            anzweifeln();            
        }
    }

    public void glauben(){
        System.out.println(name + " glaubt " + vorgaenger.gibName());

        schuettleBecher();
        leseGewuerfelteZahl();
        System.out.println(name + " würfelt " + eigeneZahl);

        if(gibWert(eigeneZahl) > gibWert(vorgaengerzahl)){
            nachfolger.fuehreZugAus();
        }
        else{
            System.out.println(name + " sieht, dass er " + vorgaenger.gibName() + " nicht übertreffen konnte und lügt.");

            while(gibWert(vorgaengerzahl) >= gibWert(eigeneZahl) || eigeneZahl == 21){
                Wuerfelbecher wrf = new Wuerfelbecher();
                wrf.schuettelDich();
                eigeneZahl = wrf.zeigeWuerfelergebnis();
            }

            nachfolger.fuehreZugAus();
        }
    }

    public void anzweifeln(){
        
        System.out.println(name + " zweifelt an und deckt auf.");
        if(vorgaengerzahl == becher.zeigeWuerfelergebnis())
            System.out.println(name + " sieht, dass " + vorgaenger.gibName() + " nicht gelogen hat.");
        else
            System.out.println(name + " sieht, dass " + vorgaenger.gibName() + " gelogen hat.");

    }
    public int gibWert(int i){
        int wert = 0;
        switch (i){
            case 11: wert = 80;
            break;
            case 22: wert = 90;
            break;
            case 33: wert = 100;
            break;
            case 44: wert = 110;
            break;
            case 55: wert = 120;
            break;
            case 66: wert = 140;
            break;
            case 21: wert = 150;
            break;

            default: wert = i;
        }
        return wert;
    }
}

