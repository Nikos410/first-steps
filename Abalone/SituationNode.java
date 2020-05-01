public class SituationNode {
    private int xPos, yPos;

    private Spieler spieler;

    private boolean isSelected = false;

    public SituationNode(int xPos, int yPos, Spieler spieler) {
        this.xPos = xPos;
        this.yPos = yPos;

        this.spieler = spieler;    
    }

    public void select() {
        isSelected = true;
    }
    public void deselect() {
        isSelected = false;
    }
    public boolean isSelected() {
        return isSelected;
    }

    public void setSpieler(Spieler spieler) {
        this.spieler = spieler;    
    }
    public Spieler getSpieler() {
        return spieler;
    }
    
    public int getX() {
        return xPos;
    }
    public int getY() {
        return yPos;
    }
}