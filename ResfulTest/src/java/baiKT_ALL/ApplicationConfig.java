package baiKT_ALL;

import java.util.Set;

@jakarta.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends jakarta.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(baiKT_ALL.DemKyTuVaChuHoa.class);
        resources.add(baiKT_ALL.KiemTraDangNhap.class);
        resources.add(baiKT_ALL.KiemTraDiemHeSo.class);
        resources.add(baiKT_ALL.TinhTienNuoc.class);
        resources.add(baiKT_ALL.ktraDiemSV.class);
    }
    
}
