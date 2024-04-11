package edu.escuelaing.arep.ase.app.persistence.dao;

import java.util.Map;


import edu.escuelaing.arep.ase.app.domain.Usuario;
import edu.escuelaing.arep.ase.app.exception.TwitterException;

public class UsuarioDAO {

    private Map<String,Usuario> usuarios;
 
    public Usuario agregarUsuario(Usuario usuario) throws TwitterException{
        if(usuarios.containsKey(usuario.getUsuario()) || usuario.getUsuario() == null){
            throw new TwitterException("El usuario ya existe o el id es nulo");
        }
        return usuarios.put(usuario.getUsuario(), usuario);
    }

    public Usuario consultarUsuarioPorId(String usuario) throws TwitterException {
        if (!usuarios.containsKey(usuario)) {
            throw new TwitterException("El usuario no existe");
        }
        return usuarios.get(usuario);
    }
    
}
