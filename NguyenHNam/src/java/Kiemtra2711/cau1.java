package Kiemtra2711;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
/**
 *
 * @author NAM PC
 */
@Path("cau1")
public class cau1 {
    @Context
    private UriInfo context;
    
    public cau1() {
    }
    private final String USERNAME = "admin";
    private final String PASSWORD = "123456";
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String checkLogin(@QueryParam("username") String username,@QueryParam("password") String password)            
    {
        if (username == null || password == null) {
            return "Vui lòng nhập tài khoản và mật khẩu.";
        }
        
        
        if (USERNAME.equals(username.trim()) && PASSWORD.equals(password.trim())) {
            return "Chúc mừng bạn đăng nhập thành công!";
        } else {
            return "Đăng nhập thất bại.";
        }
    }
}
