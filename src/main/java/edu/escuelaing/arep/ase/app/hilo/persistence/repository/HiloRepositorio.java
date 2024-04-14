package edu.escuelaing.arep.ase.app.hilo.persistence.repository;

import java.util.List;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.hilo.domain.Hilo;
import edu.escuelaing.arep.ase.app.hilo.persistence.dao.HiloDAO;
import edu.escuelaing.arep.ase.app.post.domain.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class HiloRepositorio {

    private HiloDAO hiloDAO;

    @Inject
    public HiloRepositorio(HiloDAO hiloDAO) {
        this.hiloDAO = hiloDAO;
    }

    public Hilo agregarHilo(Hilo hilo) throws TwitterException{
        return hiloDAO.agregarHilo(hilo);
    }

    public List<Hilo> consultarHilos(){
        return hiloDAO.consultarHilos();
    }

    public Hilo consultarHiloPorId(String id) throws TwitterException {
        return hiloDAO.consultarHiloPorId(id);
    }

    public void agregarPostAlHilo(String id, Post post) throws TwitterException  {
        hiloDAO.agregarPostAlHilo(id, post);
    }
    
}
