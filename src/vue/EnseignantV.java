package vue;
import controleur.EnseignantC;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import modele.EnseignantM;
import modele.Seance;


public class EnseignantV extends JPanel implements ActionListener{
    
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
    JFrame frame = new JFrame("Page Enseignant");
    JPanel panel = (JPanel) frame.getContentPane();

    
    
    JButton AfficherList = new JButton("Afficher en liste");
    
    protected String[] optionsSemaines =
            {"Toute", "01","02"
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
    
    
    protected String[] optionsEnseignant = {" ", };
    protected JComboBox<String> comboboxEnseignant = new JComboBox<String>(optionsEnseignant);
    
    
    
    
    JButton AfficherGrille = new JButton("Afficher en grille");
    
    JTable tableSeance = new JTable();
    JScrollPane jScrollPane1 = new JScrollPane();
    
    public static String nomAenvoyer;
    public static String SemaineAenvoyer;

    
    public EnseignantV()
    {
        
        
        vue.Grille grille = new vue.Grille();
        EnseignantM ensM = new EnseignantM();
        
        ArrayList<String> Enseignant = ensM.getEnseignant();
        
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        panel.add(grille);
        frame.setVisible(true);
        
        panel.setLayout(null);
        

        for (String m : Enseignant) 
        {
            comboboxEnseignant.addItem(m);
        }
        
        AfficherGrille.addActionListener(this);
        AfficherList.addActionListener(this);
        
        PlacementCombobox(comboboxSemaines, 30, 20);
        
        PlacementCombobox(comboboxEnseignant, 100, 20);
        
        PlacementButton(AfficherGrille, 270, 20);
        
        PlacementButton(AfficherList, 400, 20);  
    
        panel.validate();
             
    }
    
    public String getidaenvoyer()
    {
        return this.nomAenvoyer;
    }
    
    public String getSemaine()
    {
        return this.SemaineAenvoyer;
    }
    
    public void PlacementCombobox(JComboBox button, int w, int h)
    {
        panel.add(button);
        Dimension size1 = button.getPreferredSize();
        button.setBounds(w, h, size1.width, size1.height);   
    }
    
    public void PlacementButton(JButton button, int w, int h)
    {
        panel.add(button);
        Dimension size1 = button.getPreferredSize();
        button.setBounds(w, h, size1.width, size1.height);
        button.setVisible(true);
    }
    
    public void DisplayS(JScrollPane scroll)
    {
        scroll.setVisible(true);
    }
    
    public void DontDisplayS(JScrollPane scroll)
    {
        scroll.setVisible(false);
    }
    
    public void DisplayCB(JComboBox box)
    {
        box.setVisible(true);
    }
    
    public void DontDisplayCB(JComboBox box)
    {
        box.setVisible(false);
    }
    
    /**
     * Création des créneaux horaires de séances à l'aide de bouton codés en HTML
     * Utilisation de la classe Séance DAO pour récupérer et afficher les différentes informations
     * @param evt 
     */
    
    @Override
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource() == AfficherList || evt.getSource() == AfficherGrille)
        {
            
            

            if(evt.getSource() == AfficherList)
            {
                if(comboboxEnseignant.getSelectedItem().equals(" "))
                {
                    JOptionPane.showMessageDialog(null, "Veuillez selectionner un enseignant");
                }
                else
                {
                    nomAenvoyer = comboboxEnseignant.getSelectedItem().toString();
                    SemaineAenvoyer = comboboxSemaines.getSelectedItem().toString();
                    new ListeEnsV();
                }

            }

            if (evt.getSource() == AfficherGrille)
            {
                for (int i = 0; i<6; i++)
                {
                    JButton[] carre1 = new JButton[6];
                    carre1[i] = new JButton();
                    panel.add(carre1[i]);
                    carre1[i].setBounds((i*166)+101, 70, 166, 108);

                    carre1[i].setFocusPainted(false);
                    carre1[i].setEnabled(false);
                }

                for (int i = 0; i<6; i++)
                {
                    JButton[] carre1 = new JButton[6];
                    carre1[i] = new JButton();
                    panel.add(carre1[i]);
                    carre1[i].setBounds((i*166)+101, 178, 166, 108);

                    carre1[i].setFocusPainted(false);
                    carre1[i].setEnabled(false);
                }

                for (int i = 0; i<6; i++)
                {
                    JButton[] carre1 = new JButton[6];
                    carre1[i] = new JButton();
                    panel.add(carre1[i]);
                    carre1[i].setBounds((i*166)+101, 286, 166, 108);

                    carre1[i].setFocusPainted(false);
                    carre1[i].setEnabled(false);
                }

                for (int i = 0; i<6; i++)
                {
                    JButton[] carre1 = new JButton[6];
                    carre1[i] = new JButton();
                    panel.add(carre1[i]);
                    carre1[i].setBounds((i*166)+101, 394, 166, 108);

                    carre1[i].setFocusPainted(false);
                    carre1[i].setEnabled(false);
                }

                for (int i = 0; i<6; i++)
                {
                    JButton[] carre1 = new JButton[6];
                    carre1[i] = new JButton();
                    panel.add(carre1[i]);
                    carre1[i].setBounds((i*166)+101, 502, 166, 108);

                    carre1[i].setFocusPainted(false);
                    carre1[i].setEnabled(false);
                }
                
                String nomEns;
                String Semaine;
                nomEns = comboboxEnseignant.getSelectedItem().toString();
                Semaine = comboboxSemaines.getSelectedItem().toString();
                EnseignantM ensM = new EnseignantM();

                ArrayList<String> ListeSeances;

                int idEnseignant;
                int idGroupe;
                
                idEnseignant = ensM.idEnseignant(nomEns);

                idGroupe = ensM.getGroupe(idEnseignant);

                ListeSeances = ensM.getListSéance(idEnseignant, Semaine);
                ArrayList<Seance> list = ensM.recupererInfos(ListeSeances);

                for(Seance elem : list)
                {
                    JButton[] carre = new JButton[list.size()];
                    for (int i = 0; i<list.size(); i++)
                    {
                        carre[i] = new JButton("<HTML><BODY><CENTER>"+elem.getCours()+"<BR>"
                                + elem.getPromoEtGroupe() + "<BR>" + elem.getSiteEtSalle() 
                                +"</CENTER></BODY></HTML>");
                        panel.add(carre[i]);
                        if(elem.getEtat().equals("Séance Annulée"))
                        {
                            carre[i].setForeground(Color.red);
                        }

                        String Jour = elem.getJour();
                        String Heure = elem.getHeureD();

                        System.out.println(elem.getSemaine());
                        System.out.println(elem.getJour());
                        System.out.println(elem.getHeureD());
                        System.out.println(elem.getCours());
                        System.out.println(elem.NomEnseignant());
                        System.out.println(elem.getSiteEtSalle());

                        EnseignantC ensC = new EnseignantC();

                        carre[i].setBounds(ensC.CoordX(Jour),ensC.CoordY(Heure), 166, 108);
                    }
                }
            }
        }

    }
    
    public static void main(String[] args){new EnseignantV();}

    

   
    
}

    

