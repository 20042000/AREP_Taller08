package edu.escuelaing.arep.ase.app.controller;

import edu.escuelaing.arep.ase.app.domain.Post;
import edu.escuelaing.arep.ase.app.service.PostServicio;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/post")
@RequestScoped
public class PostController {

    private PostServicio postServicio;

    @Inject
    public PostController(PostServicio postServicio) {
        this.postServicio = postServicio;
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarPost(Post post) {
        try {
            return Response.status(200).entity(postServicio.agregarPost(post)).build();
        } catch (Exception e) {
            return Response.status(403).entity(e.getMessage()).build();
        }
        
    }
    
}
