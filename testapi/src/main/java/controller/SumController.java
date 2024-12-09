/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author admin
 */
import thu.SumModel;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("/sum")
public class SumController {
    
    private final SumModel sumModel = new SumModel();

    // HTTP GET Method
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSum(@QueryParam("a") int a, @QueryParam("b") int b) {
        int result = sumModel.calculateSum(a, b);
        return "Sum (GET): " + result;
    }

    // HTTP POST Method
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String postSum(@FormParam("a") int a, @FormParam("b") int b) {
        int result = sumModel.calculateSum(a, b);
        return "Sum (POST): " + result;
    }
}
