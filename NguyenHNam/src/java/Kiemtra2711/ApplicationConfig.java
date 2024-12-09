package Kiemtra2711;
import java.util.Set;
import jakarta.ws.rs.core.Application;
/**
 *
 * @author NAM PC
 */
@jakarta.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Kiemtra2711.cau1.class);
        resources.add(Kiemtra2711.cau2.class);
        resources.add(Kiemtra2711.cau3.class);
    }
    
}