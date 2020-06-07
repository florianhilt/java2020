package modele;

import controleur.ScolaritéC;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Package Modele
 * Ce package établi la connexion entre l'interface graphique et les tables de la BDD
 * @author flori
 */

public class ScolaritéM {
    
    protected ArrayList<String> Matière = new ArrayList<>();
    protected ArrayList<String> Enseignant = new ArrayList<>();
    protected ArrayList<String> CoursEnseignant = new ArrayList<>();
    
    
    protected ArrayList<Integer> id_SeanceEnseignant = new ArrayList();
    protected ArrayList<Integer> ListeSemaineE = new ArrayList();
    protected ArrayList<String> ListeJourE = new ArrayList();
    protected ArrayList<String> ListeHeureDE = new ArrayList();
    protected ArrayList<String> ListeHeureFE = new ArrayList();
    
    protected ArrayList<Integer> id_SeanceGroupe = new ArrayList();
    protected ArrayList<Integer> ListeSemaineG = new ArrayList();
    protected ArrayList<String> ListeJourG = new ArrayList();
    protected ArrayList<String> ListeHeureDG = new ArrayList();
    protected ArrayList<String> ListeHeureFG = new ArrayList();
    
    protected ArrayList<Integer> id_SeanceSalle = new ArrayList();
    protected ArrayList<Integer> ListeSemaineS = new ArrayList();
    protected ArrayList<String> ListeJourS = new ArrayList();
    protected ArrayList<String> ListeHeureDS = new ArrayList();
    protected ArrayList<String> ListeHeureFS = new ArrayList();
    
    protected ArrayList<String> AllSeance = new ArrayList();
    
    protected ArrayList<String> AllSeanceModifier = new ArrayList();
    
    
    

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
    
