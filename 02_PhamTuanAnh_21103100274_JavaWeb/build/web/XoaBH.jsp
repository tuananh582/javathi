<%-- 
    Document   : XoaBH
    Created on : Dec 7, 2024, 3:24:49 PM
    Author     : admin
--%>

<%@page import="database.DBConfig"%>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <style>
        
        /* Định dạng chung cho trang */
body {
    font-family: Arial, sans-serif;
    margin: 20px;
    padding: 0;
    background-color: #f8f9fa;
    color: #343a40;
}

/* Định dạng tiêu đề */
h1 {
    color: #007bff;
    text-align: center;
    margin-bottom: 20px;
}

h2 {
    color: #6c757d;
    margin-top: 30px;
}

/* Bảng hiển thị dữ liệu */
table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

table th, table td {
    border: 1px solid #dee2e6;
    padding: 10px;
    text-align: center;
}

table th {
    background-color: #007bff;
    color: #ffffff;
    font-weight: bold;
}

table tr:nth-child(even) {
    background-color: #f2f2f2;
}

table tr:hover {
    background-color: #e9ecef;
}

/* Form nhập mã khách hàng */
form {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 20px;
}

form label {
    font-size: 16px;
    margin-bottom: 10px;
}

form input {
    padding: 10px;
    font-size: 16px;
    margin-bottom: 15px;
    width: 300px;
    border: 1px solid #ced4da;
    border-radius: 4px;
}

form button {
    padding: 10px 20px;
    font-size: 16px;
    color: #fff;
    background-color: #28a745;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

form button:hover {
    background-color: #218838;
}

/* Định dạng lỗi */
.error {
    color: #dc3545;
    font-weight: bold;
    text-align: center;
    margin-top: 10px;
}

    </style>
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
            <th>Thành Tiền</th>
        </tr>
        <%
            try {
                Connection conn = DBConfig.getConnection();
                Statement stmt = conn.createStatement();
                String sql = "SELECT MaKH, MaSP, GiaSP, SoLuong FROM BanHang";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    double giaSP = rs.getDouble("GiaSP");
                    int quantity = rs.getInt("SoLuong");
                    double thanhTien = (giaSP * quantity) - (giaSP * quantity * 0.05);
        %>
        <tr>
            <td><%= rs.getString("MaKH") %></td>
            <td><%= rs.getString("MaSP") %></td>
            <td><%= rs.getDouble("GiaSP") %></td>
            <td><%= rs.getInt("SoLuong") %></td>
            <td><%= thanhTien %></td>
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
</body>
</html>
