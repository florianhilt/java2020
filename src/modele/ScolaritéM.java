package modele;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class ScolaritéM {
    protected ArrayList<String> Matière = new ArrayList<>();
    protected ArrayList<String> Enseignant = new ArrayList<>();
    protected ArrayList<String> Groupe = new ArrayList<>();
    protected ArrayList<String> Promotion = new ArrayList<>();
    protected ArrayList<String> Salle = new ArrayList<>();
    

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
}
    