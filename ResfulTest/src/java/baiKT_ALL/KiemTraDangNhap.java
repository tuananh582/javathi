package baiKT_ALL;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("KiemTraDangNhap")
public class KiemTraDangNhap {

    @Context
    private UriInfo context;
    
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";

    public KiemTraDangNhap() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
     public String KiemTraDangNhap(
        @QueryParam("username") String username,
        @QueryParam("password") String password) {
        
        // Kiểm tra tính hợp lệ
        if (username == null || password == null) {
            return "Vui lòng nhập đầy đủ tài khoản và mật khẩu.";
        }

        // Kiểm tra thông tin đăng nhập
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return "Chúc mừng bạn!";
        } else {
            return "Đăng nhập thất bại. Vui lòng kiểm tra lại tài khoản và mật khẩu.";
        }
    }

  
}
