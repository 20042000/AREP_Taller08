package edu.escuelaing.arep.ase.app.persistence.repository;

import edu.escuelaing.arep.ase.app.domain.Hilo;
import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.persistence.dao.HiloDAO;

public class HiloRepositorio {

    private HiloDAO hiloDAO;

    public Hilo agregarHilo(Hilo hilo) throws TwitterException{
        if(hiloDAO.getHilos().containsKey(hilo.getId()) || hilo.getId() == null){
            throw new TwitterException("El hilo ya existe o el id es nulo");
        }
        hiloDAO.getHilos().put(hilo.getId(), hilo);
        return hilo;
    }
    
}
