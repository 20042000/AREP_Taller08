package edu.escuelaing.arep.ase.app.service;

import edu.escuelaing.arep.ase.app.domain.Hilo;
import edu.escuelaing.arep.ase.app.exception.TwitterException;

public interface HiloServicio {

    Hilo agregarHilo(Hilo hilo) throws TwitterException;
    
}
