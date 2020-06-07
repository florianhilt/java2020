/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vue;

import controleur.ScolaritéC;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import modele.ScolaritéM;
import modele.Seance;
import vue.*;

/**
 * Creation de l'interface graphique de la page scolarité
 * Utilisation d'itemListener et d'ActionListener
 * @author flori
 */

public class ScolaritéV extends JFrame implements ItemListener, ActionListener {
    
    
    JFrame frame = new JFrame();
    JPanel panel = (JPanel) frame.getContentPane();
    
    JFrame Modifier = new JFrame("Modifier une séance");     
    JPanel panel2 = (JPanel) Modifier.getContentPane();
    
    
    protected String[] options = {"  ", "Ajouter une séance", "Annuler une séance"
            ,"Modifier une séance"};
    protected JComboBox<String> combobox = new JComboBox<String>(options);
       
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
    
    JButton Valider = new JButton("Valider");
    
    protected boolean bool1, bool2, bool3, bool;
    
    
    /////////////////////////////////////////////////////////////////
                            //ANNULER SEANCE//
    /////////////////////////////////////////////////////////////////
    
    protected ArrayList<String> ListeMatiere = new ArrayList<>();
    protected ArrayList<String> ListeHeure = new ArrayList<>();
    JTable tableSeance = new JTable();
    JScrollPane jScollPane1 = new JScrollPane();
    
    protected String[] optionIDs = {"ID",};
    protected JComboBox<String> comboboxAllIDs = new JComboBox<String>(optionIDs); 
    
    protected JLabel AnnulerS = new JLabel("Indiquer la séance à annuler");
    protected JButton AnnulerB = new JButton("Annuler la séance"); 
    
    
    /////////////////////////////////////////////////////////////////
                         //MODIFIER UN COURS//
    /////////////////////////////////////////////////////////////////    
    
    
    protected JLabel ModifierL = new JLabel("Selectionnez l'ID de la séance à modifier");
    protected JButton ModifierB = new JButton("Modifier la séance"); 
    protected JButton ModifierValide = new JButton("Enregistrer les modifications");
    protected static String idAenvoyer;
    
    
    protected String[] optionIDsModifier = {"ID",};
    protected JComboBox<String> comboboxAllIDsModifier = new JComboBox<String>(optionIDsModifier); 
    
    protected JButton Actualiser = new JButton("Actualiser");
    
    /**
     * Le constructeur affiche la frame sur lequel nous ajoutons des elements du panel par la suite
     */
    
