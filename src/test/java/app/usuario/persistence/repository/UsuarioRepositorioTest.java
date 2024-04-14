package app.usuario.persistence.repository;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.usuario.domain.Usuario;
import edu.escuelaing.arep.ase.app.usuario.persistence.dao.LoginDAO;
import edu.escuelaing.arep.ase.app.usuario.persistence.dao.UsuarioDAO;
import edu.escuelaing.arep.ase.app.usuario.persistence.repository.UsuarioRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UsuarioRepositorioTest {

    private UsuarioRepositorio usuarioRepositorio;
    private UsuarioDAO usuarioDAO;
    private LoginDAO loginDAO;

    @BeforeEach
    void setUp() {
        usuarioDAO = mock(UsuarioDAO.class);
        loginDAO = mock(LoginDAO.class);
        usuarioRepositorio = new UsuarioRepositorio(usuarioDAO);
    }

    @Test
    void givenUsuarioWhenAgregarUsuarioThenUsuarioIsAdded() throws TwitterException {
        Usuario usuario = new Usuario("Juan Perez", "JuanPerez");
        when(usuarioDAO.agregarUsuario(usuario)).thenReturn(usuario);
        Usuario resultado = usuarioRepositorio.agregarUsuario(usuario);
        verify(usuarioDAO, times(1)).agregarUsuario(usuario);
        assertEquals(usuario, resultado);
    }

    @Test
    void givenExistingUsuarioWhenAgregarUsuarioThenTwitterExceptionIsThrown() throws TwitterException {
        Usuario usuario = new Usuario("LuisaGiron", "LuisaGiron");
        when(usuarioDAO.agregarUsuario(usuario)).thenThrow(TwitterException.class);
        assertThrows(TwitterException.class, () -> usuarioRepositorio.agregarUsuario(usuario));
    }
}