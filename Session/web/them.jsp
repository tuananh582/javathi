<%@page import="java.util.List"%>
<%@page import="model.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Thêm Sản Phẩm</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Thêm Sản Phẩm</h1>
            <!-- Form này gửi yêu cầu POST đến Servlet "them" -->
            <form action="them" method="post">
                <div class="form-group">
                    <label for="tensp">Mã:</label>
                    <input type="text" class="form-control" id="ma" name="ma" required>
                </div>
                <div class="form-group">
                    <label for="tensp">Tên Sản Phẩm:</label>
                    <input type="text" class="form-control" id="tensp" name="tensp" required>
                </div>
                <div class="form-group">
                    <label for="gia">Giá (VND):</label>
                    <input type="number" class="form-control" id="gia" name="gia" required>
                </div>
                <button type="submit" class="btn btn-success">Thêm</button>
            </form>
        </div>
    </body>
</html>
