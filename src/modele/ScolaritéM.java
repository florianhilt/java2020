package modele;

import controleur.ScolaritéC;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class ScolaritéM {
    
    protected ArrayList<String> Matière = new ArrayList<>();
    protected ArrayList<String> Enseignant = new ArrayList<>();
    protected ArrayList<String> CoursEnseignant = new ArrayList<>();
    protected ArrayList<Integer> id_SeanceEnseignant = new ArrayList();
    protected ArrayList<Integer> ListeSemaine = new ArrayList();
    protected ArrayList<String> ListeJour = new ArrayList();
    protected ArrayList<String> ListeHeureD = new ArrayList();
    protected ArrayList<String> ListeHeureF = new ArrayList();

    public ScolaritéM()
    {
        
    }
    
    public ArrayList getMatiere()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlEtu = "select * from cours";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                Matière.add(RS.getString("nom"));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return Matière;
    }
    
    public ArrayList getEnseignant()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlEtu = "select * from utilisateur where droit = 2";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                Enseignant.add(RS.getString("id"));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return Enseignant;
    }
    
    public ArrayList getCoursEnseignant(String Enseignant)
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlEtu = "select * from utilisateur where droit = 2";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                CoursEnseignant.add(RS.getString("nom"));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return CoursEnseignant;
    }
    
    public int splitHeureD(String HeureD)
    {
        String[] array = HeureD.split("h");

        String HeureD1 = array[0];
        String HeureD2 = array[1];
        
        int HD = Integer.parseInt(HeureD1);
        
        return HD;
    }
    
     public int splitHeureF(String HeureF)
    {
        String[] array = HeureF.split("h");

        String HeureF1 = array[0];
        String HeureF2 = array[1];
        
        int HF = Integer.parseInt(HeureF1);
        
        return HF;
    }
     
    
    public boolean verifEnseignant(String Semaine, String Jour, String HeureD, String HeureF, String Enseignant)
    {
        int SemaineInc = 0, JourInc = 0, HeureDInc = 0, HeureFInc = 0;
        int HD1, HF1;
        
        ScolaritéM scolaM = new ScolaritéM();
        
        HD1 = scolaM.splitHeureD(HeureD);
        HF1 = scolaM.splitHeureF(HeureF);
        
        int SemaineComp = Integer.parseInt(Semaine);
        boolean bool = true;
        
        ScolaritéC scolaC = new ScolaritéC();
        int id_enseignant = scolaC.idEnseignant(Enseignant);
        
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlEtu = "select * from seance_enseignants where id_enseignant=" + id_enseignant;
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                id_SeanceEnseignant.add(RS.getInt("id_seance"));
            }
            
            for(int elem : id_SeanceEnseignant)
            {
                String SqlEtu2 = "select semaine from seance where id=" + elem;
                PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                ResultSet RS2 = pst2.executeQuery();
                
                while(RS2.next())
                {
                    ListeSemaine.add(RS2.getInt("semaine"));
                }
            }
            
            
            for(int elem : id_SeanceEnseignant)
            {
                String SqlEtu2 = "select jour from seance where id=" + elem;
                PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                ResultSet RS2 = pst2.executeQuery();
                
                while(RS2.next())
                {
                    ListeJour.add(RS2.getString("jour"));
                }
            }
            
            
            for(int elem : id_SeanceEnseignant)
            {
                String SqlEtu2 = "select heure_debut from seance where id=" + elem;
                PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                ResultSet RS2 = pst2.executeQuery();
                
                while(RS2.next())
                {
                    ListeHeureD.add(RS2.getString("heure_debut"));
                }
            }
            
            
            for(int elem : id_SeanceEnseignant)
            {
                String SqlEtu2 = "select heure_fin from seance where id=" + elem;
                PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                ResultSet RS2 = pst2.executeQuery();
                
                while(RS2.next())
                {
                    ListeHeureF.add(RS2.getString("heure_fin"));
                }
            }
            
            
            for(int elem : ListeSemaine)
            {
                if(SemaineComp == elem)
                {
                    SemaineInc = 1;
                }
            }
            
            for(String elem : ListeJour)
            {
                if(Jour.equals(elem))
                {
                    JourInc = 1;
                }
            }
            
            for(String elem : ListeHeureD)
            {
                int HD2;
                HD2 = scolaM.splitHeureD(elem);
                
                if(HeureD.equals(elem) || HD1==HD2-1 || HD1==HD2+1)
                {
                    HeureDInc = 1;
                }
            }
            
            for(String elem : ListeHeureF)
            {
                int HF2;
                HF2 = scolaM.splitHeureD(elem);
                
                if(HeureF.equals(elem) || HF1==HF2-1 || HF1==HF2+1)
                {
                    HeureFInc = 1;
                }
            }
            
            int Total = SemaineInc + JourInc + HeureDInc + HeureFInc;

            if(Total == 4)
            {
                bool = false;
                System.out.println("Total = " + Total);
            }
            
            else
            {
                bool = true;
                System.out.println("Total = " + Total);
            }
 
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        
        
        
        return bool;
    }
    
    public static void main(String[] args)
    {
        ScolaritéM scolaM = new ScolaritéM();
        String Semaine = "3", Jour="Lundi", HeureD="13h00", HeureF="15h00", Enseignant="Thomas Guillemot";
        
        boolean bool = scolaM.verifEnseignant(Semaine, Jour, HeureD, HeureF, Enseignant);

        System.out.println(bool);
    }
}


    