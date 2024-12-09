/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author duong
 */
public class KNCSDL {
    private Connection con = null;

   public Connection ketnoi() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/qlbanhang", "root", ""); // Sửa lại cổng và tên DB
}


   public ResultSet getData() throws ClassNotFoundException, SQLException {
    Connection con = ketnoi();
    String sql = "SELECT MaKH, MaSP, GiaSP, SoLuong FROM banhang";
    Statement st = con.createStatement();
    return st.executeQuery(sql);
}


    public int xoa(String MaKH) throws ClassNotFoundException, SQLException {
        try ( Connection con = ketnoi()) {
            String sql = "DELETE FROM banhang WHERE MaKH = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, MaKH);
            return st.executeUpdate();
        }
    }
   public boolean kiemTraMaKH(String MaKH) throws ClassNotFoundException, SQLException {
    try (Connection con = ketnoi()) {
        String sql = "SELECT COUNT(*) FROM banhang WHERE MaKH = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, MaKH);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    }
    return false;
}

}