    public ArrayList getAllID()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlEtu = "select * from seance where etat=1";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                AllSeance.add(RS.getString("id"));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return AllSeance;
    }
    
    public ArrayList getAllIDModifier()
    {
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");
            
            String SqlEtu = "select * from seance";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            ResultSet RS = pst.executeQuery();
            
            while (RS.next())
            {
                AllSeanceModifier.add(RS.getString("id"));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return AllSeanceModifier;
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
     
     public boolean verifHeure(String HeureD, String HeureF)
    {
        boolean bool = true;
        
        ScolaritéM scolaM = new ScolaritéM();
        
        int HD = scolaM.splitHeureD(HeureD);
        int HF = scolaM.splitHeureF(HeureF);
        
        if(HF != HD +2)
        {
            bool = false;
        }
        
        return bool;
    }
     
     
     
     
    /////////////////////////////////////////////////////////////////
                //VERIFICATION DES SEANCE A CREER//
    /////////////////////////////////////////////////////////////////
     
    
     
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
        
        
        if(Enseignant.equals(" "))
        {
            bool = true;
        }
        else
        {
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
                        ListeSemaineE.add(RS2.getInt("semaine"));
                    }
                }


                for(int elem : id_SeanceEnseignant)
                {
                    String SqlEtu2 = "select jour from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeJourE.add(RS2.getString("jour"));
                    }
                }


                for(int elem : id_SeanceEnseignant)
                {
                    String SqlEtu2 = "select heure_debut from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureDE.add(RS2.getString("heure_debut"));
                    }
                }


                for(int elem : id_SeanceEnseignant)
                {
                    String SqlEtu2 = "select heure_fin from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureFE.add(RS2.getString("heure_fin"));
                    }
                }


                for(int elem : ListeSemaineE)
                {
                    if(SemaineComp == elem)
                    {
                        SemaineInc = 1;
                    }
                }

                for(String elem : ListeJourE)
                {
                    if(Jour.equals(elem))
                    {
                        JourInc = 1;
                    }
                }

                for(String elem : ListeHeureDE)
                {
                    int HD2;
                    HD2 = scolaM.splitHeureD(elem);

                    if(HeureD.equals(elem) || HD1==HD2-1 || HD1==HD2+1)
                    {
                        HeureDInc = 1;
                    }
                }

                for(String elem : ListeHeureFE)
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
                }

                else
                {
                    bool = true;
                }

            }
        
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        
        
        return bool;
    }
    
    public boolean verifGroupe(String Semaine, String Jour, String HeureD, String HeureF, String Groupe, String Promotion)
    {
        int SemaineInc = 0, JourInc = 0, HeureDInc = 0, HeureFInc = 0;
        int HD1, HF1;
        
        ScolaritéM scolaM = new ScolaritéM();
        
        HD1 = scolaM.splitHeureD(HeureD);
        HF1 = scolaM.splitHeureF(HeureF);
        
        int SemaineComp = Integer.parseInt(Semaine);
        boolean bool = true;
        
        ScolaritéC scolaC = new ScolaritéC();
        int id_groupe = scolaC.idGroupe(Groupe, Promotion);
        
        
        if((Groupe.equals("  ") && Promotion.equals("ING1")) || (Groupe.equals("  ") && Promotion.equals("ING2"))
                || (Groupe.equals("  ") && Promotion.equals("ING3")))
        {
            bool = true;
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlEtu = "select * from seance_groupes where id_groupe=" + id_groupe;
                PreparedStatement pst = con.prepareStatement(SqlEtu);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    id_SeanceGroupe.add(RS.getInt("id_seance"));
                }

                for(int elem : id_SeanceGroupe)
                {
                    String SqlEtu2 = "select semaine from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeSemaineG.add(RS2.getInt("semaine"));
                    }
                }


                for(int elem : id_SeanceGroupe)
                {
                    String SqlEtu2 = "select jour from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeJourG.add(RS2.getString("jour"));
                    }
                }


                for(int elem : id_SeanceGroupe)
                {
                    String SqlEtu2 = "select heure_debut from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureDG.add(RS2.getString("heure_debut"));
                    }
                }


                for(int elem : id_SeanceGroupe)
                {
                    String SqlEtu2 = "select heure_fin from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureFG.add(RS2.getString("heure_fin"));
                    }
                }


                for(int elem : ListeSemaineG)
                {
                    if(SemaineComp == elem)
                    {
                        SemaineInc = 1;
                    }
                }

                for(String elem : ListeJourG)
                {
                    if(Jour.equals(elem))
                    {
                        JourInc = 1;
                    }
                }

                for(String elem : ListeHeureDG)
                {
                    int HD2;
                    HD2 = scolaM.splitHeureD(elem);

                    if(HeureD.equals(elem) || HD1==HD2-1 || HD1==HD2+1)
                    {
                        HeureDInc = 1;
                    }
                }

                for(String elem : ListeHeureFG)
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
                    //System.out.println("Total = " + Total);
                }

                else
                {
                    bool = true;
                    //System.out.println("Total = " + Total);
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        
        
        return bool;
    }
    
    
    public boolean verifSalle(String Semaine, String Jour, String HeureD, String HeureF, String Salle)
    {
        int SemaineInc = 0, JourInc = 0, HeureDInc = 0, HeureFInc = 0;
        int HD1, HF1;
        
        
        
        
        ScolaritéM scolaM = new ScolaritéM();
        
        HD1 = scolaM.splitHeureD(HeureD);
        HF1 = scolaM.splitHeureF(HeureF);
        
        int SemaineComp = Integer.parseInt(Semaine);
        boolean bool = true;
        
        ScolaritéC scolaC = new ScolaritéC();
        int id_salle = scolaC.idSalle(Salle);
        
        if(Salle.equals(" "))
        {
            bool = true;
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlEtu = "select * from seance_salles where id_salle=" + id_salle;
                PreparedStatement pst = con.prepareStatement(SqlEtu);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    id_SeanceSalle.add(RS.getInt("id_seance"));
                }

                for(int elem : id_SeanceSalle)
                {
                    String SqlEtu2 = "select semaine from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeSemaineS.add(RS2.getInt("semaine"));
                    }
                }


                for(int elem : id_SeanceSalle)
                {
                    String SqlEtu2 = "select jour from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeJourS.add(RS2.getString("jour"));
                    }
                }


                for(int elem : id_SeanceSalle)
                {
                    String SqlEtu2 = "select heure_debut from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureDS.add(RS2.getString("heure_debut"));
                    }
                }


                for(int elem : id_SeanceSalle)
                {
                    String SqlEtu2 = "select heure_fin from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureFS.add(RS2.getString("heure_fin"));
                    }
                }


                for(int elem : ListeSemaineS)
                {
                    if(SemaineComp == elem)
                    {
                        SemaineInc = 1;
                    }
                }

                for(String elem : ListeJourS)
                {
                    if(Jour.equals(elem))
                    {
                        JourInc = 1;
                    }
                }

                for(String elem : ListeHeureDS)
                {
                    int HD2;
                    HD2 = scolaM.splitHeureD(elem);

                    if(HeureD.equals(elem) || HD1==HD2-1 || HD1==HD2+1)
                    {
                        HeureDInc = 1;
                    }
                }

                for(String elem : ListeHeureFS)
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
                    //System.out.println("Total = " + Total);
                }

                else
                {
                    bool = true;
                    //System.out.println("Total = " + Total);
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        
        
        return bool;
    }
    
    
    
    
    /////////////////////////////////////////////////////////////////
                //VERIFICATION DES SEANCE A MODIFIER//
    /////////////////////////////////////////////////////////////////
    
    
    
    
    
    public boolean verifEnseignantModifier(String id, String Semaine, String Jour, String HeureD, String HeureF, String Enseignant)
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
        
        
        if(Enseignant.equals(" "))
        {
            bool = true;
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlEtu = "select * from seance_enseignants where id_enseignant=" + id_enseignant + " AND id_seance!=" + "'" + id + "'";
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
                        ListeSemaineE.add(RS2.getInt("semaine"));
                    }
                }


                for(int elem : id_SeanceEnseignant)
                {
                    String SqlEtu2 = "select jour from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeJourE.add(RS2.getString("jour"));
                    }
                }


                for(int elem : id_SeanceEnseignant)
                {
                    String SqlEtu2 = "select heure_debut from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureDE.add(RS2.getString("heure_debut"));
                    }
                }


                for(int elem : id_SeanceEnseignant)
                {
                    String SqlEtu2 = "select heure_fin from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureFE.add(RS2.getString("heure_fin"));
                    }
                }


                for(int elem : ListeSemaineE)
                {
                    if(SemaineComp == elem)
                    {
                        SemaineInc = 1;
                    }
                }

                for(String elem : ListeJourE)
                {
                    if(Jour.equals(elem))
                    {
                        JourInc = 1;
                    }
                }

                for(String elem : ListeHeureDE)
                {
                    int HD2;
                    HD2 = scolaM.splitHeureD(elem);

                    if(HeureD.equals(elem) || HD1==HD2-1 || HD1==HD2+1)
                    {
                        HeureDInc = 1;
                    }
                }

                for(String elem : ListeHeureFE)
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
                }

                else
                {
                    bool = true;
                }

            }
        
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        return bool;
    }
    
    
    public boolean verifGroupeModifier(String id, String Semaine, String Jour, String HeureD, String HeureF, String Groupe, String Promotion)
    {
        int SemaineInc = 0, JourInc = 0, HeureDInc = 0, HeureFInc = 0;
        int HD1, HF1;
        
        ScolaritéM scolaM = new ScolaritéM();
        
        HD1 = scolaM.splitHeureD(HeureD);
        HF1 = scolaM.splitHeureF(HeureF);
        
        int SemaineComp = Integer.parseInt(Semaine);
        boolean bool = true;
        
        ScolaritéC scolaC = new ScolaritéC();
        int id_groupe = scolaC.idGroupe(Groupe, Promotion);
        
        
        if((Groupe.equals("  ") && Promotion.equals("ING1")) || (Groupe.equals("  ") && Promotion.equals("ING2"))
                || (Groupe.equals("  ") && Promotion.equals("ING3")))
        {
            bool = true;
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlEtu = "select * from seance_groupes where id_groupe=" + id_groupe + " AND id_seance!=" + "'" + id + "'";
                PreparedStatement pst = con.prepareStatement(SqlEtu);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    id_SeanceGroupe.add(RS.getInt("id_seance"));
                }

                for(int elem : id_SeanceGroupe)
                {
                    String SqlEtu2 = "select semaine from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeSemaineG.add(RS2.getInt("semaine"));
                    }
                }


                for(int elem : id_SeanceGroupe)
                {
                    String SqlEtu2 = "select jour from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeJourG.add(RS2.getString("jour"));
                    }
                }


                for(int elem : id_SeanceGroupe)
                {
                    String SqlEtu2 = "select heure_debut from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureDG.add(RS2.getString("heure_debut"));
                    }
                }


                for(int elem : id_SeanceGroupe)
                {
                    String SqlEtu2 = "select heure_fin from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureFG.add(RS2.getString("heure_fin"));
                    }
                }


                for(int elem : ListeSemaineG)
                {
                    if(SemaineComp == elem)
                    {
                        SemaineInc = 1;
                    }
                }

                for(String elem : ListeJourG)
                {
                    if(Jour.equals(elem))
                    {
                        JourInc = 1;
                    }
                }

                for(String elem : ListeHeureDG)
                {
                    int HD2;
                    HD2 = scolaM.splitHeureD(elem);

                    if(HeureD.equals(elem) || HD1==HD2-1 || HD1==HD2+1)
                    {
                        HeureDInc = 1;
                    }
                }

                for(String elem : ListeHeureFG)
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
                    //System.out.println("Total = " + Total);
                }

                else
                {
                    bool = true;
                    //System.out.println("Total = " + Total);
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        
        
        return bool;
    }
    
    
    public boolean verifSalleModifier(String id, String Semaine, String Jour, String HeureD, String HeureF, String Salle)
    {
        int SemaineInc = 0, JourInc = 0, HeureDInc = 0, HeureFInc = 0;
        int HD1, HF1;
        
        
        
        
        ScolaritéM scolaM = new ScolaritéM();
        
        HD1 = scolaM.splitHeureD(HeureD);
        HF1 = scolaM.splitHeureF(HeureF);
        
        int SemaineComp = Integer.parseInt(Semaine);
        boolean bool = true;
        
        ScolaritéC scolaC = new ScolaritéC();
        int id_salle = scolaC.idSalle(Salle);
        
        if(Salle.equals(" "))
        {
            bool = true;
        }
        else
        {
            try
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

                String SqlEtu = "select * from seance_salles where id_salle=" + id_salle + " AND id_seance!=" + "'" + id + "'";
                PreparedStatement pst = con.prepareStatement(SqlEtu);

                ResultSet RS = pst.executeQuery();

                while (RS.next())
                {
                    id_SeanceSalle.add(RS.getInt("id_seance"));
                }

                for(int elem : id_SeanceSalle)
                {
                    String SqlEtu2 = "select semaine from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeSemaineS.add(RS2.getInt("semaine"));
                    }
                }


                for(int elem : id_SeanceSalle)
                {
                    String SqlEtu2 = "select jour from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeJourS.add(RS2.getString("jour"));
                    }
                }


                for(int elem : id_SeanceSalle)
                {
                    String SqlEtu2 = "select heure_debut from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureDS.add(RS2.getString("heure_debut"));
                    }
                }


                for(int elem : id_SeanceSalle)
                {
                    String SqlEtu2 = "select heure_fin from seance where id=" + elem;
                    PreparedStatement pst2 = con.prepareStatement(SqlEtu2);

                    ResultSet RS2 = pst2.executeQuery();

                    while(RS2.next())
                    {
                        ListeHeureFS.add(RS2.getString("heure_fin"));
                    }
                }


                for(int elem : ListeSemaineS)
                {
                    if(SemaineComp == elem)
                    {
                        SemaineInc = 1;
                    }
                }

                for(String elem : ListeJourS)
                {
                    if(Jour.equals(elem))
                    {
                        JourInc = 1;
                    }
                }

                for(String elem : ListeHeureDS)
                {
                    int HD2;
                    HD2 = scolaM.splitHeureD(elem);

                    if(HeureD.equals(elem) || HD1==HD2-1 || HD1==HD2+1)
                    {
                        HeureDInc = 1;
                    }
                }

                for(String elem : ListeHeureFS)
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
                    //System.out.println("Total = " + Total);
                }

                else
                {
                    bool = true;
                    //System.out.println("Total = " + Total);
                }

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
        }
        
        
        
        return bool;
    }
    
    
    
    
    public ArrayList<Seance> getSeanceList()
    {
       ArrayList<Seance> SeanceList = new ArrayList<Seance>();
       

       try 
       {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

            String query = "SELECT *, id_enseignant, id_groupe from seance s "
                    + "INNER JOIN seance_enseignants se ON s.id = se.id_seance "
                    + "INNER JOIN seance_groupes sg ON se.id_seance = sg.id_seance "
                    + "INNER JOIN seance_salles ss ON sg.id_seance = ss.id_seance";
     

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
      catch (Exception e) {
           e.printStackTrace();
       }
       
       return SeanceList;
    }
    
    
    
    
    public ArrayList<Seance> getSeanceListWithID(String id)
    {
       ArrayList<Seance> SeanceList = new ArrayList<Seance>();
       

       try 
       {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

            String query = "SELECT *, id_enseignant, id_groupe from seance s "
                    + "INNER JOIN seance_enseignants se ON s.id = se.id_seance "
                    + "INNER JOIN seance_groupes sg ON se.id_seance = sg.id_seance "
                    + "INNER JOIN seance_salles ss ON sg.id_seance = ss.id_seance where s.id="+ "'" + id + "'";
     

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
      catch (Exception e) {
           e.printStackTrace();
       }
       
       return SeanceList;
    }
    
    
    public static void main(String[] args)
    {
        ScolaritéM scolaM = new ScolaritéM();
        scolaM.getSeanceList();
      
    }
}


    