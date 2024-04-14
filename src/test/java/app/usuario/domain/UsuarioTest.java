package app.usuario.domain;

import edu.escuelaing.arep.ase.app.usuario.domain.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioTest {

    @Test
    void givenNombreWhenCreatingUsuarioThenNombreIsSet() {
        String nombre = "LuisaGiron";
        Usuario usuario = new Usuario(nombre, "LuisaGiron");
        assertEquals(nombre, usuario.getNombre());
    }

    @Test
    void givenUsuarioWhenCreatingUsuarioThenUsuarioIsSet() {
        String usuario = "LuisaGiron";
        Usuario usuarioObj = new Usuario("LuisaGiron", usuario);
        assertEquals(usuario, usuarioObj.getUsuario());
    }

    @Test
    void givenUsuarioWhenSettingNombreThenNombreIsSet() {
        Usuario usuario = new Usuario(null, "LuisaGiron");
        String nombre = "Luisa Giron";
        usuario.setNombre(nombre);
        assertEquals(nombre, usuario.getNombre());
    }

    @Test
    void givenUsuarioWhenSettingUsuarioThenUsuarioIsSet() {
        Usuario usuario = new Usuario("Luisa Giron", null);
        String usuarioStr = "LuisaGiron";
        usuario.setUsuario(usuarioStr);
        assertEquals(usuarioStr, usuario.getUsuario());
    }
}