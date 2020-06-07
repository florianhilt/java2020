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

public class EnseignantM {
    
    
    protected String nomEnseignant;
    protected String prenomEnseignant;
    protected String IdentiteEnseignant;
    protected int idEnseignant;
    
    protected String nomEnseignant2;
    protected String prenomEnseignant2;
    
    protected ArrayList<String> ListEnseignant = new ArrayList<>();
    
    protected int id_groupe;
    
    public EnseignantM()
    {
        
    }
    
    public ArrayList getEnseignant()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlEtu = "select * from utilisateur where droit = 2 order by nom ASC";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                nomEnseignant = RS.getString("nom");
                prenomEnseignant = RS.getString("prenom");
                IdentiteEnseignant = prenomEnseignant + " " + nomEnseignant;
                ListEnseignant.add(IdentiteEnseignant);
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return ListEnseignant;
    }
    
    public int idEnseignant(String Enseignant)
    {
      
            String[] array = Enseignant.split(" ");

            prenomEnseignant2 = array[0];
            nomEnseignant2 = array[1];


            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "select * from utilisateur where nom =" + "'" + nomEnseignant2 + "'" + "AND prenom =" + "'" + prenomEnseignant2 + "'";
                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    idEnseignant = RS.getInt("id");
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        
        return idEnseignant;
    }
    
     public int getGroupe(int id)
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlType = "SELECT * FROM seance_groupes sg" +
                            " INNER JOIN seance_enseignants se ON sg.id_seance = se.id_seance where se.id_enseignant=" + id;
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
    
    public ArrayList getListSéance(int idEnseignant, String idSemaine)       
    {
        ArrayList<String> ListSeances = new ArrayList<>();
        
        if(idSemaine.equals("Toute"))
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "select * from seance_enseignants where id_enseignant =" + idEnseignant;
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
                        " INNER JOIN seance s ON sg.id_seance = s.id where sg.id_groupe=" + idEnseignant + " AND s.semaine =" + "'" + idSemaine + "'";
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
    
    
}
