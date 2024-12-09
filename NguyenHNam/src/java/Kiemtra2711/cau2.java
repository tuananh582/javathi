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
@Path("cau2")
public class cau2 {
    @Context
    private UriInfo context;
    
    public cau2() {
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String tinhTienNuoc(
            @QueryParam("chiSoDau") int chiSoDau,
            @QueryParam("chiSoCuoi") int chiSoCuoi) {
        
        if (chiSoCuoi < chiSoDau) {
            return "Chỉ số sau không được nhỏ hơn chỉ số trước.";
        }

        int soKhoi = chiSoCuoi - chiSoDau;
        double tienNuoc;

       
        if (soKhoi < 5) {
            tienNuoc = soKhoi * 10000;
        } else if (soKhoi >= 5 && soKhoi < 10) {
            tienNuoc = soKhoi * 15000;
        } else {
            tienNuoc = soKhoi * 20000;
        }

        
        return "Số khối nước tiêu thụ: " + soKhoi + " khối <br>" + 
               "Tiền nước phải trả: " + tienNuoc + " VNĐ";
    }
}
