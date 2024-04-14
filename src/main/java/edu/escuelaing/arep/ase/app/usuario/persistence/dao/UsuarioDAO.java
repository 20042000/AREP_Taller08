package edu.escuelaing.arep.ase.app.usuario.persistence.dao;

import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.usuario.domain.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDAO {

    private Map<String,Usuario> usuarios;

    public UsuarioDAO() {
        usuarios = new HashMap<>();
        usuarios.put("LuisaGiron", new Usuario("Luisa Griron", "LuisaGiron"));
        usuarios.put("FelipeLadino", new Usuario("Felipe Ladino", "FelipeLadino"));
        usuarios.put("DanielaLadino", new Usuario("Danie laLadino", "DanielaLadino"));
    }

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
