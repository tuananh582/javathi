package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SanPham;
/**
 *
 * @author hieuc
 */
@WebServlet(urlPatterns = {"/test_session"})
public class test_session extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        kncsdl k = new kncsdl();
        ResultSet rs = null;
        String search = request.getParameter("search"); // Lấy từ khóa tìm kiếm

        try {
            if (search != null && !search.trim().isEmpty()) {
                // Tìm kiếm với từ khóa
                rs = k.getDataBySearch("product", search.trim());
            } else {
                // Lấy toàn bộ sản phẩm nếu không nhập từ khóa
                rs = k.getData("product");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(test_session.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<SanPham> list = new ArrayList<>();
        HttpSession ss = request.getSession();
        try {
            while (rs != null && rs.next()) {
                int ma = Integer.parseInt(rs.getString("ma"));
                String tensp = rs.getString("tensp");
                int gia = Integer.parseInt(rs.getString("gia"));
                SanPham p = new SanPham(ma, tensp, gia);
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(test_session.class.getName()).log(Level.SEVERE, null, ex);
        }

        ss.setAttribute("dssp", list);
        RequestDispatcher r = request.getRequestDispatcher("./hienthisp.jsp");
        r.forward(request, response);
    }



   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
