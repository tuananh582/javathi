/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class KetnoiCSDL {
    private Connection connection;
    public Connection KNCDL(){
        try{
            String url = "jdbc:mysql://localhost:3306/qltapchi";
            String user = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =  DriverManager.getConnection(url,user,password);
        }catch(ClassNotFoundException| SQLException e ){
            e.printStackTrace();
        }
        return connection;
    }
    
}
