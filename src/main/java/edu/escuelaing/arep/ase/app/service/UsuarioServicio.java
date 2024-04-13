package edu.escuelaing.arep.ase.app.service;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import edu.escuelaing.arep.ase.app.exception.TwitterException;


public interface UsuarioServicio {

    Usuario agregarUsuario(Usuario usuario) throws TwitterException;

    Usuario consultarUsuarioPorId(String usuario) throws TwitterException;

    String login(String login) throws TwitterException;
    
}
