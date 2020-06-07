/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;



import controleur.ScolaritéC;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import modele.ScolaritéM;
import modele.Seance;
import vue.*;

/**
 *
 * @author flori
 */
public class ModifierV extends JFrame implements ItemListener, ActionListener{
    
    JFrame Modifier = new JFrame("Modifier une séance");     
    JPanel panel2 = (JPanel) Modifier.getContentPane();
    
    
    protected String[] options = {"  ", "Ajouter une séance", "Annuler une séance"
            ,"Modifier une séance"
            , "Ajouter un enseignant à une séance",
            "Ajouter une groupe à une séance", 
            "Retirer un groupe d'une séance",
            "Retirer un enseignant d'une séance"};
    protected JComboBox<String> combobox = new JComboBox<String>(options);
       
    JLabel semaineL =  new JLabel("Semaine :");
    JLabel jourL =  new JLabel("Jour :");
    JLabel heuredL =  new JLabel("Heure de début :");
    JLabel heurefL =  new JLabel("Heure de fin :");
    JLabel etatL =  new JLabel("Etat :");
    JLabel matiereL =  new JLabel("Matière :");
    JLabel typeL =  new JLabel("Type :");
    JLabel groupeL =  new JLabel("-  Groupe :");
    JLabel promotionL =  new JLabel("Promotion");
    JLabel lieuL =  new JLabel("Lieu :");
    JLabel enseignantL =  new JLabel("Enseignant :");
    JLabel champs = new JLabel("Champs obligatoires");
    
    JLabel lb = new JLabel("Page Scolarité");
    JLabel lb2 = new JLabel("Que voulez-vous faire ?");
    
    JLabel TitreModifier = new JLabel("Modification d'une séance");
    
    protected String[] optionsSemaines =
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
    protected JComboBox<String> comboboxSemaines = new JComboBox<String>(optionsSemaines);
    
    protected String[] optionsJours =
            {" ", "Lundi","Mardi"
            , "Mercredi","Jeudi"
            , "Vendredi" , "Samedi"};
    protected JComboBox<String> comboboxJours = new JComboBox<String>(optionsJours);
    
    
    protected String[] optionsHeureD =
            {" ", "09h00","10h00"
            , "11h00","12h00"
            , "13h00" , "14h00","15h00"
            , "16h00", "17h00"};
    protected JComboBox<String> comboboxHeureD = new JComboBox<String>(optionsHeureD);
    
    protected String[] optionsHeureF =
            {" ", "11h00","12h00"
            , "13h00" , "14h00","15h00"
            , "16h00", "17h00","18h00",
            "19h00"};
    protected JComboBox<String> comboboxHeureF = new JComboBox<String>(optionsHeureF);
    
    protected String[] optionEtat =
            {"  ", "Annuler"};
    protected JComboBox<String> comboboxEtat = new JComboBox<String>(optionEtat);
    
    protected String[] optionMatiere = {"  ",};
    protected JComboBox<String> comboboxMatiere = new JComboBox<String>(optionMatiere);

    protected String[] optionEnseignantTH = {" ", "Thomas Guillemot", "Christine Crambes"};
    protected JComboBox<String> comboboxEnseignantTH = new JComboBox<String>(optionEnseignantTH);
    
    protected String[] optionEnseignantEL = {" ", "Thomas Guillemot", "Christine Crambes"};
    protected JComboBox<String> comboboxEnseignantEL = new JComboBox<String>(optionEnseignantEL);
    
    protected String[] optionEnseignantAF = {" ", "Fabienne Coudray"};
    protected JComboBox<String> comboboxEnseignantAF = new JComboBox<String>(optionEnseignantAF);
    
    protected String[] optionEnseignantMA = {" ", "Fabienne Coudray"};
    protected JComboBox<String> comboboxEnseignantMA = new JComboBox<String>(optionEnseignantMA);
    
    protected String[] optionEnseignantNull = {" "};
    protected JComboBox<String> comboboxEnseignantNull = new JComboBox<String>(optionEnseignantNull);
    
    protected String[] optionGroupeNull = {" "};
    protected JComboBox<String> comboboxGroupeNull = new JComboBox<String>(optionGroupeNull);
    
    protected String[] optionType = {" ", "Amphi", "TD", "TP", "DS", "Demi-Groupe"};
    protected JComboBox<String> comboboxType = new JComboBox<String>(optionType);
    
