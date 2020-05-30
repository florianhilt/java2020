/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import modele.ScolaritéM;


public class ScolaritéV extends JFrame implements ItemListener {
    
    
    JFrame frame = new JFrame();
    JPanel panel = (JPanel) frame.getContentPane();
    
    
    private String[] options = {"  ", "Ajouter une séance","Valider une séance"
            , "Annuler une séance","Modifier un cours"
            , "Ajouter un enseignant à une séance",
            "Ajouter une groupe à une séance", 
            "Retirer un groupe d'une séance",
            "Retirer un enseignant d'une séance"};
    private JComboBox<String> combobox = new JComboBox<String>(options);
    
    JLabel semaineL =  new JLabel("Semaine :");
    JLabel jourL =  new JLabel("Jour :");
    JLabel heuredL =  new JLabel("Heure de début :");
    JLabel heurefL =  new JLabel("Heure de fin :");
    JLabel etatL =  new JLabel("Etat :");
    JLabel matiereL =  new JLabel("Matière :");
    JLabel typeL =  new JLabel("Type :");
    JLabel groupeL =  new JLabel("Groupe :");
    JLabel promotionL =  new JLabel("Promotion :");
    JLabel salleL =  new JLabel("Salle :");
    JLabel siteL =  new JLabel("Site :");
    
    private String[] optionsSemaines =
            {"  ", "01","02"
            , "03","04"
            , "05" , "06","07"
            , "08", "09","10"
            , "11", "11","12"
            , "13", "14","15"
            , "16", "17","18"
            , "19","20", "21","22"
            , "23","24", "25","26"
            , "27","28", "29","30"
            , "31","32", "33","34"
            , "35","36", "37","38"
            , "39","40", "41","42"
            , "43","44", "45","46"
            , "47","48","49", "50","51"
            , "52"};
    private JComboBox<String> comboboxSemaines = new JComboBox<String>(optionsSemaines);
    
    private String[] optionsJours =
            {"  ", "Lundi","Mardi"
            , "Mercredi","Jeudi"
            , "Vendredi" , "Samedi"};
    private JComboBox<String> comboboxJours = new JComboBox<String>(optionsJours);
    
    
    private String[] optionsHeureD =
            {"  ", "9h00","10h00"
            , "11h00","12h00"
            , "13h00" , "14h00","15h00"
            , "16h00", "17h00","18h00"};
    private JComboBox<String> comboboxHeureD = new JComboBox<String>(optionsHeureD);
    
    private String[] optionsHeureF =
            {"  ","10h00"
            , "11h00","12h00"
            , "13h00" , "14h00","15h00"
            , "16h00", "17h00","18h00",
            "19h00"};
    private JComboBox<String> comboboxHeureF = new JComboBox<String>(optionsHeureF);
    
    private String[] optionEtat =
            {"  ", "Annuler"};
    private JComboBox<String> comboboxEtat = new JComboBox<String>(optionEtat);
    
    private String[] optionMatiere = {"  ", };
    private JComboBox<String> comboboxMatiere = new JComboBox<String>(optionMatiere);
 
    public ScolaritéV(){
        
    ScolaritéM scola = new ScolaritéM();
    ArrayList<String> Matière = scola.getMatiere();
    
    for (String m : Matière) 
    {
        comboboxMatiere.addItem(m);
    }
    
    combobox.addItemListener(this);
    PlacementComboboxCenter(combobox,120);
    JLabel lb2 = new JLabel("Que voulez-vous faire ?");
    lb2.setFont(new Font("Arial",10 , 14));
    JLabel lb = new JLabel("Page Scolarité");
    lb.setFont(new Font("Arial",10 , 26));
    PlacementLabelCenter(lb, 40);
    PlacementLabelCenter(lb2, 100);

    panel.setLayout(null);
    frame.setTitle("Page Scolarité");

    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(600,650);
    frame.setVisible(true);
    
    }
    
    public void Placement(JLabel label, int w, int h)
    {
        panel.add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(w, h, size.width, size.height);
    }
    
    
    public void DontDisplayL(JLabel label)
    {
        label.setVisible(false);
    }
  
    public void DontDisplayTF(JTextField label)
    {
        label.setVisible(false);
    }

    public void DisplayL(JLabel label)
    {
        label.setVisible(true);
    }

    public void DisplayTF(JTextField label)
    {
        label.setVisible(true);
    }
    
    public void DisplayCB(JComboBox box)
    {
        box.setVisible(true);
    }

    public void PlacementButtonCenter(JButton button, int h)
    {
        int w;
        panel.add(button);
        Dimension size1 = button.getPreferredSize();
        w = 300-(size1.width/2);
        button.setBounds(w, h, size1.width, size1.height);   
    }

    public void PlacementComboboxCenter(JComboBox button, int h)
    {
        int w;
        panel.add(button);
        Dimension size1 = button.getPreferredSize();
        w = 300-(size1.width/2);
        button.setBounds(w, h, size1.width, size1.height);   
    }

    public void PlacementLabelCenter(JLabel button, int h)
    {
        int w;
        panel.add(button);
        Dimension size1 = button.getPreferredSize();
        w = 300-(size1.width/2);
        button.setBounds(w, h, size1.width, size1.height);   
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if(e.getSource() == combobox){
                  DisplayL(semaineL);
                  DisplayL(jourL);
                  DisplayL(heuredL);
                  DisplayL(heurefL);
                  DisplayL(etatL);
                  DisplayCB(comboboxSemaines);
                  DisplayCB(comboboxJours);
                  DisplayCB(comboboxHeureD);
                  DisplayCB(comboboxHeureF);
                  DisplayCB(comboboxEtat);               
                 
            if(combobox.getSelectedItem().equals("Ajouter une séance"))
            {
                  

                Placement(semaineL, 170, 210);
                panel.add(comboboxSemaines);
                Dimension size1 = comboboxSemaines.getPreferredSize();
                comboboxSemaines.setBounds(270, 207, 150, 20);  
               
                Placement(jourL, 180, 250);
                panel.add(comboboxJours);
                comboboxJours.setBounds(270,248, 150, 20);

                Placement(heuredL, 155, 290);
                panel.add(comboboxHeureD);
                comboboxHeureD.setBounds(270,288, 150, 20);

                Placement(heurefL, 162, 330);
                panel.add(comboboxHeureF);
                comboboxHeureF.setBounds(270,328, 150, 20);
                
                Placement(matiereL, 173, 370);
                panel.add(comboboxMatiere);
                comboboxMatiere.setBounds(270,368, 150, 20);

                panel.validate();
            }

      }
    }

    public static void main( String[] args){new ScolaritéV();}

    
    
}
