
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class koneksi {
    public Connection getKoneksi() throws ClassNotFoundException, SQLException{
       Class.forName("com.mysql.jdbc.Driver");
       String url="jdbc:mysql://localhost/konversi";
       Connection con = DriverManager.getConnection(url,"root","");
       return con;
    }
}      
