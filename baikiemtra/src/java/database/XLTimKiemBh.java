/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author admin
 */
@WebServlet("/XLTimKiemBh")
public class XLTimKiemBh extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String maSP = request.getParameter("maSP");
        List<String[]> results = new ArrayList<>();

        try {
            // Kết nối tới database
            Connection conn = DBConfig.getConnection();

            // Truy vấn dữ liệu gần đúng theo MaSP
            String sql = "SELECT MaKH, MaSP, GiaSP, SoLuong FROM BanHang WHERE MaSP LIKE ?"; // muon tim ket qua chinh xac thay LIKE bang dau =
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + maSP + "%"); // Sử dụng LIKE để tìm kiếm gần đúng
            ResultSet rs = pstmt.executeQuery();

            // Lưu kết quả tìm kiếm vào danh sách
            while (rs.next()) {
                String[] row = new String[4];
                row[0] = rs.getString("MaKH");
                row[1] = rs.getString("MaSP");
                row[2] = String.valueOf(rs.getDouble("GiaSP"));
                row[3] = String.valueOf(rs.getInt("SoLuong"));
                results.add(row);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Đưa kết quả tìm kiếm vào request scope và chuyển hướng về trang JSP
        request.setAttribute("searchResults", results);
        request.getRequestDispatcher("XoaBH.jsp").forward(request, response);
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
