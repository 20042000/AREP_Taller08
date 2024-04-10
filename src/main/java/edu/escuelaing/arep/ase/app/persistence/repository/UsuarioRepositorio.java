package edu.escuelaing.arep.ase.app.persistence.repository;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.persistence.dao.UsuarioDAO;

public class UsuarioRepositorio {

    private UsuarioDAO usuarioDAO;

    public boolean agregarUsuario(Usuario usuario) throws TwitterException{
        return usuarioDAO.agregarUsuario(usuario);
    }

    
}