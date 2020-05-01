import java.util.*;
public class Situation
{
    private SituationNode[][] situationArray;
    private List<SituationNode> selectedNodes = new ArrayList<>();

    public Situation() {
        situationArray = new SituationNode[9][9];
    }

    public void setField(int x, int y, Spieler spieler) {
        if (precheck(x, y)) {
            situationArray[x][y].setSpieler(spieler);
        }
    }

    public void deleteField(int x, int y) {
        if (precheck(x, y)) {
            situationArray[x][y].setSpieler(null);
        }
    }

    public Spieler getField(int x, int y) {
        if (precheck(x, y)) {
            return situationArray[x][y].getSpieler();
        }
        else {
            return null;
        } 
    }

    public boolean isEmpty (int x, int y) {
        if (precheck(x, y)) {
            return situationArray[x][y].getSpieler() == null;
        }
        else {
            return false;
        }
    }

    public void selectField(int x, int y) {
        if (precheck(x, y)) {
            situationArray[x][y].select();
            selectedNodes.add(situationArray[x][y]);
        }
    }

    public void deselectField(int x, int y) {
        if (precheck(x, y)) {
            situationArray[x][y].deselect();
            selectedNodes.remove(situationArray[x][y]);
        }
    }

    public void changeSelected(int x, int y) {
        if (!precheck(x, y)) {
            return;
        }

        if (situationArray[x][y].isSelected()) {
            deselectField(x, y);
        }
        else {
            selectField(x, y);
        }
    }

    public List<SituationNode> getSelectedNodes() {
        return selectedNodes;
    }

    public boolean isSelected(int x, int y) {
        if (precheck(x, y)) {
            return situationArray[x][y].isSelected();
        }
        return false;
    }

    private boolean precheck(int x, int y) {
        if (isValid(x, y)) {
            if (situationArray[x][y] ==  null) {
                situationArray[x][y] = new SituationNode(x,y, null);
            }

            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isValid(int x, int y) {
        // Außerhalb des Arrays
        if (!(x >= 0 && x <= 8 && y >= 0 && y <= 8)) {
            return false;
        }

        // Ungültige Felder
        if ((x+y) < 4 || (x+y) > 12) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public boolean isAdjacent (int x1, int y1, int x2, int y2) {
        return false;
    }

    public void print() {
        String space = "";
        for (int x = 0; x <= 8; x++) {
            if (x >= 5) {
                space = space + " ";
            }
            System.out.print(space);
            for (int y = 0; y <= 8; y++) {


                    if (!isValid(x, y)) {
                        System.out.print(" ");
                    }
                    else if (isEmpty(x, y)) {
                        System.out.print(" X");
                    }
                    else {
                        System.out.print(" " + situationArray[x][y].getSpieler().getName());
                    }

            }
            System.out.print('\n');
        }
    }
}
