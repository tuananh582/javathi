<%@page import="java.util.List"%>
<%@page import="com.example.BanHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> Xóa Hàng Hóa</title>
<h1>LÊ TRIỀU DƯƠNG</h1>
    
</head>
<body>
    <h1>Xóa Hóa Đơn</h1>

    <div class="form-container">
        <form method="POST" action="XLXoaBH">
            <div class="mb-3">
                <label for="cong" class="form-label">Nhập mã khách hàng:</label>
                <input type="text" class="form-control" id="cong" name=cong"cong" placeholder="Nhập mã khách hàng để xóa">
            </div>
            <button type="submit" class="btn">Xóa</button>
        </form>
    </div>

    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
    <div class="message"><%= message %></div>
    <%
        }
    %>

    <%
        List<BanHang> list = (List<BanHang>) session.getAttribute("bong");
        if (list != null && !list.isEmpty()) {
    %>
    <div class="table-container">
        <h2 class="text-center mt-3" style="color: #6c63ff;">Thông Tin Bán Hàng</h2>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Mã Khách Hàng</th>
                    <th>Mã Sản Phẩm</th>
                    <th>Giá Sản Phẩm</th>
                    <th>Số Lượng</th>
                    <th>Thành Tiền</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (BanHang b : list) {
                        double thanhTien = (b.getSoLuong() * b.getGiaSP()) - (b.getSoLuong() * b.getGiaSP() * 0.05);
                %>
                <tr>
                    <td><%= b.getMaKH() %></td>
                    <td><%= b.getMaSP() %></td>
                    <td><%= b.getGiaSP() %></td>
                    <td><%= b.getSoLuong() %></td>
                    <td><%= String.format("%.2f", thanhTien) %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <%
        } 
    %>
    

    
</body>
</html>
