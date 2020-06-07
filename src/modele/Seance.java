/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Recuperation des données de la BDD et création d'un objet associer
 * Seance DAO
 * @author flori
 */
public class Seance {
    
    private int id;
    private int semaine;
    private String jour;
    private String heured;
    private String heuref;
    
    private int etat;
    private String nomEtat;
    
    
    private int idcours;
    private String nomCours;
    
    
    private int idtype;
    private String nomType;
    
    
    private int idenseignant;
    private String IdentiteEnseignant; 
    private String nomEnseignant;
    private String prenomEnseignant;
    
    private int idgroupe;
    private String Promotion;
    private String nomGroupe;
    private String PromoEtGroupe;
    
    
    private int idsalle;
    private String Site;
    private String Salle;
    private String SiteEtSalle;
    
    
    
    
    public Seance(int ID, int Semaine, String Jour, String HeureD, String HeureF, int Etat, int IDCours, int IDType, int IDEnseignant, int IDGroupe, int IDSalle)
    {
        this.id = ID;
        this.semaine = Semaine;
        this.jour = Jour;
        this.heured = HeureD;
        this.heuref = HeureF;
        this.etat = Etat;
        this.idcours = IDCours;
        this.idtype = IDType;
        this.idenseignant = IDEnseignant;
        this.idgroupe = IDGroupe;
        this.idsalle = IDSalle;
    }
    
    public int getId()
    {
        return id;
    }
    
    public int getSemaine()
    {
        return semaine;
    }
    
    public String getJour()
    {
        return jour;
    }
    
    public String getHeureD()
    {
        return heured;
    }
    
    public String getHeureF()
    {
        return heuref;
    }
    
    public String getEtat()
    {
        if(etat == 1)
        {
            nomEtat = "Séance Validée";
        }
        
        if(etat == 0)
        {
            nomEtat = "Séance Annulée";
        }
        return nomEtat;
    }
    
    public String getCours()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

            String SqlType = "select * from cours where id =" + idcours;
            PreparedStatement pst = con.prepareStatement(SqlType);

            ResultSet RS = pst.executeQuery();

            while (RS.next())
            {
                nomCours = RS.getString("nom");
            }

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return nomCours;
    }
    
    public String getType()
    {
        if (idtype == 0)
        {
             nomType = "Non défini";
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "select * from type_cours where id =" + idtype;
                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    nomType = RS.getString("nom");
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        return nomType;
    }
    
    public String NomEnseignant()
    {
        if (idenseignant == 0)
        {
             IdentiteEnseignant = "Non défini";
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "select * from utilisateur where id =" + idenseignant;
                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    nomEnseignant = RS.getString("nom");
                    prenomEnseignant = RS.getString("prenom");
                    IdentiteEnseignant = prenomEnseignant + " " + nomEnseignant;
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        return IdentiteEnseignant;
    }
    
    public String getPromoEtGroupe()
    {
        if (idgroupe == 0)
        {
             PromoEtGroupe = "Non défini";
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "select * from groupe where id =" + idgroupe;
                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    Promotion = RS.getString("id_promotion");
                    nomGroupe = RS.getString("nom");
                    PromoEtGroupe = "ING" + Promotion + " - " + nomGroupe;
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        return PromoEtGroupe;
    }
    
    public String getSiteEtSalle()
    {
        if (idsalle == 0)
        {
             SiteEtSalle = "Non défini";
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlType = "SELECT s.id, s.nom, st.nom from salle s INNER JOIN site st ON s.id_site = st.id where s.id ="+idsalle;
                PreparedStatement pst = con.prepareStatement(SqlType);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    Site = RS.getString("st.nom");
                    Salle = RS.getString("s.nom");
                    SiteEtSalle = Site + " - " + Salle;
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        return SiteEtSalle;
    }
    
    
}
