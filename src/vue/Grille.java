package vue;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * Cette classe sert de template d'affichage de la grille posititionné en arrière plan
 * des pages interface étudiants et enseignants
 * @author flori
 */

public class Grille extends JPanel {
    
    JFrame frame = new JFrame();
    JPanel panel = (JPanel) frame.getContentPane();  
    
    public void paintComponent(Graphics g)
    {
        //jours (vertical)
        g.drawLine(100, 70, 100, 610);
        g.drawLine(266, 70, 266, 610);
        g.drawLine(433, 70, 433, 610);
        g.drawLine(598, 70, 598, 610);
        g.drawLine(765, 70, 765, 610);
        g.drawLine(931, 70, 931, 610);
        g.drawLine(1097, 70, 1097, 610);
        
        
        //heures (horizontal)
        g.drawLine(100, 70, 1097, 70);
        g.drawLine(100, 178, 1097, 178);
        g.drawLine(100, 286, 1097, 286);
        g.drawLine(100, 394, 1097, 394);
        g.drawLine(100, 502, 1097, 502);
        g.drawLine(100, 610, 1097, 610);
        
      
        
    }
    
    
    public Grille()
    {
        setLayout(null);
        
        
        //jours
        JLabel lundi = new JLabel("Lundi");
        Dimension size2 = lundi.getPreferredSize();
        lundi.setBounds(160, 50, size2.width, size2.height);
        add(lundi);
        
        JLabel mardi = new JLabel("Mardi");
        Dimension size3 = mardi.getPreferredSize();
        mardi.setBounds(326, 50, size3.width, size3.height);
        add(mardi);
        
        JLabel mercredi = new JLabel("Mercredi");
        Dimension size4 = mercredi.getPreferredSize();
        mercredi.setBounds(492, 50, size4.width, size4.height);
        add(mercredi);
        
        JLabel jeudi = new JLabel("Jeudi");
        Dimension size5 = jeudi.getPreferredSize();
        jeudi.setBounds(658, 50, size5.width, size5.height);
        add(jeudi);
        
        JLabel vendredi = new JLabel("Vendredi");
        Dimension size6 = vendredi.getPreferredSize();
        vendredi.setBounds(824, 50, size6.width, size6.height);
        add(vendredi);
        
        JLabel samedi = new JLabel("Samedi");
        Dimension size7 = samedi.getPreferredSize();
        samedi.setBounds(990, 50, size7.width, size7.height);
        add(samedi);
        
        
        
        
        //heures
        JLabel NeufH = new JLabel("9h00");
        Dimension size8 = NeufH.getPreferredSize();
        NeufH.setBounds(65, 65, size8.width, size8.height);
        add(NeufH);
        
        JLabel DixH = new JLabel("10h00");
        Dimension size9 = DixH.getPreferredSize();
        DixH.setBounds(60, 111, size9.width, size9.height);
        add(DixH);
        
        JLabel OnzeH = new JLabel("11h00");
        Dimension size10 = OnzeH.getPreferredSize();
        OnzeH.setBounds(60, 170, size10.width, size10.height);
        add(OnzeH);
        
        JLabel DouzeH = new JLabel("12h00");
        Dimension size11 = DouzeH.getPreferredSize();
        DouzeH.setBounds(60, 224, size11.width, size11.height);
        add(DouzeH);
        
        JLabel TreizeH = new JLabel("13h00");
        Dimension size12 = TreizeH.getPreferredSize();
        TreizeH.setBounds(60, 278, size12.width, size12.height);
        add(TreizeH);
        
        JLabel QuatorzeH = new JLabel("14h00");
        Dimension size13 = QuatorzeH.getPreferredSize();
        QuatorzeH.setBounds(60, 332, size13.width, size13.height);
        add(QuatorzeH);
        
        JLabel QuinzeH = new JLabel("15h00");
        Dimension size14 = QuinzeH.getPreferredSize();
        QuinzeH.setBounds(60, 386, size14.width, size14.height);
        add(QuinzeH);
        
        JLabel SeizeH = new JLabel("16h00");
        Dimension size15 = SeizeH.getPreferredSize();
        SeizeH.setBounds(60, 440, size15.width, size15.height);
        add(SeizeH);
        
        JLabel DixSeptH = new JLabel("17h00");
        Dimension size16 = DixSeptH.getPreferredSize();
        DixSeptH.setBounds(60, 494, size16.width, size16.height);
        add(DixSeptH);
        
        JLabel DixHuitH = new JLabel("18h00");
        Dimension size17 = DixHuitH.getPreferredSize();
        DixHuitH.setBounds(60, 548, size17.width, size17.height);
        add(DixHuitH);
        
        JLabel DixNeufH = new JLabel("19h00");
        Dimension size18 = DixNeufH.getPreferredSize();
        DixNeufH.setBounds(60, 602, size18.width, size18.height);
        add(DixNeufH);
    }
    
    
}
