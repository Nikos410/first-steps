
/**
 * @author Jan-David Ridder
 * @version 1.0
 */
public class Spiellogik
{
    private Spieler spieler1;
    private Spieler spieler2;
    private Situation situation;
    private SpielfeldGUI gui;
   
    private boolean whiteActive = true; // Weiß beginnt
    
    private Spiellogik(String pName1, String pName2)
    {
        situation = new Situation();
        spieler1 = new Spieler(pName1, true);
        spieler2 = new Spieler(pName2, false);
        gui = new SpielfeldGUI(this);
    }

    public void startaufstellung() {
        // Spieler 1
        for (int y = 4; y <= 8; y++) {
            situation.setField(0, y, spieler1);
        }
        for (int y = 3; y <= 8; y++) {
            situation.setField(1, y, spieler1);
        }
        for (int y = 4; y <= 6; y++) {
            situation.setField(2, y, spieler1);
        }

        //Kugeln von Spieler 2
        for (int y = 0; y <= 4; y++) {
            situation.setField(8, y, spieler2);
        }
        for (int y = 0; y <= 5; y++) {
            situation.setField(7, y, spieler2);
        }
        for (int y = 2; y <= 4; y++) {
            situation.setField(6, y, spieler2);
        }

        gui.rp(situation);
    }
    
    public void select (int x, int y) {        
        if (!isOwnField(x, y)) {
            if (situation.getSelectedNodes().size() == 0){
                System.out.println("[INFO] Bitte eigene Kugel auswählen!");
                return;
            }
            // Kugeln verschieben
            
        }
        else {
            // Kugel angeklickt
            if (situation.isSelected(x, y)) {
                // Kugel abwählen
                situation.deselectField(x, y);
            }
            else {
                // Kugel anwählen
                if (situation.getSelectedNodes().size() < 3) {
                    situation.selectField(x, y);
                }
                else {
                    System.out.println("[INFO] Es können maximal 3 Kugeln angewählt werden!");
                }
            }
            
        }
        
        
        gui.rp(situation);
    }
    
    private boolean isOwnField(int x, int y) {
        if (situation.isEmpty(x, y)) {
            return false;
        }
        
        if ((whiteActive && situation.getField(x, y).isBlack()) || (!whiteActive && situation.getField(x, y).isWhite())) {
            return false;
        }
        
        return true;
    }
    
    public Situation getSituation() {
        return situation;
    }
    
    public void reset() {
        for (int x=0; x<=8; x++){
            for (int y=0; y<=8; y++) {
                if(situation.isValid(x,y)) {
                situation.deleteField(x,y);
            }
            }
        }
    }
    
    public static void main(String[] args){
        new Spiellogik("A","B").startaufstellung();        
    }
}
