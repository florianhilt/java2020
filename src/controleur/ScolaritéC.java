package controleur;

import java.sql.*;
import java.util.ArrayList;

/**
 * Package controle 
 * Ce package établit la connexion entre l'interface graphique et la BDD
 * Il insert des données rentrées dans l'interface graphique et les insert dans la BDD
 * @author flori
 */

public class ScolaritéC {
    
    
    protected int id_type;
    protected int id_cours;
    protected int id_enseignant;
    protected int id_seance;
    protected String nomEnseignant;
    protected String prenomEnseignant;
    protected int id_groupe;
    protected int id_promotion;
    protected int id_site;
    protected int id_salle;
    
    public ScolaritéC()
    {
        
    }
    
    public int idCours(String matiere)
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlType = "select * from cours where nom =" + "'" + matiere + "'";
            PreparedStatement pst = con.prepareStatement(SqlType);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                id_cours = RS.getInt("id");
            }
           
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return id_cours;  
    }       
    
    public int idType(String Type_cours)
    {
        
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlType = "select * from type_cours where nom =" + "'" + Type_cours + "'";
            PreparedStatement pst = con.prepareStatement(SqlType);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                id_type = RS.getInt("id");
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return id_type;
    }
    
    public int idEnseignant(String Enseignant)
    {
        if (" ".equals(Enseignant))
        {
            id_enseignant = 0;
        }
        else
        {

            String[] array = Enseignant.split(" ");

            prenomEnseignant = array[0];
            nomEnseignant = array[1];


            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "select * from utilisateur where nom =" + "'" + nomEnseignant + "'" + "AND prenom =" + "'" + prenomEnseignant + "'" + " AND droit = 2";
                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    id_enseignant = RS.getInt("id");
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        return id_enseignant;  
        
        
    }
    
    
    public int idSeance()
    {       
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");            
            
            String SqlType = "select max(id) as id_se from seance";
            
            PreparedStatement pst = con.prepareStatement(SqlType);
            
            ResultSet RS = pst.executeQuery();
            
            if (RS.next())
            {
                id_seance = RS.getInt("id_se");
            }
           
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return id_seance; 
       
    }
    
    
    public int idPromotion(String Promotion)
    {       
        
        if (Promotion.equals(" "))
        {
            id_promotion = 0;
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");            

                String SqlType = "select * from promotion where nom =" + "'" + Promotion + "'";

                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    id_promotion = RS.getInt("id");
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        return id_promotion; 
       
    }
    
    
    public int idGroupe(String Groupe, String Promotion)
    {       
        if(Groupe.equals(" "))
        {
            id_groupe = 0;
        }
        else
        {
            ScolaritéC scolaC = new ScolaritéC();

            int id_promotionBDD = scolaC.idPromotion(Promotion);

            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");            

                String SqlType = "select * from groupe where nom =" + "'" + Groupe + "'AND id_promotion =" + id_promotionBDD;

                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    id_groupe = RS.getInt("id");
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }  
        return id_groupe; 
       
    }
    
    public int idSalle(String Salle)
    {       
        if (" ".equals(Salle))
        {
            id_salle = 0;
        }
        else
        {
       
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");            

                String SqlType = "select * from salle where nom =" + "'" + Salle + "'";

                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    id_salle = RS.getInt("id");
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
              
        return id_salle; 
       
    }
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////
    
        
    public void CreerSeance(String Semaine, String Jour, String heureD, String heureF, int etat, String cours, String type)
    {
        ScolaritéC scolaC = new ScolaritéC();
        
        int id_coursBDD = scolaC.idCours(cours);
        int id_typeBDD = scolaC.idType(type);
        
        if(Semaine == " ")
        {
            Semaine = "0";
        }
   
        if(cours == " ")
        {
            id_coursBDD = 0;
        }
        
        if(type == " ")
        {
            id_typeBDD = 0;
        }
        
        
        
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            Statement statement = con.createStatement();            
           
            String SQL = "INSERT INTO `seance`(`semaine`, `jour`, `heure_debut`, `heure_fin`, `etat`, `id_cours`, `id_type`) VALUES (" +  Semaine + "," 
                    + "'" + Jour + "'," + "'" + heureD + "'," + "'" + heureF + "'," +  etat + "," + id_coursBDD + "," + id_typeBDD + ")";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.executeUpdate();
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
       
    }
    
    public void CreerSeanceEnseignant(String Enseignant, String Semaine, String Jour, String heureD, String heureF, int etat, String cours, String type)
    {
        ScolaritéC scolaC = new ScolaritéC();
        
        int id_enseignant = scolaC.idEnseignant(Enseignant);
        int id_seance = scolaC.idSeance();
        
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
                       
           
            String SQL = "INSERT INTO `seance_enseignants`(`id_seance`, `id_enseignant`) VALUES (" + id_seance + "," 
                     + id_enseignant + ")";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.executeUpdate();
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
       
    }
    
    public void CreerGroupe(String Groupe, String Promotion)
    {
        ScolaritéC scolaC = new ScolaritéC();
        
        int id_groupe = scolaC.idGroupe(Groupe, Promotion);
        int id_seance = scolaC.idSeance();
        
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
                       
           
            String SQL = "INSERT INTO `seance_groupes`(`id_seance`, `id_groupe`) VALUES (" + id_seance + "," 
                     + id_groupe + ")";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.executeUpdate();
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
       
    }
    
    public void CreerSalle(String Salle)
    {
        ScolaritéC scolaC = new ScolaritéC();
        
        int id_seance = scolaC.idSeance();
        int id_salle = scolaC.idSalle(Salle);
        
        
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
                       
           
            String SQL = "INSERT INTO `seance_salles`(`id_seance`, `id_salle`) VALUES (" + id_seance + "," 
                     + id_salle + ")";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.executeUpdate();
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
       
    }
    
    
    public void AnnulerSéance(String id)
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
                       
           
            String SQL = "UPDATE seance SET etat = 0 where id="+ "'" + id + "'";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.executeUpdate();
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
    
    public void ModifierSeance(String id, String Semaine, String Jour, String HeureD, String HeureF, String Cours, String Type)
    {
        ScolaritéC scolaC = new ScolaritéC();
        int id_coursBDD = scolaC.idCours(Cours);
        int id_typeBDD = scolaC.idType(Type);
   
        if(Type == " ")
        {
            id_typeBDD = 0;
        }
      
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");               

            String SQL = "UPDATE seance SET semaine=" + "'" + Semaine + "'," 
                    + "jour =" + "'" + Jour + "'," + "heure_debut=" + "'" 
                    + HeureD + "'," + "heure_fin=" + "'" + HeureF + "'," 
                    + "id_cours=" + id_coursBDD + ","+ "id_type =" 
                    + id_typeBDD + " where id=" + "'" + id + "'";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.executeUpdate();

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
    }
    
    public void ModifierSeanceEnseignant(String id, String Enseignant)
    {
        ScolaritéC scolaC = new ScolaritéC();
        
        
        
        int id_enseignantBDD = scolaC.idEnseignant(Enseignant);
        
        if(Enseignant.equals(" "))
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");


                String SQL = "UPDATE seance_enseignants SET id_enseignant=" + 0 + " where id_seance=" + "'" + id + "'";

                PreparedStatement pst = con.prepareStatement(SQL);

                pst.executeUpdate();

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


                String SQL = "UPDATE seance_enseignants SET id_enseignant=" + id_enseignantBDD+ " where id_seance=" + "'" + id + "'";

                PreparedStatement pst = con.prepareStatement(SQL);

                pst.executeUpdate();

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
    }
    
    public void ModifierSeanceGroupe(String id, String Groupe, String Promotion)
    {
        ScolaritéC scolaC = new ScolaritéC();
        
        int id_groupeBDD = scolaC.idGroupe(Groupe, Promotion);
        

        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");


            String SQL = "UPDATE seance_groupes SET id_groupe=" + id_groupeBDD + " where id_seance=" + "'" + id + "'";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.executeUpdate();

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }

    }
    
    public void ModifierSeanceSalle(String id, String Salle)
    {
        ScolaritéC scolaC = new ScolaritéC();
        
        int id_salleBDD = scolaC.idSalle(Salle);
        

        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");


            String SQL = "UPDATE seance_salles SET id_salle=" + id_salleBDD + " where id_seance=" + "'" + id + "'";

            PreparedStatement pst = con.prepareStatement(SQL);

            pst.executeUpdate();

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }

    }


            
      
}

