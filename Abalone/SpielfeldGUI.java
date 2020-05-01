import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.Color;

class SpielfeldGUI extends JFrame {  
    private final static boolean DEBUG_INFO = true;
    
    ZeichenPanel zeichenPanel;
    
    Spiellogik logik;

    public SpielfeldGUI(Spiellogik logik){
        this.logik = logik;
        
        zeichenPanel = new ZeichenPanel();
        getContentPane().add(zeichenPanel);
        
        setSize(1000,1000);
        setResizable(true);
        setVisible(true);
    }

    private class ZeichenPanel extends JPanel {
        private final Color COLOR_BACKGROUND = new Color(200, 220, 220);
        private final Color COLOR_HEXAGON = new Color(0, 0, 0);
        private final Color COLOR_SELECTED = new Color (100, 200, 100);
        private final Color COLOR_PLAYER_WHITE = new Color(255, 255, 255);
        private final Color COLOR_PLAYER_BLACK = new Color(0, 0, 0);

        private final int HEXAGON_THICKNESS = 3;
        
        Graphics2D g2;

        Situation sit = null;
        SpielfeldNode[][] nodes = new SpielfeldNode[9][9];

        public ZeichenPanel() {
            this.addMouseListener(new ClickHandler());
        }

        public void rp(Situation s) {
            this.sit = s;
            repaint();
        }

        public void paint(Graphics g) {
            super.paint(g);
            this.g2 = (Graphics2D) g;

            /*
             * Hintergrund
             */
            g2.setColor(COLOR_BACKGROUND);
            g2.fillRect(0,0,1000,1000); 

            /*
             * Ausgewählte
             */
            for (int x = 0; x <= 8; x++){
                for (int y = 0; y <= 8; y++){
                    if (sit.isSelected(x, y)) {
                        nodes[x][y].setSelected();
                    }
                }
            }

            /*
             * Sechsecke erstellen
             */
            g2.setColor(COLOR_HEXAGON);
            for (int x = 0; x < 9; x++){             //Erstellen in x-Richtung
                for (int y = 0; y < 9; y++) {           //Erstenllen in y-Richtung
                    if ((x+y) < 4 || (x+y) > 12) {
                    }
                    else{
                        nodes[x][y] = new SpielfeldNode(x, y);
                    }
                }
            }

            /*
             * Spielsteine erstellen
             */
            for (int x = 0; x <= 8; x++){
                for (int y = 0; y <= 8; y++){  
                    Spieler s = sit.getField(x,y);
                    if (s != null){
                        if (s.isWhite()){
                            //setWhite(t,z);
                            nodes[x][y].setWhite();
                        }
                        else{
                            //setBlack(t,z);
                            nodes[x][y].setBlack();
                        }
                    }
                }
            }
        }

        private class ClickHandler extends MouseAdapter
        {       
            public void mouseClicked(MouseEvent e) { 
                findClickedHexagon(e.getX(), e.getY());
            }

            private void findClickedHexagon(int x, int y) {
                for (SpielfeldNode[] nodesRow : nodes) {
                    for (SpielfeldNode node : nodesRow) {
                        if (node != null && node.contains(x, y)) {
                            if (DEBUG_INFO) {
                                System.err.println("Hexagon @ " + node.getX() + " | " + node.getY());
                            }
                            logik.select(node.getX(), node.getY());
                            break;
                        }
                    }
                }
            }
        }

        private class SpielfeldNode {
            private final static int n = -20;                     //Abstand Rand x
            private final static int m =100;                      //Abstand Rand y
            private final static double xn = 86.6/2;              //Einheit x
            private final static double yn = 50 /2;               //Einheit y
            private final static int r = 2;                       //Abstand der Sechsecke x
            private final static int q = 3;                       //Abstand der Sechsecke y

            private int gameX;
            private int gameY;
            
            private double Ax,Ay,Bx,By,Cx,Cy,Dx,Dy,Ex,Ey,Fx,Fy;
            private int[] xArray;
            private int[] yArray;

            private Polygon hexagon;

            public SpielfeldNode(int x, int y) {
                gameX = x;
                gameY = y;


                Ax = n + gameY * r * xn + xn * gameX;
                Ay = m + gameX * q * yn;
                Bx = n + gameY * r * xn + xn * gameX + xn;
                By = m + gameX * q * yn + yn;
                Cx = n + gameY * r * xn + xn * gameX + xn;
                Cy = m + gameX * q * yn + 3 * yn;
                Dx = n + gameY * r * xn + xn * gameX;
                Dy = m + gameX * q * yn + 4 * yn;
                Ex = n + gameY * r * xn + xn * gameX - xn;
                Ey = m + gameX * q * yn + 3 * yn;
                Fx = n + gameY * r * xn + xn * gameX - xn;
                Fy = m + gameX * q * yn + yn;

                xArray = new int[6];
                yArray = new int[6];

                xArray[0] = (int)Ax;
                yArray[0] = (int)Ay;

                xArray[1] = (int)Bx;
                yArray[1] = (int)By;

                xArray[2] = (int)Cx;
                yArray[2] = (int)Cy;

                xArray[3] = (int)Dx;
                yArray[3] = (int)Dy;

                xArray[4] = (int)Ex;
                yArray[4] = (int)Ey;

                xArray[5] = (int)Fx;
                yArray[5] = (int)Fy;

                hexagon = new Polygon(xArray, yArray, 6);

                paintHexagon();  
            }

            private void setSelected() {
                g2.setColor(COLOR_SELECTED);
                g2.fillPolygon(hexagon);
            }

            private void setWhite() {
                double AAx = n + gameY * r * xn + xn * gameX -yn;
                double AAy = m + gameX * q * yn+ yn;
                g2.setColor(COLOR_PLAYER_WHITE);
                Ellipse2D.Double circle = new Ellipse2D.Double(AAx,AAy,2*yn,2*yn);
                g2.fill(circle);
            }

            private void setBlack() {
                double AAx = n + gameY * r * xn + xn * gameX -yn;
                double AAy = m + gameX * q * yn+ yn;
                g2.setColor(COLOR_PLAYER_BLACK);
                Ellipse2D.Double circle = new Ellipse2D.Double(AAx,AAy,2*yn,2*yn);
                g2.fill(circle);
            }

            public boolean contains(int x, int y) {
                return hexagon.contains(x, y);
            }

            public int getX() {
                return gameX;
            }

            public int getY() {
                return gameY;
            }

            private void paintHexagon(){

                g2.setColor(COLOR_PLAYER_BLACK);
                g2.setStroke(new BasicStroke(HEXAGON_THICKNESS));

                g2.drawPolygon(hexagon);
            }
        }
    }

    public void rp(Situation s){
        zeichenPanel.rp(s);
    }
}