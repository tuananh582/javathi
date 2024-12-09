/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sum;

/**
 *
 * @author admin
 */
import controller.SumController;
import model.SumRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/sum")
public class SumService {
      private final SumController controller = new SumController();

    @GET
    @Path("/calculate")
    @Produces(MediaType.TEXT_PLAIN)
    public Response calculateSumGet(@QueryParam("a") int a, @QueryParam("b") int b) {
        SumRequest request = new SumRequest(a, b);
        int sum = controller.calculateSum(request);
        return Response.ok("Sum (GET): " + sum).build();
    }

    @POST
    @Path("/calculate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response calculateSumPost(SumRequest request) {
        int sum = controller.calculateSum(request);
        return Response.ok("Sum (POST): " + sum).build();
    }
}
