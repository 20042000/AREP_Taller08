package edu.escuelaing.arep.ase.app.persistence.repository;

import java.util.List;

import edu.escuelaing.arep.ase.app.domain.Hilo;
import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.persistence.dao.HiloDAO;
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
    
}
