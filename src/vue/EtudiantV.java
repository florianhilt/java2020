package vue;
import java.awt.*;
import javax.swing.*;

public class EtudiantV{
    
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
   
    
    
    public EtudiantV()
    {
        
        modele.EtudiantM etudiant = new modele.EtudiantM();
 
        JFrame frame = new JFrame("Page Etudiant");
        
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        
        frame.add(etudiant);
        frame.setVisible(true);
             
    }
    
    public static void main( String[] args){new EtudiantV();}
}

