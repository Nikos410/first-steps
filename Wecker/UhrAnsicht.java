import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UhrAnsicht extends JFrame
{
    //Konstanten
    private static final boolean FARBIG = true; //farbige Anzeige der Panels
    public boolean weckeran = false;
    //Datenfelder
    protected Uhrenanzeige uhr;
    protected Timer timer;
    protected JPanel mainP;
    protected JTextField zeitTF;
    protected JLabel zeitL;
    protected JPanel zeitP;  
    protected JPanel buttonP;

    public String weckzeit = "null";

    /**
     * Konstruktor erzeugt die Uhr und den Timer.
     */
    public UhrAnsicht()
    {
        //Uhr erzeugen
        uhr = new Uhrenanzeige();
        //Timer erzeugen  s. Text
        timer = new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent a) {
                    timerAufgabe ();//So soll die Methode heissen s.u.
                }// Alle 1000 Millisekunden
            });    
        erzeugeFenster();
    }

    private void erzeugeFenster()
    {
        //Sicherstellen, dass die Anwendung beendet wird, wenn der
        //Benutzer das Fenster schliesst.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50,50, 200, 300);
        setTitle("Uhr");
        Container C = getContentPane();

        //mainP
        mainP = new JPanel();
        mainP.setLayout(new BoxLayout(mainP, BoxLayout.PAGE_AXIS));
        mainP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        if (FARBIG) mainP.setBackground(new Color(120, 120, 120));
        C.add(mainP);

        mainP.add(zeitPErstellen());
        mainP.add(buttonPErstellen());        
        setVisible(true);
    }

    private Container zeitPErstellen()
    {
        zeitP = new JPanel();
        zeitP.setLayout(new GridLayout(0, 1));
        zeitP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //zeitL
        zeitL = new JLabel("Uhrzeit:");
        zeitL.setFont(new Font("Impact", Font.PLAIN,52));
        zeitL.setHorizontalAlignment(JTextField.CENTER);
        zeitP.add(zeitL);
        //zeitTF
        zeitTF = new JTextField("00:00:00");
        zeitTF.setFont(new Font("Impact", Font.BOLD,64));
        zeitTF.setHorizontalAlignment(JTextField.CENTER);
        zeitTF.setEditable(true);
        zeitP.add(zeitTF);

        if (FARBIG) zeitP.setBackground(new Color(255, 255, 140));
        return zeitP;
    }

    private Container buttonPErstellen()
    {
        JButton button; //Mehrere Buttons

        buttonP = new JPanel();
        buttonP.setLayout(new GridLayout(0, 1, 5, 5));
        buttonP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        button = new JButton("Start");
        button.setFont(new Font("Impact", Font.PLAIN,32));
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    startAction();
                }
            });

        buttonP.add(button);

        button = new JButton("Pause");
        button.setFont(new Font("Impact", Font.PLAIN,32));
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    stoppAction();
                }
            });
        buttonP.add(button);

        button = new JButton("Uhr stellen");
        button.setFont(new Font("Impact", Font.PLAIN,32));
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    stellenAction();
                }
            });
        buttonP.add(button);

        button = new JButton("Reset");
        button.setFont(new Font("Impact", Font.PLAIN,32));
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    resetAction();
                }
            });
        buttonP.add(button);


        if (FARBIG) buttonP.setBackground(new Color(140, 140, 255));
        return buttonP;
    }

    public void stellenAction(){
        timer.stop();
        String zs = zeitTF.getText();
        int h = Integer.parseInt(zs.substring(0,2));
        int m = Integer.parseInt(zs.substring(3,5));
        int s = Integer.parseInt(zs.substring(6,8));        
        uhr.setzeUhrzeit(h,m,s);
    }    

    private void startAction()
    {
        timer.start();
    }

    private void stoppAction()
    {
        timer.stop();
    }

    private void resetAction()
    {
        timer.stop();

        uhr.setzeUhrzeit(00,00,00);
        uhr.anzeigeAktualisieren();
        zeitTF.setText(uhr.gibUhrzeit());
    }

    private void endeAction()
    {
        timer.stop();
        System.exit(0);
    }

    private void timerAufgabe() {
        uhr.gibTaktsignal();
        zeitTF.setText(uhr.gibUhrzeit());

        weckerabfrage();
    }   

    private void weckerabfrage(){
        if(weckeran == true){
            if(weckzeit.equals(uhr.gibUhrzeit())){
                //System.out.println('\f');
                System.out.println("KLINGELING");
            }
        }
    }
}