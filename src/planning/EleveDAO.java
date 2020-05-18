/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EleveDAO {
    public static void main(String[] args) {
        // TODO code application logic here

        try {
        //connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2020?useSSL=false", "root", "");

            Statement myStmt = myConn.createStatement();

            ResultSet myRs = myStmt.executeQuery("select * from utilisateur");

            //results set
            while (myRs.next()) {
                //Test pour des informations saisis manuellement dans la BDD
                System.out.println(myRs.getString("nom"));
                System.out.println(myRs.getString("email"));

            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
