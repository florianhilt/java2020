/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import controleur.ScolaritéC;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import modele.ScolaritéM;


public class ScolaritéV extends JFrame implements ItemListener, ActionListener {
    
    
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
    JLabel lieuL =  new JLabel("Lieu :");
    JLabel enseignantL =  new JLabel("Enseignant :");
    
    private String[] optionsSemaines =
            {" ", "01","02"
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
            {" ", "Lundi","Mardi"
            , "Mercredi","Jeudi"
            , "Vendredi" , "Samedi"};
    private JComboBox<String> comboboxJours = new JComboBox<String>(optionsJours);
    
    
    private String[] optionsHeureD =
            {" ", "9h00","10h00"
            , "11h00","12h00"
            , "13h00" , "14h00","15h00"
            , "16h00", "17h00","18h00"};
    private JComboBox<String> comboboxHeureD = new JComboBox<String>(optionsHeureD);
    
    private String[] optionsHeureF =
            {" ","10h00"
            , "11h00","12h00"
            , "13h00" , "14h00","15h00"
            , "16h00", "17h00","18h00",
            "19h00"};
    private JComboBox<String> comboboxHeureF = new JComboBox<String>(optionsHeureF);
    
    private String[] optionEtat =
            {"  ", "Annuler"};
    private JComboBox<String> comboboxEtat = new JComboBox<String>(optionEtat);
    
    private String[] optionMatiere = {"  ",};
    private JComboBox<String> comboboxMatiere = new JComboBox<String>(optionMatiere);

    private String[] optionEnseignantTH = {" ", "Thomas Guillemot", "Christine Crambes"};
    private JComboBox<String> comboboxEnseignantTH = new JComboBox<String>(optionEnseignantTH);
    
    private String[] optionEnseignantEL = {" ", "Thomas Guillemot", "Christine Crambes"};
    private JComboBox<String> comboboxEnseignantEL = new JComboBox<String>(optionEnseignantEL);
    
    private String[] optionEnseignantAF = {" ", "Fabienne Coudray"};
    private JComboBox<String> comboboxEnseignantAF = new JComboBox<String>(optionEnseignantAF);
    
    private String[] optionEnseignantMA = {" ", "Fabienne Coudray"};
    private JComboBox<String> comboboxEnseignantMA = new JComboBox<String>(optionEnseignantMA);
    
    private String[] optionEnseignantNull = {" "};
    private JComboBox<String> comboboxEnseignantNull = new JComboBox<String>(optionEnseignantNull);
    
    private String[] optionGroupeNull = {" "};
    private JComboBox<String> comboboxGroupeNull = new JComboBox<String>(optionGroupeNull);
    
    private String[] optionType = {" ", "Amphi", "TD", "TP", "DS", "Demi-Groupe"};
    private JComboBox<String> comboboxType = new JComboBox<String>(optionType);
    
    private String[] optionPromotion = {" ", "ING1", "ING2", "ING3"};
    private JComboBox<String> comboboxPromotion = new JComboBox<String>(optionPromotion);
    
    private String[] optionGroupe = {"  ", "TD01", "TD02"};
    private JComboBox<String> comboboxGroupe = new JComboBox<String>(optionGroupe);
    
    private String[] optionSite = {"  ", "E1", "E2", "E4"};
    private JComboBox<String> comboboxSite = new JComboBox<String>(optionSite);
    
    private String[] optionE1 = {"  ", "EM009", "SC210"};
    private JComboBox<String> comboboxE1 = new JComboBox<String>(optionE1);
    
    private String[] optionE2 = {"  ", "P445", "P417"};
    private JComboBox<String> comboboxE2 = new JComboBox<String>(optionE2);
    
    private String[] optionE4 = {"  ", "G002", "G006"};
    private JComboBox<String> comboboxE4 = new JComboBox<String>(optionE4);
    
    private String[] optionSiteNull = {"  "};
    private JComboBox<String> comboboxSiteNull = new JComboBox<String>(optionSiteNull);
    
    JButton Valider = new JButton("Valider");
    
    
    
    public ScolaritéV(){
        
    ScolaritéM scola = new ScolaritéM();
    ArrayList<String> Matière = scola.getMatiere();
    
    for (String m : Matière) 
    {
        comboboxMatiere.addItem(m);
    }
    
    JLabel lb2 = new JLabel("Que voulez-vous faire ?");
    lb2.setFont(new Font("Arial",10 , 14));
    JLabel lb = new JLabel("Page Scolarité");
    lb.setFont(new Font("Arial",10 , 26));
    
    PlacementLabelCenter(lb, 40);
    PlacementLabelCenter(lb2, 100);
    PlacementComboboxCenter(combobox,120);
    
    
    comboboxMatiere.addItemListener(this);
    comboboxSite.addItemListener(this);
    combobox.addItemListener(this);
    comboboxPromotion.addItemListener(this);
    
    Valider.addActionListener(this);
    
    
    panel.setLayout(null);
    frame.setTitle("Page Scolarité");
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(600,650);
    frame.setVisible(true);
    
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
    
    public void DontDisplayCB(JComboBox box)
    {
        box.setVisible(false);
    }
    
    public void DontDisplayB(JButton button)
    {
        button.setVisible(false);
    }
    
    public void DisplayB(JButton button)
    {
        button.setVisible(false);
    }
    
    
    public void Placement(JLabel label, int w, int h)
    {
        panel.add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(w, h, size.width, size.height);
    }
    
    public void PlacementButton(JButton button, int w, int h)
    {
        panel.add(button);
        Dimension size1 = button.getPreferredSize();
        button.setBounds(w, h, size1.width, size1.height);
        button.setVisible(true);
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

    public void PlacementLabelCenter(JLabel label, int h)
    {
        int w;
        panel.add(label);
        Dimension size1 = label.getPreferredSize();
        w = 300-(size1.width/2);
        label.setBounds(w, h, size1.width, size1.height);   
    }
    
    
    
    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if(e.getSource() == combobox || e.getSource() == comboboxMatiere 
                || e.getSource() == comboboxSite || e.getSource() == comboboxPromotion){
                  DisplayL(semaineL);
                  DisplayL(jourL);
                  DisplayL(heuredL);
                  DisplayL(heurefL);
                  DisplayL(etatL);
                  DisplayL(matiereL);
                  DisplayL(promotionL);
                  DisplayL(groupeL);
                  DisplayL(lieuL);
                  DisplayB(Valider);
                  
                  DisplayCB(comboboxGroupeNull);
                  DisplayCB(comboboxMatiere);
                  DisplayCB(comboboxSiteNull);
                  DisplayCB(comboboxSemaines);
                  DisplayCB(comboboxJours);
                  DisplayCB(comboboxHeureD);
                  DisplayCB(comboboxHeureF);
                  DisplayCB(comboboxEtat); 
                  DisplayCB(comboboxPromotion); 
                  DisplayCB(comboboxGroupe); 
                  DisplayCB(comboboxSite);
                  DisplayCB(comboboxEnseignantTH); 
                  DisplayCB(comboboxEnseignantMA); 
                  DisplayCB(comboboxEnseignantEL);
                  DisplayCB(comboboxEnseignantAF);
                  DisplayCB(comboboxEnseignantNull);
                  DisplayCB(comboboxE1);
                  DisplayCB(comboboxE2);
                  DisplayCB(comboboxE4);
                  
                 
            if(combobox.getSelectedItem().equals("Ajouter une séance"))
            {
                Color myRed = new Color(234, 96, 96);  
                
                
                semaineL.setForeground(myRed);
                Placement(semaineL, 170, 170);
                panel.add(comboboxSemaines);
                Dimension size1 = comboboxSemaines.getPreferredSize();
                comboboxSemaines.setBounds(270, 167, 150, 20);  
               
                jourL.setForeground(myRed);
                Placement(jourL, 180, 210);
                panel.add(comboboxJours);
                comboboxJours.setBounds(270,208, 150, 20);

                heuredL.setForeground(myRed);
                Placement(heuredL, 155, 250);
                panel.add(comboboxHeureD);
                comboboxHeureD.setBounds(270,248, 150, 20);

                heurefL.setForeground(myRed);
                Placement(heurefL, 162, 290);
                panel.add(comboboxHeureF);
                comboboxHeureF.setBounds(270,288, 150, 20);
                
                matiereL.setForeground(myRed);
                Placement(matiereL, 173, 330);
                panel.add(comboboxMatiere);
                comboboxMatiere.setBounds(270,328, 150, 20);
                
                Placement(typeL, 178, 370);
                panel.add(comboboxType);
                comboboxType.setBounds(270,368, 150, 20);
                
                Placement(enseignantL, 164, 410);
                panel.add(comboboxEnseignantNull);
                comboboxEnseignantNull.setBounds(270,408, 150, 20);
                
                
                if(comboboxMatiere.getSelectedItem().equals("Thermodynamique"))
                {
                    DontDisplayCB(comboboxEnseignantNull);
                    DontDisplayCB(comboboxEnseignantEL);
                    DontDisplayCB(comboboxEnseignantAF);
                    DontDisplayCB(comboboxEnseignantMA);
                    
                    
                    panel.add(comboboxEnseignantTH);
                    comboboxEnseignantTH.setBounds(270,408, 150, 20);
                }
                
                if(comboboxMatiere.getSelectedItem().equals("Electromagnetisme"))
                {
                    DontDisplayCB(comboboxEnseignantNull);
                    DontDisplayCB(comboboxEnseignantTH);
                    DontDisplayCB(comboboxEnseignantAF);
                    DontDisplayCB(comboboxEnseignantMA);
                    
                    
                    panel.add(comboboxEnseignantEL);
                    comboboxEnseignantEL.setBounds(270,408, 150, 20);
                }
                
                if(comboboxMatiere.getSelectedItem().equals("Analyse de Fourier"))
                {
                    DontDisplayCB(comboboxEnseignantNull);
                    DontDisplayCB(comboboxEnseignantTH);
                    DontDisplayCB(comboboxEnseignantEL);
                    DontDisplayCB(comboboxEnseignantMA);
                    
                    panel.add(comboboxEnseignantAF);
                    comboboxEnseignantAF.setBounds(270,408, 150, 20);
                }
                
                if(comboboxMatiere.getSelectedItem().equals("Mathematiques"))
                {
                    DontDisplayCB(comboboxEnseignantNull);
                    DontDisplayCB(comboboxEnseignantTH);
                    DontDisplayCB(comboboxEnseignantEL);
                    DontDisplayCB(comboboxEnseignantAF);
                    
                    panel.add(comboboxEnseignantMA);
                    comboboxEnseignantMA.setBounds(270,408, 150, 20);
                }
                
                if(comboboxMatiere.getSelectedItem().equals("  "))
                {
                    DontDisplayCB(comboboxEnseignantTH);
                    DontDisplayCB(comboboxEnseignantEL);
                    DontDisplayCB(comboboxEnseignantAF);
                    DontDisplayCB(comboboxEnseignantMA);
                    
                    
                    DisplayCB(comboboxEnseignantNull);
                }
                
                Placement(promotionL, 165, 450);
                promotionL.setForeground(myRed);
                panel.add(comboboxPromotion);
                comboboxPromotion.setBounds(270,448, 150, 20);
                
                Placement(groupeL, 173, 490);
 
                
                panel.add(comboboxGroupeNull);
                comboboxGroupeNull.setBounds(270,488, 150, 20);
                
                
                
                if(comboboxPromotion.getSelectedItem().equals(" "))
                {
                    DisplayCB(comboboxGroupeNull);
                    DontDisplayCB(comboboxGroupe);
                }
                
                if(comboboxPromotion.getSelectedItem().equals("ING1") || comboboxPromotion.getSelectedItem().equals("ING2") 
                        || comboboxPromotion.getSelectedItem().equals("ING3"))
                {
                    DontDisplayCB(comboboxGroupeNull);
                    panel.add(comboboxGroupe);
                    comboboxGroupe.setBounds(270,488, 150, 20);
                }
                
                Placement(lieuL, 180, 530);
                panel.add(comboboxSite);
                comboboxSite.setBounds(270,528, 70, 20);
                
                panel.add(comboboxSiteNull);
                comboboxSiteNull.setBounds(350,528, 70, 20);
                
                if(comboboxSite.getSelectedItem().equals("  "))
                {
                    DisplayCB(comboboxSiteNull);
                    DontDisplayCB(comboboxE2);
                    DontDisplayCB(comboboxE4);
                    DontDisplayCB(comboboxE1);
                }
                
                if(comboboxSite.getSelectedItem().equals("E1"))
                {
                    DontDisplayCB(comboboxSiteNull);
                    DontDisplayCB(comboboxE2);
                    DontDisplayCB(comboboxE4);                    
                    
                    panel.add(comboboxE1);
                    comboboxE1.setBounds(350,528, 70, 20);
                }
                
                if(comboboxSite.getSelectedItem().equals("E2"))
                {
                    DontDisplayCB(comboboxSiteNull);
                    DontDisplayCB(comboboxE1);
                    DontDisplayCB(comboboxE4);                    
                    
                    panel.add(comboboxE2);
                    comboboxE2.setBounds(350,528, 70, 20);
                }
                
                if(comboboxSite.getSelectedItem().equals("E4"))
                {
                    DontDisplayCB(comboboxSiteNull);
                    DontDisplayCB(comboboxE2);
                    DontDisplayCB(comboboxE1);                    
                    
                    panel.add(comboboxE4);
                    comboboxE4.setBounds(350,528, 70, 20);
                }
                
                JLabel champs = new JLabel("Champs obligatoires");
                
                champs.setForeground(myRed);
                PlacementLabelCenter(champs, 570);
                panel.add(champs);

                panel.validate();
                
                PlacementButton(Valider, 465, 350);
                
            }
            
            
            

      }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if((combobox.getSelectedItem().equals("Ajouter une séance")))
        {
            if((comboboxSemaines.getSelectedItem().equals(" "))||(comboboxJours.getSelectedItem().equals(" "))||
                    (comboboxHeureD.getSelectedItem().equals(" "))||(comboboxHeureF.getSelectedItem().equals(" "))
                    ||(comboboxMatiere.getSelectedItem().equals(" ")) ||(comboboxPromotion.getSelectedItem().equals(" ")))
            {
                JOptionPane.showMessageDialog(null, "Veuillez saisir toutes les informations obligatoires");
            }
            else
            {
                String Semaine, EnseignantTH, EnseignantAF, EnseignantEL, EnseignantMA;
                int etat = 1;
                String Jour, heureD, heureF, cours, type, groupe, promotion, salleE1, salleE2, salleE4, salleNull;



                Semaine = comboboxSemaines.getSelectedItem().toString();
                Jour = comboboxJours.getSelectedItem().toString();
                heureD = comboboxHeureD.getSelectedItem().toString();
                heureF = comboboxHeureF.getSelectedItem().toString();
                cours = comboboxMatiere.getSelectedItem().toString();
                type = comboboxType.getSelectedItem().toString();
                groupe = comboboxGroupe.getSelectedItem().toString();
                promotion = comboboxPromotion.getSelectedItem().toString();
                salleE1 = comboboxE1.getSelectedItem().toString();
                salleE2 = comboboxE2.getSelectedItem().toString();
                salleE4 = comboboxE4.getSelectedItem().toString();
                salleNull = comboboxSiteNull.getSelectedItem().toString();

                ScolaritéC scolaC = new ScolaritéC();
                scolaC.CreerSeance(Semaine, Jour, heureD, heureF, etat, cours, type);

                if(comboboxMatiere.getSelectedItem().equals("Thermodynamique"))
                {
                    EnseignantTH = comboboxEnseignantTH.getSelectedItem().toString();
                    scolaC.CreerSeanceEnseignant(EnseignantTH, Semaine, Jour, heureD, heureF, etat, cours, type);
                }

                if(comboboxMatiere.getSelectedItem().equals("Analyse de Fourier"))
                {
                    EnseignantAF = comboboxEnseignantAF.getSelectedItem().toString();
                    scolaC.CreerSeanceEnseignant(EnseignantAF, Semaine, Jour, heureD, heureF, etat, cours, type);
                }

                if(comboboxMatiere.getSelectedItem().equals("Electromagnetisme"))
                {
                    EnseignantEL = comboboxEnseignantEL.getSelectedItem().toString();
                    scolaC.CreerSeanceEnseignant(EnseignantEL, Semaine, Jour, heureD, heureF, etat, cours, type);
                }

                if(comboboxMatiere.getSelectedItem().equals("Mathematiques"))
                {
                    EnseignantMA = comboboxEnseignantMA.getSelectedItem().toString();
                    scolaC.CreerSeanceEnseignant(EnseignantMA, Semaine, Jour, heureD, heureF, etat, cours, type);
                }
                
                scolaC.CreerGroupe(groupe, promotion);
                
                if(comboboxSite.getSelectedItem().equals("  "))
                {
                    scolaC.CreerSalle(salleNull);
                }
                
                if(comboboxSite.getSelectedItem().equals("E1"))
                {
                    scolaC.CreerSalle(salleE1);
                }
                
                if(comboboxSite.getSelectedItem().equals("E2"))
                {
                    scolaC.CreerSalle(salleE2);
                }
                
                if(comboboxSite.getSelectedItem().equals("E4"))
                {
                    scolaC.CreerSalle(salleE4);
                }
                
                

            }
        }
    }

    public static void main( String[] args){new ScolaritéV();}

    
    
}
