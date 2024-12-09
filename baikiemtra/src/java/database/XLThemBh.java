/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package database;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author admin
 */
@WebServlet("/XLThemBh")
public class XLThemBh extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String maKH = request.getParameter("maKH");
        String maSP = request.getParameter("maSP");
        String giaSPStr = request.getParameter("giaSP");
        String soLuongStr = request.getParameter("soLuong");
        try {
            // Chuyển đổi dữ liệu giá và số lượng sang kiểu số
            double giaSP = Double.parseDouble(giaSPStr);
            int soLuong = Integer.parseInt(soLuongStr);

            // Kết nối tới database
            Connection conn = DBConfig.getConnection();

            // Thêm dữ liệu vào bảng BanHang
            String sql = "INSERT INTO BanHang (MaKH, MaSP, GiaSP, SoLuong) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, maKH);
            pstmt.setString(2, maSP);
            pstmt.setDouble(3, giaSP);
            pstmt.setInt(4, soLuong);

            int rowsInserted = pstmt.executeUpdate();

            // Kiểm tra kết quả
            if (rowsInserted > 0) {
                System.out.println("Thêm dữ liệu thành công!");
            } else {
                System.out.println("Không thể thêm dữ liệu.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          response.sendRedirect("XoaBH.jsp");

    }
    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException{
        processRequest(request, response);
    }
    @Override
    protected void doPost (HttpServletRequest request , HttpServletResponse response ) throws ServletException,IOException{
        processRequest(request, response);
    }
    public String getServeletInfo(){
        return "Servlet xu ly du lieu them vao bang ban hang ";
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
