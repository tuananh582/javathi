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

@Path("KiemTraDiemHeSo")
public class KiemTraDiemHeSo {

    @Context
    private UriInfo context;

    public KiemTraDiemHeSo() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
     public String KiemTraThiDauHeSo(
        @QueryParam("diem 1") double diem1, 
        @QueryParam("diem 2") double diem2, 
        @QueryParam("diem 3") double diem3) {
        
        // Kiểm tra tính hợp lệ của các điểm
        if (diem1 < 0 || diem2 < 0 || diem3 < 0) {
            return "Điểm không hợp lệ. Vui lòng nhập lại!";
        }

        // Tính tổng điểm với hệ số
        double tongDiem = diem1 * 2 + diem2 + diem3 * 2;

        // Kiểm tra kết quả
        if (tongDiem >= 30) {
            return "Đỗ. Tổng điểm: " + tongDiem;
        } else {
            return "Trượt. Tổng điểm: " + tongDiem;
        }
    }

}
