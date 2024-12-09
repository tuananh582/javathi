/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet("/XLSuaBh")
public class XLSuaBh extends HttpServlet {

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
       String maKH = request.getParameter("maKH");
        String maSP = request.getParameter("maSP");
        String giaSPStr = request.getParameter("giaSP");
        String soLuongStr = request.getParameter("soLuong");

        try {
            // Chuyển đổi dữ liệu số
            double giaSP = Double.parseDouble(giaSPStr);
            int soLuong = Integer.parseInt(soLuongStr);

            // Kết nối tới database
            Connection conn = DBConfig.getConnection();

            // Cập nhật dữ liệu trong bảng BanHang
            String sql = "UPDATE BanHang SET MaSP = ?, GiaSP = ?, SoLuong = ? WHERE MaKH = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maSP); // Cập nhật MaSP
            pstmt.setDouble(2, giaSP); // Cập nhật Giá SP
            pstmt.setInt(3, soLuong); // Cập nhật Số Lượng
            pstmt.setString(4, maKH); // Dựa trên MaKH

            int rowsUpdated = pstmt.executeUpdate();

            // Kiểm tra kết quả
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật dữ liệu thành công!");
            } else {
                System.out.println("Không tìm thấy khách hàng cần cập nhật.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Chuyển hướng về lại trang XoaBH.jsp
        response.sendRedirect("XoaBH.jsp");
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
