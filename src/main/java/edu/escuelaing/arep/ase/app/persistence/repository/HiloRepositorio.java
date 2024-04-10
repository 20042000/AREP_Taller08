package edu.escuelaing.arep.ase.app.persistence.repository;

import edu.escuelaing.arep.ase.app.domain.Hilo;
import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.persistence.dao.HiloDAO;

public class HiloRepositorio {

    private HiloDAO hiloDAO;

    public Hilo agregarHilo(Hilo hilo) throws TwitterException{
        return hiloDAO.agregarHilo(hilo);
    }
    
}
