/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tapchi;

/**
 *
 * @author admin
 */
@WebServlet(name = "them", urlPatterns = {"/them"})
public class them extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma = Integer.parseInt(request.getParameter("ma")); 
        String tensp = request.getParameter("tensp");
        int gia = Integer.parseInt(request.getParameter("gia"));

        kncsdl k = new kncsdl();
        try {
            // Thêm sản phẩm vào cơ sở dữ liệu
            Connection con = null;
            try {
                con = k.ketnoi(); // Make sure to handle the connection properly
            } catch (SQLException ex) {
                Logger.getLogger(them.class.getName()).log(Level.SEVERE, null, ex);
            }
            String query = "INSERT INTO product (ma, tensp, gia) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, ma);    // Insert the correct 'ma' (product code)
            stmt.setString(2, tensp);
            stmt.setInt(3, gia);
            stmt.executeUpdate(); // Execute the insert query

            // After insertion, redirect to the product list page
            response.sendRedirect("test_session"); // Redirect to display updated list

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(them.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   
   

}
