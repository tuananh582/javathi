/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hieuc
 */
public class kncsdl {

   public Connection con = null;
    String url = "jdbc:mysql://localhost:3306/qlsp";

    public Connection ketnoi() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {

            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(kncsdl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }
        public ResultSet getData(String tablename) throws ClassNotFoundException, SQLException{
        kncsdl kn= new kncsdl();
        con=kn.ketnoi();
        ResultSet rs= null;
        String query = "select *from " + tablename;
        try {
            PreparedStatement p = con.prepareStatement(query);
            rs = p.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(kncsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getDataBySearch(String tablename, String keyword) throws ClassNotFoundException, SQLException {
        kncsdl kn = new kncsdl();
        con = kn.ketnoi();
        ResultSet rs = null;
        String query = "SELECT * FROM " + tablename + " WHERE tensp LIKE ?";
        try {
            PreparedStatement p = con.prepareStatement(query);
            p.setString(1, "%" + keyword + "%"); // Thêm ký tự % để hỗ trợ tìm kiếm gần đúng
            rs = p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(kncsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }


    //de test xem ket noi thanh cong chua
    public static void main(String[] args) throws SQLException {
        kncsdl kn = new kncsdl();
        try {
            kn.ketnoi();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(kncsdl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
