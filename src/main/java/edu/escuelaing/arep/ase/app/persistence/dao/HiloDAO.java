package edu.escuelaing.arep.ase.app.persistence.dao;

import java.util.HashMap;
import java.util.List;
import edu.escuelaing.arep.ase.app.domain.Hilo;
import edu.escuelaing.arep.ase.app.exception.TwitterException;


public class HiloDAO {
    
    private HashMap<String, Hilo> hilos;

    public Hilo agregarHilo(Hilo hilo) throws TwitterException {
        if(hilos.containsKey(hilo.getId()) || hilo.getId() == null){
            throw new TwitterException("El hilo ya existe o el id es nulo");
        }
        return hilos.put(hilo.getId(), hilo);
    }

    public List<Hilo> consultarHilos(){
        return  hilos.values().stream().toList();
    }

    public Hilo consultarHiloPorId(String id) throws TwitterException {
        if (!hilos.containsKey(id)) {
            throw new TwitterException("El hilo no existe");
            
        }
        return hilos.get(id);
    }
}
