package edu.escuelaing.arep.ase.app.service.implementation;

import edu.escuelaing.arep.ase.app.domain.Hilo;
import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.persistence.repository.HiloRepositorio;
import edu.escuelaing.arep.ase.app.service.HiloServicio;
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
    
}