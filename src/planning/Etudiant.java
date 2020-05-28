/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import planning.*;
/**
 *
 * @author flori
 */
public class Etudiant extends JPanel {
    
    public Etudiant()
    {
        
        Grille grille = new Grille();
        JRadioButton ENS = new JRadioButton("Enseignant");
        grille.add(ENS);
        
    }
    
    public static void main(String[] args)
    {
        
    }
}
