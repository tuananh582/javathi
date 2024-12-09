/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConfig {
    public static Connection getConnection()throws Exception{
         String url = "jdbc:mysql://localhost:3306/qlbanhang"; // Đổi "ten_database" thành tên database của bạn
        String user = "root"; 
        String password = ""; // Đổi "matkhau" thành mật khẩu của bạn
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver MySQL
        return DriverManager.getConnection(url, user, password);
    }
}
