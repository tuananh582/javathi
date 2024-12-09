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
@Path("cau3")
public class cau3 {
     @Context
    private UriInfo context;
    
    public cau3() {  
    }
     @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String xuLyChuoi(@QueryParam("chuoi") String chuoi) {
        if (chuoi == null || chuoi.isEmpty()) {
            return "Vui lòng nhập chuỗi hợp lệ.";
        }
       
        String chuoiInHoa = chuoi.toUpperCase();
     
        long soLanXuatHienN = chuoi.chars()
                                   .filter(ch -> ch == 'n' || ch == 'N')
                                   .count();
     
        return "Chuỗi sau khi chuyển thành chữ in hoa: " + chuoiInHoa + "<br>" +
               "Số lần ký tự 'n' xuất hiện: " + soLanXuatHienN;
    }
}
