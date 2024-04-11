package edu.escuelaing.arep.ase.app.controller;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import edu.escuelaing.arep.ase.app.service.UsuarioServicio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
@ApplicationScoped
public class UsuarioController {

    private UsuarioServicio usuarioServicio;

    @Inject
    public UsuarioController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarUsuario(Usuario usuario) {
        try {
            return Response.status(200).entity(usuarioServicio.agregarUsuario(usuario)).build();
        } catch (Exception e) {
            return Response.status(403).entity(e.getMessage()).build();
        }
        
    }

    @GET
    @Path("/{usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarUsuarioPorId(String usuario){
        try{
            return Response.status(200).entity(usuarioServicio.consultarUsuarioPorId(usuario)).build();
        }catch(Exception e){
            return Response.status(403).entity(e.getMessage()).build();
        }
    }


    
}