    protected String[] optionPromotion = {" ", "ING1", "ING2", "ING3"};
    protected JComboBox<String> comboboxPromotion = new JComboBox<String>(optionPromotion);
    
    protected String[] optionGroupe = {"  ", "TD01", "TD02"};
    protected JComboBox<String> comboboxGroupe = new JComboBox<String>(optionGroupe);
    
    protected String[] optionSite = {"  ", "E1", "E2", "E4"};
    protected JComboBox<String> comboboxSite = new JComboBox<String>(optionSite);
    
    protected String[] optionE1 = {"  ", "EM009", "SC210"};
    protected JComboBox<String> comboboxE1 = new JComboBox<String>(optionE1);
    
    protected String[] optionE2 = {"  ", "P445", "P417"};
    protected JComboBox<String> comboboxE2 = new JComboBox<String>(optionE2);
    
    protected String[] optionE4 = {"  ", "G002", "G006"};
    protected JComboBox<String> comboboxE4 = new JComboBox<String>(optionE4);
    
    protected String[] optionSiteNull = {"  "};
    protected JComboBox<String> comboboxSiteNull = new JComboBox<String>(optionSiteNull);
    
    protected JButton ModifierValide = new JButton("Enregistrer les modifications");
    
    protected String idArecuperer;
    
    //protected int id = Integer.parseInt(idArecuperer);
    
    protected int semaine;
    protected String Jour, HeureD, HeureF, Cours, Type, Enseignant, Groupe, Salle;
        
    protected boolean bool1, bool2, bool3, bool;
  
    
    public ModifierV()
    {
        ScolaritéM scolaM = new ScolaritéM();
        ScolaritéV scolaV = new ScolaritéV();

        scolaV.frame.setVisible(false);

        idArecuperer = scolaV.getidaenvoyer();        
                
        ArrayList<Seance> list = scolaM.getSeanceListWithID(idArecuperer);
        
        for (Seance elem : list)
        {
            semaine = elem.getSemaine();
            Jour  = elem.getJour();
            HeureD = elem.getHeureD();
            HeureF = elem.getHeureF();
            Cours = elem.getCours();
            Type = elem.getType();
            Enseignant = elem.NomEnseignant();
            Groupe = elem.getPromoEtGroupe();
            Salle = elem.getSiteEtSalle();
            
        }
        
        JLabel SemaineL = new JLabel();
        SemaineL.setText(String.valueOf(semaine));
        PlacementLabelCenterModif(SemaineL, 170);
        
        JLabel JourL = new JLabel(Jour);
        PlacementLabelCenterModif(JourL, 210); 
        
        JLabel HeureDL = new JLabel(HeureD);
        PlacementLabelCenterModif(HeureDL, 250);
        
        JLabel HeureFL = new JLabel(HeureF);
        PlacementLabelCenterModif(HeureFL, 290);
        
        JLabel CoursL = new JLabel(Cours);
        PlacementLabelCenterModif(CoursL, 330);
        
        JLabel TypeL = new JLabel(Type);
        PlacementLabelCenterModif(TypeL, 370);
        
        JLabel EnseignantL = new JLabel(Enseignant);
        PlacementLabelCenterModif(EnseignantL, 410);
        
        JLabel GroupeL = new JLabel(Groupe);
        PlacementLabelCenterModif(GroupeL, 450);
        
        JLabel SalleL = new JLabel(Salle);
        PlacementLabelCenterModif(SalleL, 490);
        
        
        
        ArrayList<String> Matière = scolaM.getMatiere();
        
        for (String m : Matière) 
        {
            comboboxMatiere.addItem(m);
        }
        
        comboboxMatiere.addItemListener(this);
        comboboxSite.addItemListener(this);
        comboboxPromotion.addItemListener(this);
        
        ModifierValide.addActionListener(this);
     
        Modifier.setSize(600,650);
        panel2.setLayout(null);

        TitreModifier.setFont(new Font("Arial",10 , 36));
        
        Modifier.setVisible(true);
        
        Color myRed = new Color(234, 96, 96);


        panel2.add(TitreModifier);
        PlacementLabelCenter2(TitreModifier, 65);

        semaineL.setForeground(myRed);
        Placement2(semaineL, 50, 170);
        panel2.add(comboboxSemaines);
        Dimension size1 = comboboxSemaines.getPreferredSize();
        comboboxSemaines.setBounds(420, 167, 150, 20);  

        jourL.setForeground(myRed);
        Placement2(jourL, 60, 210);
        panel2.add(comboboxJours);
        comboboxJours.setBounds(420,208, 150, 20);

        heuredL.setForeground(myRed);
        Placement2(heuredL, 35, 250);
        panel2.add(comboboxHeureD);
        comboboxHeureD.setBounds(420,248, 150, 20);

        heurefL.setForeground(myRed);
        Placement2(heurefL, 42, 290);
        panel2.add(comboboxHeureF);
        comboboxHeureF.setBounds(420,288, 150, 20);

        matiereL.setForeground(myRed);
        Placement2(matiereL, 53, 330);

        panel2.add(comboboxMatiere);
        comboboxMatiere.setBounds(420,328, 150, 20);

        Placement2(typeL, 58, 370);
        panel2.add(comboboxType);
        comboboxType.setBounds(420,368, 150, 20);

        Placement2(enseignantL, 44, 410);
        panel2.add(comboboxEnseignantNull);
        comboboxEnseignantNull.setBounds(420,408, 150, 20);

        Placement2(promotionL, 15, 450);
        promotionL.setForeground(myRed);
        panel2.add(comboboxPromotion);
        comboboxPromotion.setBounds(420,448, 70, 20);

        Placement2(groupeL, 80, 450);


        panel2.add(comboboxGroupeNull);
        comboboxGroupeNull.setBounds(500,448, 70, 20);

        Placement2(lieuL, 60, 490);
        panel2.add(comboboxSite);
        comboboxSite.setBounds(420,488, 70, 20);

        panel2.add(comboboxSiteNull);
        comboboxSiteNull.setBounds(500,488, 70, 20);

        champs.setForeground(myRed);
        panel2.add(champs);
        champs.setBounds(230, 540, 300, 20);

        panel2.validate();

        PlacementButton2(ModifierValide, 190, 110);
    }
    
