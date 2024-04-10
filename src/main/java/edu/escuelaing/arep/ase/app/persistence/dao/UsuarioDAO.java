package edu.escuelaing.arep.ase.app.persistence.dao;

import java.util.Set;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import edu.escuelaing.arep.ase.app.exception.TwitterException;

public class UsuarioDAO {

    private Set<Usuario> usuarios;
 
    public boolean agregarUsuario(Usuario usuario) throws TwitterException{
        if(usuarios.contains(usuario) || usuario.getUsuario() == null){
            throw new TwitterException("El usuario ya existe o el id es nulo");
        }
        return usuarios.add(usuario);
    }
    
}
