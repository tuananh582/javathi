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

@Path("demKyTuVaChuHoa")
public class DemKyTuVaChuHoa {

    @Context
    private UriInfo context;

    public DemKyTuVaChuHoa() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String BienDoiChuoi(@QueryParam("Chuoi: ") String chuoi) {
        if (chuoi == null || chuoi.isEmpty()) {
            return "Vui lòng nhập chuỗi hợp lệ.";
        }
        
        // Đếm số ký tự 'n' (không phân biệt hoa thường)
        long soLuongKyTuN = chuoi.chars()
                                  .filter(ch -> ch == 'n' || ch == 'N')
                                  .count();
        
        String chuoiBienDoi = chuoi.trim().replaceAll("\\s+", " ").toUpperCase();
         return "Chuỗi in hoa và loại bỏ khoảng trắng: " + chuoiBienDoi + "<br>" +"Tổng số ký tự 'n': " + soLuongKyTuN;
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
