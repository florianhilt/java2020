package planning;
import planning.*;
import java.awt.*;
import javax.swing.*;

public class PageEtudiant{
    
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
   
    
    /*public Fenetre(){
        this.setTitle("hello");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(new Template());
        .setLayout(new OverlayLayout(pan));
 
        }*/
    
    
    public static void main(String[] args)
    {
        
        Grille Grille = new Grille();
        Etudiant etudiant = new Etudiant();
        
        JLabel Test = new JLabel("Test");
        JFrame frame = new JFrame("Tuto");
        
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        
        
        frame.add(etudiant);
        frame.add(Grille);
        frame.setVisible(true);
        
        
     
    }
}

