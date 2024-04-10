package edu.escuelaing.arep.ase.app.controller;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import edu.escuelaing.arep.ase.app.service.UsuarioServicio;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
@RequestScoped
public class UsuarioController {

    private UsuarioServicio usurioServicio;

    @Inject
    public UsuarioController(UsuarioServicio usurioServicio) {
        this.usurioServicio = usurioServicio;
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
    
}
