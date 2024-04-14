package app.usuario.persistence.dao;

import edu.escuelaing.arep.ase.app.usuario.persistence.dao.LoginDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginDAOTest {

    private LoginDAO loginDAO;

    @BeforeEach
    void setUp() {
        loginDAO = new LoginDAO();
    }

    @Test
    void givenExistingUserAndPasswordWhenExisteUsuarioThenTrueIsReturned() {
        assertTrue(loginDAO.existeUsuario("LuisaGiron", "Luisa05-25"));
    }

    @Test
    void givenNonExistingUserWhenExisteUsuarioThenFalseIsReturned() {
        assertFalse(loginDAO.existeUsuario("JuanPerez", "JuanPerez05-25"));
    }

    @Test
    void givenExistingUserAndWrongPasswordWhenExisteUsuarioThenFalseIsReturned() {
        assertFalse(loginDAO.existeUsuario("LuisaGiron", "Luisa05-26"));
    }
}