package app.post.domain;

import edu.escuelaing.arep.ase.app.post.domain.Post;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostTest {

    @Test
    void givenUsuarioWhenCreatingPostThenUsuarioIsSet() {
        String usuario = "LuisaGiron";
        Post post = new Post(usuario, "Hola mundo");
        assertEquals(usuario, post.getUsuario());
    }

    @Test
    void givenComentarioWhenCreatingPostThenComentarioIsSet() {
        String comentario = "Hola mundo";
        Post post = new Post("LuisaGiron", comentario);
        assertEquals(comentario, post.getComentario());
    }

    @Test
    void givenPostWhenSettingUsuarioThenUsuarioIsSet() {
        Post post = new Post(null, "Comentario");
        String usuario = "LuisaGiron";
        post.setUsuario(usuario);
        assertEquals(usuario, post.getUsuario());
    }

    @Test
    void givenPostWhenSettingComentarioThenComentarioIsSet() {
        Post post = new Post("LuisaGiron", null);
        String comentario = "Hola mundo";
        post.setComentario(comentario);
        assertEquals(comentario, post.getComentario());
    }
}
