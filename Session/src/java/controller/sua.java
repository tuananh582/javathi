/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

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
import model.SanPham;

/**
 *
 * @author hieuc
 */
@WebServlet(name = "sua", urlPatterns = {"/sua"})
public class sua extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma = Integer.parseInt(request.getParameter("ma"));

        kncsdl k = new kncsdl();
        try {
            Connection con = k.ketnoi(); // Kết nối cơ sở dữ liệu
            String query = "SELECT * FROM product WHERE ma = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, ma);  // Lấy ID sản phẩm
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Lấy thông tin hiện tại của sản phẩm
                String tensp = rs.getString("tensp");
                int gia = rs.getInt("gia");

                // Đặt các thuộc tính để hiển thị trong form
                request.setAttribute("ma", ma);
                request.setAttribute("tensp", tensp);
                request.setAttribute("gia", gia);

                // Chuyển hướng đến trang sửa sản phẩm
                RequestDispatcher rd = request.getRequestDispatcher("/sua.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(sua.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ma = Integer.parseInt(request.getParameter("ma"));
        String tensp = request.getParameter("tensp");
        int gia = Integer.parseInt(request.getParameter("gia"));

        kncsdl k = new kncsdl();
        try {
            Connection con = k.ketnoi(); // Kết nối cơ sở dữ liệu
            String query = "UPDATE product SET tensp = ?, gia = ? WHERE ma = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, tensp);  // Cập nhật tên sản phẩm
            stmt.setInt(2, gia);       // Cập nhật giá sản phẩm
            stmt.setInt(3, ma);        // Cập nhật ID sản phẩm
            int rowsUpdated = stmt.executeUpdate();  // Thực thi câu lệnh cập nhật

            if (rowsUpdated > 0) {
                // Cập nhật thành công
                request.setAttribute("message", "Sản phẩm đã được cập nhật thành công!");
            } else {
                // Nếu không có dòng nào được cập nhật
                request.setAttribute("message", "Lỗi: Không có sản phẩm nào để cập nhật.");
            }

            // Lấy lại danh sách sản phẩm sau khi cập nhật
            List<SanPham> list = new ArrayList<>();
            ResultSet rs = k.getData("product");
            while (rs.next()) {
                int id = rs.getInt("ma");
                String name = rs.getString("tensp");
                int price = rs.getInt("gia");
                SanPham sp = new SanPham(id, name, price);
                list.add(sp);
            }

            // Lưu danh sách sản phẩm vào session
            request.getSession().setAttribute("dssp", list);

            // Chuyển hướng đến trang hiển thị sản phẩm
            RequestDispatcher rd = request.getRequestDispatcher("hienthisp.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(sua.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet sửa sản phẩm";
    }
}

