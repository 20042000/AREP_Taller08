package edu.escuelaing.arep.ase.app.usuario.service;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.usuario.domain.Usuario;


public interface UsuarioServicio {

    Usuario agregarUsuario(Usuario usuario) throws TwitterException;

    Usuario consultarUsuarioPorId(String usuario) throws TwitterException;

    String login(String login) throws TwitterException;
    
}
