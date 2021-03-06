/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.*;
import java.util.*;

/**
 * Package Modele
 * Ce package établi la connexion entre l'interface graphique et les tables de la BDD
 * @author flori
 */

public class EtudiantM {
    
    protected String nomEtudiant;
    protected String prenomEtudiant;
    protected String IdentiteEtudiant;
    protected int idEtudiant;
    
    protected String nomEtudiant2;
    protected String prenomEtudiant2;
    
    
    protected ArrayList<String> ListEtudiant = new ArrayList<>();
    
    
    protected int id_groupe;

    public EtudiantM()
    {
        
    }
    
    public ArrayList getEtudiant()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlEtu = "select * from utilisateur where droit = 1 order by nom ASC";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                nomEtudiant = RS.getString("nom");
                prenomEtudiant = RS.getString("prenom");
                IdentiteEtudiant = prenomEtudiant + " " + nomEtudiant;
                ListEtudiant.add(IdentiteEtudiant);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return ListEtudiant;
    }
    
    
    public int getGroupe(int id)
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlType = "select * from etudiant where id_utilisateur =" + id;
            PreparedStatement pst = con.prepareStatement(SqlType);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                id_groupe = RS.getInt("id_groupe");
            }
           
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return id_groupe;
    }
    
    
   
    public ArrayList getListSéance(int id_Groupe, String idSemaine)       
    {
        ArrayList<String> ListSeances = new ArrayList<>();
        
        if(idSemaine.equals("Toute"))
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "select * from seance_groupes where id_groupe =" + id_Groupe;
                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    ListSeances.add(RS.getString("id_seance"));
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
            
            
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "SELECT * from seance_groupes sg" +
                        " INNER JOIN seance s ON sg.id_seance = s.id where sg.id_groupe=" + id_Groupe + " AND s.semaine =" + "'" + idSemaine + "'";
                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    ListSeances.add(RS.getString("id_seance"));
                }
            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
            
        }
        return ListSeances;
    }
    
    public ArrayList<Seance> recupererInfos(ArrayList<String> idSéance)
    {
        
        ArrayList<Seance> SeanceList = new ArrayList<Seance>();
        
        for(String elem : idSéance)
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String query = "SELECT *, id_enseignant, id_groupe from seance s "
                    + "INNER JOIN seance_enseignants se ON s.id = se.id_seance "
                    + "INNER JOIN seance_groupes sg ON se.id_seance = sg.id_seance "
                    + "INNER JOIN seance_salles ss ON sg.id_seance = ss.id_seance where s.id="+ "'" + elem + "' order by s.semaine ASC";
                
                Statement st;
                ResultSet rs;

                st = con.createStatement();
                rs = st.executeQuery(query);

                Seance seance;

                while(rs.next())
                {
                     seance = new Seance(rs.getInt("id"),rs.getInt("semaine"),rs.getString("jour"),rs.getString("s.heure_debut"),
                             rs.getString("heure_fin"),rs.getInt("etat"),rs.getInt("id_cours"), rs.getInt("id_type"),
                             rs.getInt("id_enseignant"),rs.getInt("id_groupe"),rs.getInt("id_salle"));
                     SeanceList.add(seance);
                }

            }
            
            catch(Exception exception)
            {
                exception.printStackTrace();
            }

        }
    
        return SeanceList;
    }
    
    public int idEtudiant(String Etudiant)
    {
      
            String[] array = Etudiant.split(" ");

            prenomEtudiant2 = array[0];
            nomEtudiant2 = array[1];


            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "select * from utilisateur where nom =" + "'" + nomEtudiant2 + "'" + "AND prenom =" + "'" + prenomEtudiant2 + "'";
                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    idEtudiant = RS.getInt("id");
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        
        return idEtudiant;
    }
}