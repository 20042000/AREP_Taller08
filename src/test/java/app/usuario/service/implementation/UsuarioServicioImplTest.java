package app.usuario.service.implementation;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.usuario.domain.Usuario;
import edu.escuelaing.arep.ase.app.usuario.persistence.repository.UsuarioRepositorio;
import edu.escuelaing.arep.ase.app.usuario.service.implementation.UsuarioServicioImpl;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServicioImplTest {

    private UsuarioServicioImpl usuarioServicio;
    private UsuarioRepositorio usuarioRepositorio;

    @BeforeEach
    void setUp() {
        usuarioRepositorio = mock(UsuarioRepositorio.class);
        usuarioServicio = new UsuarioServicioImpl(usuarioRepositorio);
    }

    @Test
    void givenUsuarioWhenAgregarUsuarioThenUsuarioIsAdded() throws TwitterException {
        Usuario usuario = new Usuario("Juan Perez", "JuanPerez");
        when(usuarioRepositorio.agregarUsuario(usuario)).thenReturn(usuario);
        Usuario resultado = usuarioServicio.agregarUsuario(usuario);
        verify(usuarioRepositorio, times(1)).agregarUsuario(usuario);
        assertEquals(usuario, resultado);
    }

    @Test
    void givenExistingUsuarioWhenAgregarUsuarioThenTwitterExceptionIsThrown() throws TwitterException {
        Usuario usuario = new Usuario("LuisaGiron", "LuisaGiron");
        when(usuarioRepositorio.agregarUsuario(usuario)).thenThrow(TwitterException.class);
        assertThrows(TwitterException.class, () -> usuarioServicio.agregarUsuario(usuario));
    }

    @Test
    void givenExistingUsuarioWhenConsultarUsuarioPorIdThenUsuarioIsReturned() throws TwitterException {
        Usuario usuario = new Usuario("Luisa Griron", "LuisaGiron");
        when(usuarioRepositorio.consultarUsuarioPorId("LuisaGiron")).thenReturn(usuario);
        Usuario resultado = usuarioServicio.consultarUsuarioPorId("LuisaGiron");
        verify(usuarioRepositorio, times(1)).consultarUsuarioPorId("LuisaGiron");
        assertEquals(usuario, resultado);
    }

    @Test
    void givenNonExistingUsuarioWhenConsultarUsuarioPorIdThenTwitterExceptionIsThrown() throws TwitterException {
        when(usuarioRepositorio.consultarUsuarioPorId("JuanPerez")).thenThrow(TwitterException.class);
        assertThrows(TwitterException.class, () -> usuarioServicio.consultarUsuarioPorId("JuanPerez"));
    }

    @Test
    void givenLoginWhenLoginThenTokenIsReturned() throws TwitterException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "LuisaGiron");
        jsonObject.put("password", "Luisa05-25");
        when(usuarioRepositorio.login("LuisaGiron", "Luisa05-25")).thenReturn(new Usuario("Luisa Griron", "LuisaGiron"));
        String token = usuarioServicio.login(jsonObject.toString());
        verify(usuarioRepositorio, times(1)).login("LuisaGiron", "Luisa05-25");
        assertNotNull(token);
    }

    @Test
    void givenNonExistingUsuarioWhenLoginThenTwitterExceptionIsThrown() throws TwitterException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "JuanPerez");
        jsonObject.put("password", "JuanPerez05-25");
        when(usuarioRepositorio.login("JuanPerez", "JuanPerez05-25")).thenThrow(TwitterException.class);
        assertThrows(TwitterException.class, () -> usuarioServicio.login(jsonObject.toString()));
    }
}