package planning;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.sql.*;



public class LoginPage extends JFrame implements ActionListener
{
    JButton blogin    = new JButton("Continue");
    JTextField ID = new JTextField(20);
    JTextField PW = new JTextField(20);
    JLabel password = new JLabel("Mot de passe");
    JRadioButton ENS = new JRadioButton("Enseignant");
    JRadioButton ETU = new JRadioButton("Etudiant");
    JRadioButton RES = new JRadioButton("Responsable");
    JRadioButton SCO = new JRadioButton("Scolarite");
    ImageIcon icon = new ImageIcon("music.jpg");
    JLabel username = new JLabel("Email");
    JLabel Title = new JLabel("Veuillez vous connecter");
    JFrame frame = new JFrame();
    JPanel panel = (JPanel) frame.getContentPane();
    
    
    

    public LoginPage()
    {
   
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.setTitle("Login Page");
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.lightGray);

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(ENS);
        bgroup.add(ETU);
        bgroup.add(RES);
        bgroup.add(SCO);

        Title.setFont(new Font("Arial",10 ,32));

        PlacementLabel(Title, 25);

        panel.add(ETU);
        Dimension size2 = ETU.getPreferredSize();
        ETU.setBounds(50,100, 87, size2.height);

        panel.add(ENS);
        Dimension size3 = ENS.getPreferredSize();
        ENS.setBounds(187,100, 100, size3.height);
        
        panel.add(RES);
        Dimension size4 = RES.getPreferredSize();
        RES.setBounds(324,100, 100, size2.height);

        panel.add(SCO);
        Dimension size5 = SCO.getPreferredSize();
        SCO.setBounds(461,100, 87, size3.height);

        PlacementLabel(username, 150);
        PlacementField(ID, 170);

        PlacementLabel(password, 220);
        PlacementField(PW, 240);

        panel.add(blogin);
        Dimension size8 = blogin.getPreferredSize();
        blogin.setBounds(250,290, 100, size8.height);


        frame.setSize(600, 400);
        frame.setLocation(x-250, y-200);
        frame.setVisible(true);

        blogin.addActionListener(this);    
    
    }
  
    public void PlacementLabel(JLabel label, int h)
    {
        int w;
        panel.add(label);
        Dimension size1 = label.getPreferredSize();
        w = 300-(size1.width/2);
        label.setBounds(w, h, size1.width, size1.height);   
    }
    
    public void PlacementField(JTextField Field, int h)
    {
        int w;
        panel.add(Field);
        Dimension size1 = Field.getPreferredSize();
        w = 300-(size1.width/2);
        Field.setBounds(w, h, size1.width, size1.height);   
    }
  
public void actionPerformed(ActionEvent ae)
{
    
    try
    {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

       
        if (ETU.isSelected())
        {
            
            String SqlEtu = "select * from utilisateur WHERE email=? AND password=? and droit=1";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            pst.setString(1, ID.getText());
            pst.setString(2, PW.getText()); 
            
            ResultSet RS = pst.executeQuery();
            
            if (RS.next())
            {
                new PageEtudiant();
                this.dispose();
            }
            else
               JOptionPane.showMessageDialog(null, "Wrong admin information please try again");
        }
        
        if (ENS.isSelected())
        {
            
            String SqlEtu = "select * from utilisateur WHERE email=? AND password=? and droit=2";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            pst.setString(1, ID.getText());
            pst.setString(2, PW.getText()); 
            
            ResultSet RS = pst.executeQuery();
            
            if (RS.next())
            {
                JOptionPane.showMessageDialog(null, "Success");
            }
            else
               JOptionPane.showMessageDialog(null, "Wrong admin information please try again");
        }
       
        if (RES.isSelected())
        {
            
            String SqlEtu = "select * from utilisateur WHERE email=? AND password=? and droit=3";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            pst.setString(1, ID.getText());
            pst.setString(2, PW.getText()); 
            
            ResultSet RS = pst.executeQuery();
            
            if (RS.next())
            {
                JOptionPane.showMessageDialog(null, "Success");
            }
            else
               JOptionPane.showMessageDialog(null, "Wrong admin information please try again");
        }
        
        if (SCO.isSelected())
        {
            
            String SqlEtu = "select * from utilisateur WHERE email=? AND password=? and droit=4";
            PreparedStatement pst = con.prepareStatement(SqlEtu);
            
            pst.setString(1, ID.getText());
            pst.setString(2, PW.getText()); 
            
            ResultSet RS = pst.executeQuery();
            
            if (RS.next())
            {
                JOptionPane.showMessageDialog(null, "Success");
            }
            else
               JOptionPane.showMessageDialog(null, "Wrong admin information please try again");
        }
        
        
    
    }
    
    catch(Exception exception)
    {
        exception.printStackTrace();
    }
    /*
    if (USR.isSelected())
    {
        new UserInterface();
        this.dispose();
    } */
}

public static void main( String[] args){new LoginPage();}

}







