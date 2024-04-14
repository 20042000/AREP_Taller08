package edu.escuelaing.arep.ase.app.hilo.service;

import java.util.List;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.hilo.domain.Hilo;
import edu.escuelaing.arep.ase.app.post.domain.Post;

public interface HiloServicio {

    Hilo agregarHilo(Hilo hilo) throws TwitterException;

    List<Hilo> consultarHilos();

    Hilo consultarHiloPorId(String id) throws TwitterException;

    void agregarPostAlHilo(String id, Post post) throws TwitterException;
    
}
