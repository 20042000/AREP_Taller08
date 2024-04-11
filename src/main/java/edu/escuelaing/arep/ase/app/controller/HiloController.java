package edu.escuelaing.arep.ase.app.controller;

import edu.escuelaing.arep.ase.app.domain.Hilo;
import edu.escuelaing.arep.ase.app.service.HiloServicio;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hilo")
@RequestScoped
public class HiloController {

    private HiloServicio hiloServicio;

    @Inject
    public HiloController(HiloServicio hiloServicio) {
        this.hiloServicio = hiloServicio;
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarHilo(Hilo hilo) {
        try {
            return Response.status(200).entity(hiloServicio.agregarHilo(hilo)).build();
        } catch (Exception e) {
            return Response.status(403).entity(e.getMessage()).build();
        }
        
    }

    @GET
    @Path("/hilos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarHilos(){
        try{
            return Response.status(200).entity(hiloServicio.consultarHilos()).build();
        }catch(Exception e){
            return Response.status(403).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/hilo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarHiloPorId(String id){
        try{
            return Response.status(200).entity(hiloServicio.consultarHiloPorId(id)).build();
        }catch(Exception e){
            return Response.status(403).entity(e.getMessage()).build();
        }
    }



    
}
