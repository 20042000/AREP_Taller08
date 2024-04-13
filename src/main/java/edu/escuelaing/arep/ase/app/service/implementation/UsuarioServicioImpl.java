package edu.escuelaing.arep.ase.app.service.implementation;

import org.json.JSONObject;

import edu.escuelaing.arep.ase.app.domain.Usuario;
import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.persistence.repository.UsuarioRepositorio;
import edu.escuelaing.arep.ase.app.service.UsuarioServicio;
import edu.escuelaing.arep.ase.app.util.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioServicioImpl implements UsuarioServicio{

    private UsuarioRepositorio usuarioRepositorio;

    private Jwt jwt;


    @Inject
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        jwt = Jwt.getInstance();
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
        return jwt.createJWT(usuarioRepo, 3600000);
    }
}
