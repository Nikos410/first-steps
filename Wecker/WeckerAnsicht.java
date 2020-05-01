import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * 
 */
public class WeckerAnsicht extends UhrAnsicht
{
    protected JTextField weckTF;
    protected JLabel weckL;
    protected JPanel weckP;

    private static final boolean FARBIG = true; //farbige Anzeige der Panels

    public WeckerAnsicht()
    {
        super();

        setBounds(50,50,700,800);
        setTitle("WECKER");
        /** (0, 1) Alles untereinander */
        zeitP.setLayout(new GridLayout(0, 2));
        zeitP.setBackground(new Color(255, 255, 140));
        zeitTF.setFont(new Font("Impact", Font.BOLD,64));
        buttonP.setLayout(new GridLayout(0, 2, 3, 5));
        zeitL.setHorizontalAlignment(JTextField.CENTER);
        /** Anzahl der Spalten ist auf 2 gesetzt, 
         *  Anzahl der Reihen (setzung 0) wird automatisch ermittelt, 
         *  die beiden Zahlenwerte am Ende geben die Breite der Lücken an
         */
        mainP.add(weckPErstellen());
        mainP.add(wbuttonPErstellen());
    }

    private Container weckPErstellen()
    {               
        weckL = new JLabel("(Wecker aus)");
        weckL.setHorizontalAlignment(JTextField.CENTER);
        weckL.setFont(new Font("Impact", Font.PLAIN,52));
        weckL.setForeground(new Color(150, 150, 150));
        zeitP.add(weckL);

        weckTF = new JTextField("00:00:00");
        weckTF.setFont(new Font("Impact", Font.BOLD,64));
        weckTF.setHorizontalAlignment(JTextField.CENTER);
        weckTF.setEditable(true);
        weckTF.setBackground(new Color(150, 150, 150));

        zeitP.add(weckTF);
        if (FARBIG) zeitP.setBackground(new Color(255, 255, 140));
        return zeitP;
    }

    private Container wbuttonPErstellen()
    {
        JButton button;

        button = new JButton("Wecker stellen");
        button.setFont(new Font("Impact", Font.PLAIN,32));
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    weckerstellaktion();
                }
            });
        buttonP.add(button);

        button = new JButton("Wecker An/Aus");
        button.setFont(new Font("Impact", Font.PLAIN,32));
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    anausaktion();
                }
            });        
        buttonP.add(button);

        return buttonP;
    }

    public void weckerstellaktion()
    {
        weckzeit = weckTF.getText();
        System.out.println('\f' + "Der Wecker klingelt um " + weckzeit + " Uhr.");
    }

    private void anausaktion()
    {

        if(weckeran == false){
            if(weckzeit.equals("null")){              
                weckerstellaktion();                
            }            
                weckeran = true;
                
                weckTF.setText(weckzeit);               
                weckTF.setBackground(new Color(255, 80, 80));
                weckL.setFont(new Font("Impact", Font.PLAIN,36));
                weckL.setForeground(new Color(50, 50, 50));
                weckL.setText("Wecker klingelt um:");            
        }
        else{
            weckeran = false;
            
            weckTF.setBackground(new Color(150, 150, 150));            
            weckL.setFont(new Font("Impact", Font.PLAIN,52));
            weckL.setForeground(new Color(150, 150, 150));
            weckL.setText("(Wecker aus)");
        }
    }    
}

