package controleur;

/**
 * Package controle 
 * Ce package établit la connexion entre l'interface graphique et la BDD
 * Il insert des données rentrées dans l'interface graphique et les insert dans la BDD
 * @author flori
 */
public class EnseignantC {
    
    protected int MatiereX;
    protected int MatiereY;
    
    public EnseignantC()
    {
        
    }
    
    public int CoordX(String Jour)
    {
        if(Jour.equals("Lundi"))
        {
            MatiereX = 100;
        }
        
        if(Jour.equals("Mardi"))
        {
            MatiereX = 266;
        }
        
        if(Jour.equals("Mercredi"))
        {
            MatiereX = 433;
        }
        
        if(Jour.equals("Jeudi"))
        {
            MatiereX = 598;
        }
        
        if(Jour.equals("Vendredi"))
        {
            MatiereX = 765;
        }
        
        if(Jour.equals("Samedi"))
        {
            MatiereX = 931;
        }
        
        return MatiereX;
    }
    
    public int CoordY(String HeureD)
    {
        if(HeureD.equals("09h00"))
        {
            MatiereY = 70;
        }
        
        if(HeureD.equals("10h00"))
        {
            MatiereY = 124;
        }
        
        if(HeureD.equals("11h00"))
        {
            MatiereY = 178;
        }
        
        if(HeureD.equals("12h00"))
        {
            MatiereY = 232;
        }
        
        if(HeureD.equals("13h00"))
        {
            MatiereY = 286;
        }
        
        if(HeureD.equals("14h00"))
        {
            MatiereY = 340;
        }
        
        if(HeureD.equals("15h00"))
        {
            MatiereY = 394;
        }
        
        if(HeureD.equals("16h00"))
        {
            MatiereY = 448;
        }
        
        if(HeureD.equals("17h00"))
        {
            MatiereY = 502;
        }
        
        if(HeureD.equals("18h00"))
        {
            MatiereY = 556;
        }
        
        if(HeureD.equals("19h00"))
        {
            MatiereY = 610;
        } 
        
        return MatiereY;
    }
}
