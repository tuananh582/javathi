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

@Path("TinhTienNuoc")
public class TinhTienNuoc {

    @Context
    private UriInfo context;

    public TinhTienNuoc() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
      public String TinhTienNuoc(
        @QueryParam("chiSoTruoc") double chiSoTruoc,
        @QueryParam("chiSoSau") double chiSoSau) {
        
        // Kiểm tra tính hợp lệ của chỉ số
        if (chiSoTruoc < 0 || chiSoSau < 0 || chiSoSau < chiSoTruoc) {
            return "Chỉ số không hợp lệ. Vui lòng nhập lại!";
        }

        // Tính số khối nước tiêu thụ
        double soKhoiNuoc = chiSoSau - chiSoTruoc;
        double tienNuoc = 0;

        // Tính tiền nước dựa trên quy định giá
        if (soKhoiNuoc < 5) {
            tienNuoc = soKhoiNuoc * 10000;
        } else if (soKhoiNuoc < 10) {
            tienNuoc = 5 * 10000 + (soKhoiNuoc - 5) * 15000;
        } else {
            tienNuoc = 5 * 10000 + 5 * 15000 + (soKhoiNuoc - 10) * 20000;
        }

        // Trả về kết quả
        return "Số khối nước tiêu thụ: " + soKhoiNuoc + " khối. Tiền nước: " + tienNuoc + " VNĐ.";
    }

}
