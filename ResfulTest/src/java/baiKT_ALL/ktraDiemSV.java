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


@Path("KtraDiem")
public class ktraDiemSV {

    @Context
    private UriInfo context;

    public ktraDiemSV() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String KiemTraThiDo(
            @QueryParam("diem 1:") double  diem1,
            @QueryParam("diem 2:") double  diem2,
            @QueryParam("diem 3:") double  diem3) {
        
        if (diem1 < 0 || diem2 < 0 || diem3 < 0) 
        {
            return "Diem khong hop le. Vui long nhap lai !";
        }
        
        double tongDiem = diem1 + diem2 + diem3;
        
        if(tongDiem >= 20)
            return "Sinh vien thi do. Tong diem: "+tongDiem;
        else
            return "Sinh vien thi truot. Tong diem: "+tongDiem;
    }

  
}
