package edu.escuelaing.arep.ase.app.service;

import java.util.List;
import edu.escuelaing.arep.ase.app.domain.Hilo;
import edu.escuelaing.arep.ase.app.domain.Post;
import edu.escuelaing.arep.ase.app.exception.TwitterException;

public interface HiloServicio {

    Hilo agregarHilo(Hilo hilo) throws TwitterException;

    List<Hilo> consultarHilos();

    Hilo consultarHiloPorId(String id) throws TwitterException;

    void agregarPostAlHilo(String id, Post post) throws TwitterException;
    
}
