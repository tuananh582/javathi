<%-- 
    Document   : XoaBH
    Created on : Dec 7, 2024, 2:56:15 PM
    Author     : admin
--%>

<%@page import="database.DBConfig"%>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Xóa Bán Hàng</title>
</head>
<body>
    <h1>Danh sách Bán Hàng</h1>
    <table border="1">
        <tr>
            <th>Mã KH</th>
            <th>Mã SP</th>
            <th>Giá SP</th>
            <th>Số Lượng</th>
        </tr>
        <%
            try {
                Connection conn = DBConfig.getConnection();
                Statement stmt = conn.createStatement();
                String sql = "SELECT MaKH, MaSP, GiaSP, SoLuong FROM BanHang";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getString("MaKH") %></td>
            <td><%= rs.getString("MaSP") %></td>
            <td><%= rs.getDouble("GiaSP") %></td>
            <td><%= rs.getInt("SoLuong") %></td>
        </tr>
        <%
                }
                conn.close();
            } catch (Exception e) {
                out.println("Lỗi: " + e.getMessage());
            }
        %>
    </table>
    <h2>Xóa Khách Hàng</h2>
    <form action="XLXoaBh" method="post">
        <label for="maKH">Mã KH:</label>
        <input type="text" name="maKH" id="maKH" required>
        <button type="submit">Xóa</button>
    </form>
    
    <h2>Thêm Dữ Liệu Bán Hàng</h2>
<form action="XLThemBh" method="post">
    <label for="maKH">Mã KH:</label>
    <input type="text" name="maKH" id="maKH" required><br>

    <label for="maSP">Mã SP:</label>
    <input type="text" name="maSP" id="maSP" required><br>

    <label for="giaSP">Giá SP:</label>
    <input type="text" name="giaSP" id="giaSP" required><br>

    <label for="soLuong">Số Lượng:</label>
    <input type="text" name="soLuong" id="soLuong" required><br>

    <button type="submit">Thêm</button>
</form>
    
    
   <h2>Tìm Kiếm Dữ Liệu Bán Hàng</h2>
<form action="XLTimKiemBh" method="post">
    <label for="maSP">Mã Sản Phẩm:</label>
    <input type="text" name="maSP" id="maSP" required>
    <button type="submit">Tìm Kiếm</button>
</form>

<%-- Hiển thị kết quả tìm kiếm nếu có --%>
<%
    List<String[]> searchResults = (List<String[]>) request.getAttribute("searchResults");
    if (searchResults != null) {
%>
    <h3>Kết Quả Tìm Kiếm:</h3>
    <table border="1">
        <tr>
            <th>Mã KH</th>
            <th>Mã SP</th>
            <th>Giá SP</th>
            <th>Số Lượng</th>
        </tr>
        <% for (String[] row : searchResults) { %>
        <tr>
            <td><%= row[0] %></td>
            <td><%= row[1] %></td>
            <td><%= row[2] %></td>
            <td><%= row[3] %></td>
        </tr>
        <% } %>
    </table>
<% } %>

<h2>Sửa Thông Tin Bán Hàng Theo Mã Khách Hàng</h2>
<form action="XLSuaBh" method="post">
    <label for="maKH">Mã KH:</label>
    <input type="text" name="maKH" id="maKH" required><br>

    <label for="maSP">Mã SP:</label>
    <input type="text" name="maSP" id="maSP" required><br>

    <label for="giaSP">Giá SP Mới:</label>
    <input type="text" name="giaSP" id="giaSP" required><br>

    <label for="soLuong">Số Lượng Mới:</label>
    <input type="text" name="soLuong" id="soLuong" required><br>

    <button type="submit">Cập Nhật</button>
</form>




</body>
</html>