    public ScolaritéV(){
        
    String idenvoie = idAenvoyer;
    
    ScolaritéM scolaM = new ScolaritéM();
    ArrayList<String> Matière = scolaM.getMatiere();
    ArrayList<String> AllIDs = scolaM.getAllID();
    ArrayList<String> AllIDsModifier = scolaM.getAllIDModifier();
    
    for (String m : Matière) 
    {
        comboboxMatiere.addItem(m);
    }
    
    for (String m : AllIDs) 
    {
        comboboxAllIDs.addItem(m);
    }
    
    for (String m : AllIDsModifier) 
    {
        comboboxAllIDsModifier.addItem(m);
    }
    
    
    lb2.setFont(new Font("Arial",10 , 14));
    
    lb.setFont(new Font("Arial",10 , 26));
    
    PlacementLabelCenter(lb, 40);
    PlacementLabelCenter(lb2, 100);
    PlacementComboboxCenter(combobox,120);
    
    
    comboboxMatiere.addItemListener(this);
    comboboxSite.addItemListener(this);
    combobox.addItemListener(this);
    comboboxPromotion.addItemListener(this);
    
    
    Valider.addActionListener(this);
    AnnulerB.addActionListener(this);
    ModifierB.addActionListener(this);
    
    
    panel.setLayout(null);
    frame.setTitle("Page Scolarité");
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(600,200);
    frame.setVisible(true);
    
    }
    
    
    public String getidaenvoyer()
    {
        return this.idAenvoyer;
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
    
    
    public void Placement(JLabel label, int w, int h)
    {
        panel.add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(w, h, size.width, size.height);
    }
    
    
    public void Placement2(JLabel label, int w, int h)
    {
        panel2.add(label);
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
    
    public void PlacementButton2(JButton button, int w, int h)
    {
        panel2.add(button);
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
    
    public void PlacementLabelCenter2(JLabel label, int h)
    {
        int w;
        panel2.add(label);
        Dimension size1 = label.getPreferredSize();
        w = 300-(size1.width/2);
        label.setBounds(w, h, size1.width, size1.height);   
    }
    
    /**
     * Utlilisation d'itemListener
     * @param e 
     */
    
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
            DisplayL(typeL);
            DisplayL(enseignantL);
            DisplayL(champs);
            DisplayL(lb);
            DisplayL(lb2);
            DisplayL(ModifierL);

            
            DisplayB(Valider);
            DisplayB(ModifierB);
            DisplayB(Actualiser);
            
            DisplayCB(comboboxAllIDsModifier);
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
            DisplayS(jScollPane1);
            DisplayCB(comboboxAllIDs);
            DisplayL(AnnulerS);
            DisplayB(AnnulerB);
                  
              
            if(combobox.getSelectedItem().equals("  "))
            {
                DontDisplayS(jScollPane1);
                frame.setSize(600,200);
                PlacementComboboxCenter(combobox,120);
            }
                 
            if(combobox.getSelectedItem().equals("Ajouter une séance"))
            {
                DontDisplayB(Actualiser);
                DontDisplayL(ModifierL);
                DontDisplayB(ModifierB);
                DontDisplayCB(comboboxAllIDsModifier);
                DontDisplayL(AnnulerS);
                DontDisplayB(AnnulerB);
                DontDisplayS(jScollPane1);
                DontDisplayCB(comboboxAllIDs);
                PlacementComboboxCenter(combobox,120);
                frame.setSize(600,650);
                
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
                
                
                
                champs.setForeground(myRed);
                PlacementLabelCenter(champs, 570);
                panel.add(champs);

                panel.validate();
                
                PlacementButton(Valider, 465, 350);
                
            }
            
            if((combobox.getSelectedItem().equals("Annuler une séance")))
            {
                DontDisplayL(ModifierL);
                DontDisplayB(ModifierB);
                DontDisplayCB(comboboxAllIDsModifier);
                DontDisplayL(lb);
                DontDisplayL(lb2);
                frame.setSize(1200, 700);
                DontDisplayL(semaineL);
                DontDisplayL(jourL);
                DontDisplayL(heuredL);
                DontDisplayL(heurefL);
                DontDisplayL(etatL);
                DontDisplayL(matiereL);
                DontDisplayL(promotionL);
                DontDisplayL(groupeL);
                DontDisplayL(lieuL);
                DontDisplayL(enseignantL);
                DontDisplayL(typeL);
                
                DontDisplayB(Valider);
                DontDisplayB(Actualiser);
                
                DontDisplayL(champs);
                DontDisplayCB(comboboxType);
                DontDisplayCB(comboboxGroupeNull);
                DontDisplayCB(comboboxMatiere);
                DontDisplayCB(comboboxSiteNull);
                DontDisplayCB(comboboxSemaines);
                DontDisplayCB(comboboxJours);
                DontDisplayCB(comboboxHeureD);
                DontDisplayCB(comboboxHeureF);
                DontDisplayCB(comboboxEtat); 
                DontDisplayCB(comboboxPromotion); 
                DontDisplayCB(comboboxGroupe); 
                DontDisplayCB(comboboxSite);
                DontDisplayCB(comboboxEnseignantTH); 
                DontDisplayCB(comboboxEnseignantMA); 
                DontDisplayCB(comboboxEnseignantEL);
                DontDisplayCB(comboboxEnseignantAF);
                DontDisplayCB(comboboxEnseignantNull);
                DontDisplayCB(comboboxE1);
                DontDisplayCB(comboboxE2);
                DontDisplayCB(comboboxE4);
                
                
                panel.add(combobox);
                combobox.setBounds(10,10, 250, 20);
                
                tableSeance.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                   "Id", "Semaine", "Jour", "Heure Debut", "Heure Fin",
                    "Etat", "Cours", "Type", "Enseignant", "Groupe", "Salle"
                }
                ));
                
                jScollPane1.setViewportView(tableSeance);
                
                ScolaritéM scolaM = new ScolaritéM();
                DefaultTableCellRenderer custom = new DefaultTableCellRenderer();
                
                custom.setHorizontalAlignment(JLabel.CENTER);
                
                ArrayList<Seance> list = scolaM.getSeanceList();
                DefaultTableModel model = (DefaultTableModel) tableSeance.getModel();
                Object[] row = new Object[11];

                for(int i = 0; i<list.size(); i++)
                {
                    row[0] = list.get(i).getId();
                    row[1] = list.get(i).getSemaine();
                    row[2] = list.get(i).getJour();
                    row[3] = list.get(i).getHeureD();
                    row[4] = list.get(i).getHeureF();
                    row[5] = list.get(i).getEtat();
                    row[6] = list.get(i).getCours();
                    row[7] = list.get(i).getType();
                    row[8] = list.get(i).NomEnseignant();
                    row[9] = list.get(i).getPromoEtGroupe();
                    row[10] = list.get(i).getSiteEtSalle();

                    model.addRow(row);
                }
                
                for (int i=0 ; i < tableSeance.getColumnCount() ; i++) 
                {
                    tableSeance.getColumnModel().getColumn(i).setCellRenderer(custom);
                }
                
                panel.add(jScollPane1);
                jScollPane1.setBounds(100, 100, 1000, 300);        
                
                panel.add(AnnulerS);
                AnnulerS.setBounds(522, 470, 250, 20);
                
                panel.add(comboboxAllIDs);
                comboboxAllIDs.setBounds(550, 500, 100, 20);
                
                panel.add(AnnulerB);
                AnnulerB.setBounds(525, 540, 150, 20);
                
            }
            
