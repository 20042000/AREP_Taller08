package edu.escuelaing.arep.ase.app.usuario.service.implementation;

import org.json.JSONObject;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.usuario.domain.Usuario;
import edu.escuelaing.arep.ase.app.usuario.persistence.repository.UsuarioRepositorio;
import edu.escuelaing.arep.ase.app.usuario.service.UsuarioServicio;
import edu.escuelaing.arep.ase.app.usuario.util.GenerateToken;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioServicioImpl implements UsuarioServicio{

    private UsuarioRepositorio usuarioRepositorio;


    @Inject
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    @Override
    public Usuario agregarUsuario(Usuario usuario) throws TwitterException {
        return usuarioRepositorio.agregarUsuario(usuario);
    }

    @Override
    public Usuario consultarUsuarioPorId(String usuario) throws TwitterException {
        return usuarioRepositorio.consultarUsuarioPorId(usuario);
    }

    @Override
    public String login(String login) throws TwitterException {
        JSONObject objetoJson = new JSONObject(login);
        String usuario = objetoJson.getString("username");
        String contrasena = objetoJson.getString("password");
        Usuario usuarioRepo = usuarioRepositorio.login(usuario, contrasena);
        return GenerateToken.createJWT(usuarioRepo, 3600);
    }
}
