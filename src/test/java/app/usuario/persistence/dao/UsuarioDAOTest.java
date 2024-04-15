package app.usuario.persistence.dao;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.usuario.domain.Usuario;
import edu.escuelaing.arep.ase.app.usuario.persistence.dao.UsuarioDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDAOTest {

    private UsuarioDAO usuarioDAO;

    @BeforeEach
    void setUp() {
        usuarioDAO = new UsuarioDAO();
    }


    @Test
    void givenExistingUsuarioWhenAgregarUsuarioThenTwitterExceptionIsThrown() {
        Usuario usuario = new Usuario("Luisa Giron", "LuisaGiron");
        assertThrows(TwitterException.class, () -> usuarioDAO.agregarUsuario(usuario));
    }

    @Test
    void givenNullUsuarioWhenAgregarUsuarioThenTwitterExceptionIsThrown() {
        Usuario usuario = new Usuario("Luisa Giron", "LuisaGiron");
        assertThrows(TwitterException.class, () -> usuarioDAO.agregarUsuario(usuario));
    }

    @Test
    void givenNonExistingUsuarioWhenConsultarUsuarioPorIdThenTwitterExceptionIsThrown() {
        assertThrows(TwitterException.class, () -> usuarioDAO.consultarUsuarioPorId("JuanPerez"));
    }
}