<%@page import="model.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sửa Sản Phẩm</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Sửa Sản Phẩm</h1>
            <form action="sua" method="post">
                <input type="hidden" name="ma" value="<%= request.getAttribute("ma") %>">
                <div class="form-group">
                    <label for="tensp">Tên Sản Phẩm:</label>
                    <input type="text" class="form-control" id="tensp" name="tensp" value="<%= request.getAttribute("tensp") %>" required>
                </div>
                <div class="form-group">
                    <label for="gia">Giá (VND):</label>
                    <input type="number" class="form-control" id="gia" name="gia" value="<%= request.getAttribute("gia") %>" required>
                </div>
                <button type="submit" class="btn btn-success">Cập Nhật</button>
            </form>
        </div>
    </body>
</html>
