package edu.escuelaing.arep.ase.app.hilo.service.implentacion;

import java.util.List;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.hilo.domain.Hilo;
import edu.escuelaing.arep.ase.app.hilo.persistence.repository.HiloRepositorio;
import edu.escuelaing.arep.ase.app.hilo.service.HiloServicio;
import edu.escuelaing.arep.ase.app.post.domain.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HiloServicioImpl implements HiloServicio{

    private HiloRepositorio hiloRepositorio;

    @Inject
    public HiloServicioImpl(HiloRepositorio hiloRepositorio) {
        this.hiloRepositorio = hiloRepositorio;
    }

    @Override
    public Hilo agregarHilo(Hilo hilo) throws TwitterException {
        return hiloRepositorio.agregarHilo(hilo);
    }

    @Override
    public List<Hilo> consultarHilos(){
        return hiloRepositorio.consultarHilos();
    }

    @Override
    public Hilo consultarHiloPorId(String id) throws TwitterException {
        return hiloRepositorio.consultarHiloPorId(id);
    }

    @Override
    public void agregarPostAlHilo(String id, Post post) throws TwitterException {
        if(post.getComentario().length() > 140){
            throw new TwitterException("El comentario excede los 140 caracteres");
        }
        hiloRepositorio.agregarPostAlHilo(id, post);
    }
    
}
