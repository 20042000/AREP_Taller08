package app.usuario.util;

import edu.escuelaing.arep.ase.app.usuario.domain.Usuario;
import edu.escuelaing.arep.ase.app.usuario.util.GenerateToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class GenerateTokenTest {

    @Test
    void givenUsuarioWhenCreateJWTThenTokenIsReturned() {
        Usuario usuario = new Usuario("Luisa Griron", "LuisaGiron");
        String token = GenerateToken.createJWT(usuario, 3600);
        assertNotNull(token);
    }

}