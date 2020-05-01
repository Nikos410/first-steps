import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DrawGUI extends JFrame
{
    //Attribute
    private Container C;
    private JPanel mainP;                  //Hauptpanel                    
    private JPanel buttonP,anzeigePanel;   //Die drei "Unterpanel"
    public static Zeichenbrett z; 
    private static Popup pu;

    private static boolean re_e = false;
    private static boolean kr_e = false;
    private static boolean s_e = false;

    /**
     * Konstruktor erzeugt das Zeichenbrett und das "AnzeigeFenster"
     */
    public DrawGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50,50, 560, 710);
        setTitle("PlanungsTool");
        C = getContentPane();
        z = new Zeichenbrett();
        z.setBounds(20,20,500,500);
        erstellePanel();
        setVisible(true);
    }

    /**
     * Erzeugt das mainP mit den "Unter-Paneln".
     */
    private void erstellePanel()
    {      
        //mainP
        mainP = new JPanel();
        mainP.setLayout(null);
        mainP.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainP.setBackground(new Color(120, 120, 120));
        C.add(mainP);  //Fuege mainP im JFrame ein

        //Fuege RGBBereich ein       
        mainP.add(z);      

        //Entsprechende Panels werden erstellt und hinzugefuegt.
        erstelleButtonP();
        mainP.add(buttonP);

        
    }

    /**
     * Das buttonP enthaelt die Schaltflaechen.
     */
    private void erstelleButtonP()
    {
        JButton button; //lokale Variabel für mehrere Buttons

        buttonP = new JPanel();
        buttonP.setLayout(new GridLayout(2, 2, 2, 2));
        buttonP.setBounds(20,530,500,120);
        buttonP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonP.setBackground(new Color(40, 200, 40));
        //Button1
        button = new JButton("Rechteck");
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt)
                {
                    Button1Action();
                }
            });        
        buttonP.add(button);

        button = new JButton("Kreis");
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    Button2Action();
                }
            });
        buttonP.add(button);

        button = new JButton("Sofa");
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    Button3Action();
                }
            });
        buttonP.add(button);

        button = new JButton("Rot/Schwarz");
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    rotSchwarzAction();
                }
            });
        buttonP.add(button);
    }

    /**
     * Reaktion auf den Mausklick auf den Button start.
     */
    private static void Button1Action()
    {

            pu = new Popup(1);           
            z.rotSchwarzCycle(); 
        
    }

    /**
     * Reaktion auf den Mausklick auf den Button Button2.
     */
    private void Button2Action()
    {
        if(kr_e == false){
            pu = new Popup(2);
        }
        else{ 
            z.rotSchwarzCycle();
        }
    }

    /**
     * Reaktion auf den Mausklick auf den Button Button3.
     */
    private void Button3Action()
    {
        if(s_e == false){
            pu = new Popup(3);           
        }
        else{ 
            z.rotSchwarzCycle();
        }
    }

    private void rotSchwarzAction()
    {
        z.rotSchwarz();
    }

    public static void rechteckAction(int posx, int posy, int b, int h){
        z.erzeugeRechteck(posx, posy, b, h);
    }

    public static void kreisAction(int posx, int posy, int d){
        z.erzeugeKreis(posx, posy, d);
    }

    public static void sofaAction(int posx, int posy, int b, int h, int l){
        z.erzeugeSofa(posx, posy, b, h, l);
    }
    

}