    public void itemStateChanged(ItemEvent e) 
    {
        if(e.getSource() == comboboxMatiere 
                || e.getSource() == comboboxSite || e.getSource() == comboboxPromotion){
            
            DisplayCB(comboboxType);
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
            
            
            
            if(comboboxMatiere.getSelectedItem().equals("Thermodynamique"))
                {
                    DontDisplayCB(comboboxEnseignantNull);
                    DontDisplayCB(comboboxEnseignantEL);
                    DontDisplayCB(comboboxEnseignantAF);
                    DontDisplayCB(comboboxEnseignantMA);

                    panel2.add(comboboxEnseignantTH);
                    comboboxEnseignantTH.setBounds(420,408, 150, 20);
                }

                if(comboboxMatiere.getSelectedItem().equals("Electromagnetisme"))
                {
                    DontDisplayCB(comboboxEnseignantNull);
                    DontDisplayCB(comboboxEnseignantTH);
                    DontDisplayCB(comboboxEnseignantAF);
                    DontDisplayCB(comboboxEnseignantMA);


                    panel2.add(comboboxEnseignantEL);
                    comboboxEnseignantEL.setBounds(420,408, 150, 20);
                }

                if(comboboxMatiere.getSelectedItem().equals("Analyse de Fourier"))
                {
                    DontDisplayCB(comboboxEnseignantNull);
                    DontDisplayCB(comboboxEnseignantTH);
                    DontDisplayCB(comboboxEnseignantEL);
                    DontDisplayCB(comboboxEnseignantMA);

                    panel2.add(comboboxEnseignantAF);
                    comboboxEnseignantAF.setBounds(420,408, 150, 20);
                }

                if(comboboxMatiere.getSelectedItem().equals("Mathematiques"))
                {
                    DontDisplayCB(comboboxEnseignantNull);
                    DontDisplayCB(comboboxEnseignantTH);
                    DontDisplayCB(comboboxEnseignantEL);
                    DontDisplayCB(comboboxEnseignantAF);

                    panel2.add(comboboxEnseignantMA);
                    comboboxEnseignantMA.setBounds(420,408, 150, 20);
                }

                if(comboboxMatiere.getSelectedItem().equals("  "))
                {
                    DontDisplayCB(comboboxEnseignantTH);
                    DontDisplayCB(comboboxEnseignantEL);
                    DontDisplayCB(comboboxEnseignantAF);
                    DontDisplayCB(comboboxEnseignantMA);


                    DisplayCB(comboboxEnseignantNull);
                }
                
                if(comboboxPromotion.getSelectedItem().equals(" "))
                {
                    DisplayCB(comboboxGroupeNull);
                    DontDisplayCB(comboboxGroupe);
                }

                if(comboboxPromotion.getSelectedItem().equals("ING1") || comboboxPromotion.getSelectedItem().equals("ING2") 
                        || comboboxPromotion.getSelectedItem().equals("ING3"))
                {
                    DontDisplayCB(comboboxGroupeNull);
                    panel2.add(comboboxGroupe);
                    comboboxGroupe.setBounds(500,448, 70, 20);
                }
                
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

                    panel2.add(comboboxE1);
                    comboboxE1.setBounds(500,488, 70, 20);
                }

                if(comboboxSite.getSelectedItem().equals("E2"))
                {
                    DontDisplayCB(comboboxSiteNull);
                    DontDisplayCB(comboboxE1);
                    DontDisplayCB(comboboxE4);                    

                    panel2.add(comboboxE2);
                    comboboxE2.setBounds(500,488, 70, 20);
                }

                if(comboboxSite.getSelectedItem().equals("E4"))
                {
                    DontDisplayCB(comboboxSiteNull);
                    DontDisplayCB(comboboxE2);
                    DontDisplayCB(comboboxE1);                    

                    panel2.add(comboboxE4);
                    comboboxE4.setBounds(500,488, 70, 20);
                }
            
            
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String Semaine, EnseignantTH, EnseignantAF, EnseignantEL, EnseignantMA;
        int etat = 1;
        String Jour, heureD, heureF, cours, type, 
                groupe, promotion, salleE1, salleE2, 
                salleE4, salleNull;

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
        EnseignantTH = comboboxEnseignantTH.getSelectedItem().toString();
        EnseignantAF = comboboxEnseignantAF.getSelectedItem().toString();
        EnseignantMA = comboboxEnseignantMA.getSelectedItem().toString();
        EnseignantEL = comboboxEnseignantEL.getSelectedItem().toString();
        
        ScolaritéC scolaC = new ScolaritéC();
        ScolaritéM scolaM = new ScolaritéM();
        
        if((comboboxSemaines.getSelectedItem().equals(" "))||(comboboxJours.getSelectedItem().equals(" "))||
                    (comboboxHeureD.getSelectedItem().equals(" "))||(comboboxHeureF.getSelectedItem().equals(" "))
                    ||(comboboxMatiere.getSelectedItem().equals(" ")) ||(comboboxPromotion.getSelectedItem().equals(" ")))
        {
            JOptionPane.showMessageDialog(null, "Veuillez saisir toutes les informations obligatoires");
        }
        else
        {

                /////////////////////////////////////////////////////////////////
                            //VERIFICATION DE LA SEANCE VALIDE//
                ///////////////////////////////////////////////////////////////// 

         

            if(comboboxMatiere.getSelectedItem().equals("Thermodynamique"))
            {
                bool1 = scolaM.verifEnseignantModifier(idArecuperer, Semaine, Jour, heureD, heureF, EnseignantTH);
            }

            if(comboboxMatiere.getSelectedItem().equals("Analyse de Fourier"))
            {
                bool1 = scolaM.verifEnseignantModifier(idArecuperer, Semaine, Jour, heureD, heureF, EnseignantAF);
            }

            if(comboboxMatiere.getSelectedItem().equals("Mathematiques"))
            {
                bool1 = scolaM.verifEnseignantModifier(idArecuperer, Semaine, Jour, heureD, heureF, EnseignantMA);
            }

            if(comboboxMatiere.getSelectedItem().equals("Electromagnetisme"))
            {
                bool1 = scolaM.verifEnseignantModifier(idArecuperer, Semaine, Jour, heureD, heureF, EnseignantEL);
            }

             bool2 = scolaM.verifGroupeModifier(idArecuperer, Semaine, Jour, heureD, heureF, groupe, promotion);

            if(comboboxSite.getSelectedItem().equals("  "))
            {
                bool3 = true;
            }

            if(comboboxSite.getSelectedItem().equals("E1"))
            {
                bool3 = scolaM.verifSalleModifier(idArecuperer, Semaine, Jour, heureD, heureF, salleE1);
            }

            if(comboboxSite.getSelectedItem().equals("E2"))
            {
                bool3 = scolaM.verifSalleModifier(idArecuperer, Semaine, Jour, heureD, heureF, salleE2);
            }

            if(comboboxSite.getSelectedItem().equals("E4"))
            {
                bool3 = scolaM.verifSalleModifier(idArecuperer, Semaine, Jour, heureD, heureF, salleE4);
            }


            if(bool1 == false)
            {
                JOptionPane.showMessageDialog(null, "L'enseignant n'est pas disponible sur ce créneau");
            }

            if(bool2 == false)
            {
                JOptionPane.showMessageDialog(null, "Le groupe n'est pas disponible sur ce créneau");
            }

            if(bool3 == false)
            {
                JOptionPane.showMessageDialog(null, "La salle n'est pas disponible sur ce créneau");
            }

            bool = scolaM.verifHeure(heureD, heureF);

            if(bool == false)
            {
                JOptionPane.showMessageDialog(null, "Le format unique des cours est de 2h00");
            }

                /////////////////////////////////////////////////////////////////
                                //Modification de la seance//
                ///////////////////////////////////////////////////////////////// 
                
                
            if(bool != false && bool1 != false && bool2 != false && bool3 != false)
            {
                scolaC.ModifierSeance(idArecuperer, Semaine, Jour, heureD, heureF, cours, type);

                if(comboboxMatiere.getSelectedItem().equals("Thermodynamique"))
                {
                    scolaC.ModifierSeanceEnseignant(idArecuperer, EnseignantTH);
                }

                if(comboboxMatiere.getSelectedItem().equals("Analyse de Fourier"))
                {
                    scolaC.ModifierSeanceEnseignant(idArecuperer, EnseignantAF);
                }

                if(comboboxMatiere.getSelectedItem().equals("Electromagnetisme"))
                {
                    scolaC.ModifierSeanceEnseignant(idArecuperer, EnseignantEL);
                }

                if(comboboxMatiere.getSelectedItem().equals("Mathematiques"))
                {
                    scolaC.ModifierSeanceEnseignant(idArecuperer, EnseignantMA);
                }

                scolaC.ModifierSeanceGroupe(idArecuperer, groupe, promotion);

                if(comboboxSite.getSelectedItem().equals("  "))
                {
                    scolaC.ModifierSeanceSalle(idArecuperer, salleNull);
                }

                if(comboboxSite.getSelectedItem().equals("E1"))
                {
                    scolaC.ModifierSeanceSalle(idArecuperer, salleE1);
                }

                if(comboboxSite.getSelectedItem().equals("E2"))
                {
                    scolaC.ModifierSeanceSalle(idArecuperer, salleE2);
                }

                if(comboboxSite.getSelectedItem().equals("E4"))
                {
                    scolaC.ModifierSeanceSalle(idArecuperer, salleE4);
                }
                
                
                Modifier.setVisible(false);
                this.dispose();
                
            }
        }   
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
        button.setVisible(true);
    }
    
