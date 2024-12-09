/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duong
 */
@WebServlet(name = "XLXoaBH", urlPatterns = {"/XLXoaBH"})
public class XLXoaBH extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet XLXoaBH</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet XLXoaBH at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    KNCSDL kncsdl = new KNCSDL();
    List<BanHang> list = new ArrayList<>();
    HttpSession session = request.getSession();

    try (ResultSet rs = kncsdl.getData()) {
        while (rs.next()) {
            String MaKH = rs.getString("MaKH");
            String MaSP = rs.getString("MaSP");
            double GiaSP = rs.getDouble("GiaSP");
            int SoLuong = rs.getInt("SoLuong");

            // Tạo đối tượng BanHang từ dữ liệu ResultSet
            BanHang b = new BanHang(MaKH, MaSP, GiaSP, SoLuong);
            list.add(b);
        }
    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("errorMessage", "Lỗi khi lấy dữ liệu từ cơ sở dữ liệu: " + e.getMessage());
    }

    // Lưu danh sách vào session
    session.setAttribute("bong", list);

    // Chuyển tiếp tới JSP
    RequestDispatcher dispatcher = request.getRequestDispatcher("XoaBH.jsp");
    dispatcher.forward(request, response);
}


    
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String maKH = request.getParameter("cong"); // Lấy mã khách hàng từ form
    KNCSDL kncsdl = new KNCSDL();
    String message;

    try {
        if (kncsdl.kiemTraMaKH(maKH)) {
            int rows = kncsdl.xoa(maKH); // Thực hiện xóa
            if (rows > 0) {
                message = "Xóa thành công mã : " + maKH;
            } else {
                message = "Không thể xóa mã của khach hàng: " + maKH;
            }
        } else {
            message = "Xóa không thành công do không tìm thấy mã khách hàng: " + maKH;
        }
    } catch (Exception e) {
        e.printStackTrace();
        message = "Lỗi hệ thống: " + e.getMessage();
    }

    // Gửi thông báo về JSP
    request.setAttribute("message", message);

    // Làm mới danh sách
    doGet(request, response);
}


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
