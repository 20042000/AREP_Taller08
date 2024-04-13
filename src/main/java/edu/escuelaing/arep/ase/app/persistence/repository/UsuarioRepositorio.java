package edu.escuelaing.arep.ase.app.persistence.repository;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.persistence.dao.LoginDAO;
import edu.escuelaing.arep.ase.app.persistence.dao.UsuarioDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioRepositorio {

    private UsuarioDAO usuarioDAO;
    private LoginDAO loginDAO;

    @Inject
    public UsuarioRepositorio(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario agregarUsuario(Usuario usuario) throws TwitterException{
        return usuarioDAO.agregarUsuario(usuario);
    }

    public Usuario consultarUsuarioPorId(String usuario) throws TwitterException {
        return usuarioDAO.consultarUsuarioPorId(usuario);
    }

    public Usuario login(String usuario, String contrasena) throws TwitterException {
        if(!loginDAO.existeUsuario(usuario, contrasena)){
            throw new TwitterException("El usuario o la contraseña son incorrectos");
        } 
        return usuarioDAO.consultarUsuarioPorId(usuario);       

    }

    
}
