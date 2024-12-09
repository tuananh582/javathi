<%@page import="java.util.List"%>
<%@page import="model.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Danh Sách Sản Phẩm</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    </head>
    <body>
        <div class="text-center">
            <a href="them.jsp" class="btn btn-primary">Thêm Sản Phẩm</a>
        </div>
        <div class="container">
            <h1 class="text-center">Danh Sách Sản Phẩm</h1>
            <form method="get" action="test_session">
                <div class="form-group row">
                    <div class="col-sm-10">
                        <input type="text" name="search" class="form-control" placeholder="Nhập tên sản phẩm cần tìm..." />
                    </div>
                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-primary">Tìm kiếm</button>
                    </div>
                </div>
            </form>
            <%
                List<SanPham> dssp = (List<SanPham>) session.getAttribute("dssp");
                if (dssp == null || dssp.isEmpty()) {
            %>
            <p class="text-center text-muted">Hiện chưa có sản phẩm nào trong danh sách.</p>
            <% } else { %>
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Mã</th>
                        <th>Tên Sản Phẩm</th>
                        <th>Giá (VND)</th>
                        <th>Chức Năng</th> <!-- Cột chức năng -->
                    </tr>
                </thead>
                <tbody>
                    <% for (SanPham p : dssp) {%>
                    <tr>
                        <td><%= p.getMa()%></td>
                        <td><%= p.getTensp()%></td>
                        <td><%= p.getGia()%> VND</td>
                        <td>
                            <!-- Buttons for delete and edit -->
                            
                            <a href="sua?ma=<%= p.getMa()%>" class="btn btn-warning btn-sm">Sửa</a>
                            <a href="xoa?ma=<%= p.getMa()%>" class="btn btn-danger btn-sm">Xóa</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% }%>
           
        </div>
    </body>
</html>