            if((combobox.getSelectedItem().equals("Modifier une séance")))
            {
                
                frame.setSize(1200, 700);
                
                DontDisplayL(AnnulerS);
                DontDisplayL(lb);
                DontDisplayL(lb2);
                DontDisplayL(semaineL);
                DontDisplayL(jourL);
                DontDisplayL(heuredL);
                DontDisplayL(heurefL);
                DontDisplayL(etatL);
                DontDisplayL(matiereL);
                DontDisplayL(promotionL);
                DontDisplayL(groupeL);
                DontDisplayL(lieuL);
                DontDisplayL(enseignantL);
                DontDisplayL(typeL);
                DontDisplayL(champs);
                
                DontDisplayB(Valider);
                DontDisplayB(AnnulerB);
                
                
                DontDisplayCB(comboboxAllIDs);
                DontDisplayCB(comboboxType);
                DontDisplayCB(comboboxGroupeNull);
                DontDisplayCB(comboboxMatiere);
                DontDisplayCB(comboboxSiteNull);
                DontDisplayCB(comboboxSemaines);
                DontDisplayCB(comboboxJours);
                DontDisplayCB(comboboxHeureD);
                DontDisplayCB(comboboxHeureF);
                DontDisplayCB(comboboxEtat); 
                DontDisplayCB(comboboxPromotion); 
                DontDisplayCB(comboboxGroupe); 
                DontDisplayCB(comboboxSite);
                DontDisplayCB(comboboxEnseignantTH); 
                DontDisplayCB(comboboxEnseignantMA); 
                DontDisplayCB(comboboxEnseignantEL);
                DontDisplayCB(comboboxEnseignantAF);
                DontDisplayCB(comboboxEnseignantNull);
                DontDisplayCB(comboboxE1);
                DontDisplayCB(comboboxE2);
                DontDisplayCB(comboboxE4);
                
                panel.add(combobox);
                combobox.setBounds(10,10, 250, 20);
                
                tableSeance.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                   "Id", "Semaine", "Jour", "Heure Debut", "Heure Fin",
                    "Etat", "Cours", "Type", "Enseignant", "Groupe", "Salle"
                }
                ));
                
                jScollPane1.setViewportView(tableSeance);
                
                ScolaritéM scolaM = new ScolaritéM();
                DefaultTableCellRenderer custom = new DefaultTableCellRenderer();
                
                custom.setHorizontalAlignment(JLabel.CENTER);
                
                ArrayList<Seance> list = scolaM.getSeanceList();
                DefaultTableModel model = (DefaultTableModel) tableSeance.getModel();
                Object[] row = new Object[11];

                for(int i = 0; i<list.size(); i++)
                {
                    row[0] = list.get(i).getId();
                    row[1] = list.get(i).getSemaine();
                    row[2] = list.get(i).getJour();
                    row[3] = list.get(i).getHeureD();
                    row[4] = list.get(i).getHeureF();
                    row[5] = list.get(i).getEtat();
                    row[6] = list.get(i).getCours();
                    row[7] = list.get(i).getType();
                    row[8] = list.get(i).NomEnseignant();
                    row[9] = list.get(i).getPromoEtGroupe();
                    row[10] = list.get(i).getSiteEtSalle();

                    model.addRow(row);
                }
                
                for (int i=0 ; i < tableSeance.getColumnCount() ; i++) 
                {
                    tableSeance.getColumnModel().getColumn(i).setCellRenderer(custom); 
                }
                
                panel.add(jScollPane1);
                jScollPane1.setBounds(100, 100, 1000, 300);        
                
                
                
                panel.add(ModifierL);
                ModifierL.setBounds(485, 470, 250, 20);
                
                panel.add(comboboxAllIDsModifier);
                comboboxAllIDsModifier.setBounds(550, 500, 100, 20);
                
                panel.add(ModifierB);
                ModifierB.setBounds(525, 540, 150, 20);
                
                panel.add(Actualiser);
                Actualiser.setBounds(270, 10, 100, 20);
                
            }

      }
    }
    
    
    /**
     * Utilisation d'ActionListener
     * Appel des différents fonction du package Modele et Controleur
     * @param e 
     */
    
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
                
                    /////////////////////////////////////////////////////////////////
                                //VERIFICATION DE LA SEANCE VALIDE//
                    ///////////////////////////////////////////////////////////////// 
                
                
                
                if(comboboxMatiere.getSelectedItem().equals("Thermodynamique"))
                {
                    bool1 = scolaM.verifEnseignant(Semaine, Jour, heureD, heureF, EnseignantTH);
                }

                if(comboboxMatiere.getSelectedItem().equals("Analyse de Fourier"))
                {
                    bool1 = scolaM.verifEnseignant(Semaine, Jour, heureD, heureF, EnseignantAF);
                }

                if(comboboxMatiere.getSelectedItem().equals("Mathematiques"))
                {
                    bool1 = scolaM.verifEnseignant(Semaine, Jour, heureD, heureF, EnseignantMA);
                }

                if(comboboxMatiere.getSelectedItem().equals("Electromagnetisme"))
                {
                    bool1 = scolaM.verifEnseignant(Semaine, Jour, heureD, heureF, EnseignantEL);
                }

                 bool2 = scolaM.verifGroupe(Semaine, Jour, heureD, heureF, groupe, promotion);

                if(comboboxSite.getSelectedItem().equals("  "))
                {
                    bool3 = true;
                }

                if(comboboxSite.getSelectedItem().equals("E1"))
                {
                    bool3 = scolaM.verifSalle(Semaine, Jour, heureD, heureF, salleE1);
                }

                if(comboboxSite.getSelectedItem().equals("E2"))
                {
                    bool3 = scolaM.verifSalle(Semaine, Jour, heureD, heureF, salleE2);
                }

                if(comboboxSite.getSelectedItem().equals("E4"))
                {
                    bool3 = scolaM.verifSalle(Semaine, Jour, heureD, heureF, salleE4);
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
                                    //Creation de la seance//
                    ///////////////////////////////////////////////////////////////// 
                
                
                
                
                if(bool != false && bool1!= false && bool2 != false && bool3 != false)
                {
                    scolaC.CreerSeance(Semaine, Jour, heureD, heureF, etat, cours, type);

                    if(comboboxMatiere.getSelectedItem().equals("Thermodynamique"))
                    {
                        scolaC.CreerSeanceEnseignant(EnseignantTH, Semaine, Jour, heureD, heureF, etat, cours, type);
                    }

                    if(comboboxMatiere.getSelectedItem().equals("Analyse de Fourier"))
                    { 
                        scolaC.CreerSeanceEnseignant(EnseignantAF, Semaine, Jour, heureD, heureF, etat, cours, type);
                    }

                    if(comboboxMatiere.getSelectedItem().equals("Electromagnetisme"))
                    {    
                        scolaC.CreerSeanceEnseignant(EnseignantEL, Semaine, Jour, heureD, heureF, etat, cours, type);
                    }

                    if(comboboxMatiere.getSelectedItem().equals("Mathematiques"))
                    {
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
        
        if(combobox.getSelectedItem().equals("Annuler une séance"))
        {
            
            String id = comboboxAllIDs.getSelectedItem().toString();
            
            if(id.equals("ID"))
            {
                JOptionPane.showMessageDialog(null, "Veuilllez selectionner un ID de séance valide");
            }
            else
            {
                scolaC.AnnulerSéance(id);
                DefaultTableModel model = (DefaultTableModel)tableSeance.getModel();
                model.setRowCount(0);
                
                ArrayList<Seance> list = scolaM.getSeanceList();
                //DefaultTableModel model = (DefaultTableModel) tableSeance.getModel();
                Object[] row = new Object[11];

                for(int i = 0; i<list.size(); i++)
                {
                    row[0] = list.get(i).getId();
                    row[1] = list.get(i).getSemaine();
                    row[2] = list.get(i).getJour();
                    row[3] = list.get(i).getHeureD();
                    row[4] = list.get(i).getHeureF();
                    row[5] = list.get(i).getEtat();
                    row[6] = list.get(i).getCours();
                    row[7] = list.get(i).getType();
                    row[8] = list.get(i).NomEnseignant();
                    row[9] = list.get(i).getPromoEtGroupe();
                    row[10] = list.get(i).getSiteEtSalle();

                    model.addRow(row);
                }
            }
        }
        
        if(combobox.getSelectedItem().equals("Modifier une séance"))
        {      
            if(comboboxAllIDsModifier.getSelectedItem().equals("ID"))
            {
                JOptionPane.showMessageDialog(null, "Veuilllez selectionner un ID de séance valide");
            }
            else
            {
                
                idAenvoyer = comboboxAllIDsModifier.getSelectedItem().toString();
                System.out.println(idAenvoyer);
                
                ModifierV modif = new ModifierV();
                
                
   
            }
        }
        
        /**
         * ActionListener qui sert à l'actualisation de la page
         * 
         */
        
        Actualiser.addActionListener(new ActionListener() {

        @Override
            public void actionPerformed(ActionEvent event) {

                    DefaultTableModel model = (DefaultTableModel)tableSeance.getModel();
                    model.setRowCount(0);

                    ArrayList<Seance> list = scolaM.getSeanceList();
                    //DefaultTableModel model = (DefaultTableModel) tableSeance.getModel();
                    Object[] row = new Object[11];

                    for(int i = 0; i<list.size(); i++)
                    {
                        row[0] = list.get(i).getId();
                        row[1] = list.get(i).getSemaine();
                        row[2] = list.get(i).getJour();
                        row[3] = list.get(i).getHeureD();
                        row[4] = list.get(i).getHeureF();
                        row[5] = list.get(i).getEtat();
                        row[6] = list.get(i).getCours();
                        row[7] = list.get(i).getType();
                        row[8] = list.get(i).NomEnseignant();
                        row[9] = list.get(i).getPromoEtGroupe();
                        row[10] = list.get(i).getSiteEtSalle();

                        model.addRow(row);
                    }
                
            }
        });
    }
    
    public static void main( String[] args){new ScolaritéV();}
 
}
