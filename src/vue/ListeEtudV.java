package vue;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import modele.*;

/**
 * affichage en liste des séances
 * Récupération des données d'une fenetre à l'autre grave aux variables static
 * @author flori
 */

public class ListeEtudV {
    
    JTable tableSeance = new JTable();
    JScrollPane jScrollPane1 = new JScrollPane();
    
    private static final int WIDTH = 1014;
    private static final int HEIGHT = 300;
    JFrame frame = new JFrame("Page Etudiant");
    JPanel panel = (JPanel) frame.getContentPane();
    
    protected String Etudiant;
    protected String idSemaine;
    
    public ListeEtudV()
    {
        
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
       
        frame.setVisible(true);
        
        panel.setLayout(null);
        
        
        EtudiantV EtudV = new EtudiantV();
        EtudV.frame.setVisible(false);

        Etudiant = EtudV.getidaenvoyer();
        idSemaine = EtudV.getSemaine();
        
        EtudiantM EtudM = new EtudiantM();

        ArrayList<String> ListeSeances;

        int idEtudiant;
        int idGroupe;

        idEtudiant = EtudM.idEtudiant(Etudiant);

        idGroupe = EtudM.getGroupe(idEtudiant);


        ListeSeances = EtudM.getListSéance(idGroupe, idSemaine);

        tableSeance.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
           "Id", "Semaine", "Jour", "Heure Debut", "Heure Fin",
            "Etat", "Cours", "Type", "Enseignant", "Groupe", "Salle"
        }
        ));

        jScrollPane1.setViewportView(tableSeance);

        DefaultTableCellRenderer custom = new DefaultTableCellRenderer();

        custom.setHorizontalAlignment(JLabel.CENTER);

        ArrayList<Seance> list = EtudM.recupererInfos(ListeSeances);
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

        panel.add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 1000, 300);
        
        
        
    }
    
    public static void main(String[] args){new ListeEtudV();}
}
