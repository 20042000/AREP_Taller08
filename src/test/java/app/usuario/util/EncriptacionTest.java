package app.usuario.util;

import edu.escuelaing.arep.ase.app.usuario.util.Encriptacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EncriptacionTest {

    @Test
    void givenStringWhenHashStringThenHashIsReturned() {
        Encriptacion encriptacion = new Encriptacion();
        String originalString = "Luisa05-25";
        String hashString = encriptacion.hashString(originalString);
        assertNotNull(hashString);
    }

    @Test
    void givenEmptyStringWhenHashStringThenHashIsReturned() {
        Encriptacion encriptacion = new Encriptacion();
        String originalString = "";
        String hashString = encriptacion.hashString(originalString);
        assertNotNull(hashString);
    }
}