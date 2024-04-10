package edu.escuelaing.arep.ase.app.service;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import edu.escuelaing.arep.ase.app.exception.TwitterException;

public interface UsuarioServicio {

    boolean agregarUsuario(Usuario usuario) throws TwitterException;
    
}
