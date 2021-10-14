/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankmanagementsystem;
import java.sql.* ;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SeeMonster
 */
public class DBConnection {
    
    private static Connection conn;
    
    public static Connection connectToDB(){
        try {
            //load Driver
            Class.forName("com.mysql.jdbc.Driver");
            //get Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost/bankmanagement1","root","");
       
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn ;
    }
    
}
