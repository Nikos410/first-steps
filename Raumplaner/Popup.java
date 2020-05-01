import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Popup extends JFrame
{
    private JPanel mainP, auswahlP, buttonP;
    private JLabel L1, L2, L3, L4, L5;
    private JTextField TF1, TF2, TF3, TF4, TF5;
    private int typ_t;

    public Popup(int typ)
    {
        typ_t = typ;
        
        setResizable( false );
        setBounds(650,50, 500, 650);
        setTitle("Werte angeben");
        Container C = getContentPane();

        //mainP
        mainP = new JPanel();
        mainP.setLayout(new BoxLayout(mainP, BoxLayout.PAGE_AXIS));
        mainP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainP.setBackground(new Color(120, 120, 120));
        C.add(mainP);

        auswahlPErstellen(typ);
        mainP.add(auswahlPErstellen(typ));

        buttonPErstellen();
        mainP.add(buttonPErstellen());
        setVisible(true);
    }

    private Container auswahlPErstellen(int typ){
        auswahlP = new JPanel();
        auswahlP.setPreferredSize( new Dimension( 480, 500 ) );
        auswahlP.setLayout(new GridLayout(0, 2));
        auswahlP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if(typ == 1){
            L1 = new JLabel("Position X:");
            L1.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L1);
            TF1 = new JTextField("");
            TF1.setFont(new Font("Impact", Font.PLAIN,32));
            TF1.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF1);

            L2 = new JLabel("Position Y:");
            L2.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L2);
            TF2 = new JTextField("");
            TF2.setFont(new Font("Impact", Font.PLAIN,32));
            TF2.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF2);

            L3 = new JLabel("Breite:");
            L3.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L3);
            TF3 = new JTextField("");
            TF3.setFont(new Font("Impact", Font.PLAIN,32));
            TF3.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF3);

            L4 = new JLabel("Höhe:");
            L4.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L4);
            TF4 = new JTextField("");
            TF4.setFont(new Font("Impact", Font.PLAIN,32));
            TF4.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF4);
        }
        if(typ == 2){
            L1 = new JLabel("Position X:");
            L1.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L1);
            TF1 = new JTextField("");
            TF1.setFont(new Font("Impact", Font.PLAIN,32));
            TF1.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF1);

            L2 = new JLabel("Position Y:");
            L2.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L2);
            TF2 = new JTextField("");
            TF2.setFont(new Font("Impact", Font.PLAIN,32));
            TF2.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF2);

            L3 = new JLabel("Durchmesser:");
            L3.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L3);
            TF3 = new JTextField("");
            TF3.setFont(new Font("Impact", Font.PLAIN,32));
            TF3.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF3);
        }
        if(typ == 3){            
            L1 = new JLabel("Position X:");
            L1.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L1);
            TF1 = new JTextField("");
            TF1.setFont(new Font("Impact", Font.PLAIN,32));
            TF1.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF1);

            L2 = new JLabel("Position Y:");
            L2.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L2);
            TF2 = new JTextField("");
            TF2.setFont(new Font("Impact", Font.PLAIN,32));
            TF2.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF2);

            L3 = new JLabel("Breite:");
            L3.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L3);
            TF3 = new JTextField("");
            TF3.setFont(new Font("Impact", Font.PLAIN,32));
            TF3.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF3);

            L4 = new JLabel("Höhe:");
            L4.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L4);
            TF4 = new JTextField("");
            TF4.setFont(new Font("Impact", Font.PLAIN,32));
            TF4.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF4);
            
            L5 = new JLabel("Breite Lehne:");
            L5.setFont(new Font("Impact", Font.PLAIN,32));
            auswahlP.add(L5);
            TF5 = new JTextField("");
            TF5.setFont(new Font("Impact", Font.PLAIN,32));
            TF5.setHorizontalAlignment(JTextField.CENTER);
            auswahlP.add(TF5);
        }
        if(typ == 4){

        }
        return auswahlP;
    }

    private Container buttonPErstellen(){
        JButton button; //Mehrere Buttons

        buttonP = new JPanel();
        buttonP.setPreferredSize( new Dimension( 480, 130 ) );
        buttonP.setLayout(new GridLayout(0, 1, 0, 100));
        buttonP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        button = new JButton("Bestätigen");
        button.setFont(new Font("Impact", Font.PLAIN,32));
        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    bestaetigenAction();
                }
            });

        buttonP.add(button);

        buttonP.setBackground(new Color(140, 140, 255));
        return buttonP;
    }

    public int gibX(){
        int x = Integer.parseInt(TF1.getText());
        return x;
    }

    public int gibY(){
        int x = Integer.parseInt(TF2.getText());
        return x;
    }

    public int gibBreite(){
        int x = Integer.parseInt(TF3.getText());
        return x;
    }

    public int gibHoehe(){
        int x = Integer.parseInt(TF4.getText());
        return x;
    }

    public int gibLehne(){
        int x = Integer.parseInt(TF5.getText());
        return x;
    }

    private void bestaetigenAction(){
        if(typ_t == 1){
            DrawGUI.rechteckAction(gibX(), gibY(), gibBreite(), gibHoehe());
        }
        if(typ_t == 2){
            DrawGUI.kreisAction(gibX(), gibY(), gibBreite());
        }
        if(typ_t == 3){
            if(gibHoehe() <= gibLehne() || gibBreite() <= gibLehne()){
                System.err.println("Die Lehne muss schmaler als das Sofa sein");
            }
            else
                DrawGUI.sofaAction(gibX(), gibY(), gibBreite(), gibHoehe(), gibLehne());
        }

        /*/
        
        System.out.println("        ██ ]▄▄▄▄▄");
        System.out.println("  ▂▄▅███▅▄▃▂");
        System.out.println("[███████████]");
        System.out.println("◥⊙▲⊙▲⊙▲⊙▲⊙▲⊙◤");/**/
    }
}