    public void DisplayT(JTable table)
    {
        table.setVisible(true);
    }
    
    public void DontDisplayT(JTable table)
    {
        table.setVisible(false);
    }
    
    public void DisplayS(JScrollPane scroll)
    {
        scroll.setVisible(true);
    }
    
    public void DontDisplayS(JScrollPane scroll)
    {
        scroll.setVisible(false);
    }
    
    
    public void Placement2(JLabel label, int w, int h)
    {
        panel2.add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(w, h, size.width, size.height);
    }
    
    
    public void PlacementButton2(JButton button, int w, int h)
    {
        panel2.add(button);
        Dimension size1 = button.getPreferredSize();
        button.setBounds(w, h, size1.width, size1.height);
        button.setVisible(true);
    }
    
    public void PlacementLabelCenter2(JLabel label, int h)
    {
        int w;
        panel2.add(label);
        Dimension size1 = label.getPreferredSize();
        w = 300-(size1.width/2);
        label.setBounds(w, h, size1.width, size1.height);   
    }
    
    
    public void PlacementLabelCenterModif(JLabel label, int h)
    {
        int w;
        panel2.add(label);
        Dimension size1 = label.getPreferredSize();
        w = 285-(size1.width/2);
        label.setBounds(w, h, size1.width, size1.height);   
    }
   
    
    public static void main(String[] args)
    {
        new ModifierV();
    }
    
}
