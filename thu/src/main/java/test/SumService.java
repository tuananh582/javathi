/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author admin
 */
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("/sum")
public class SumService {
     @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSum(@QueryParam("a") int a, @QueryParam("b") int b) {
        int sum = a + b;
        return "{\"sum\": " + sum + "}";
    }

    // Phương thức HTTP POST
    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postSum(String input) {
        // Phân tích chuỗi JSON
        String[] params = input.split("&");
        int a = Integer.parseInt(params[0].split("=")[1]);
        int b = Integer.parseInt(params[1].split("=")[1]);
        int sum = a + b;
        return "{\"sum\": " + sum + "}";
    }
}
