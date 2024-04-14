package app.hilo.domain;

import edu.escuelaing.arep.ase.app.post.domain.Post;
import edu.escuelaing.arep.ase.app.hilo.domain.Hilo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HiloTest {

    private Hilo hilo;

    @BeforeEach
    public void setUp() {
        hilo = new Hilo("1", "usuario1", new ArrayList<>());
    }

    @Test
    public void testAgregarPost() {
        Post post1 = new Post("usuario1", "contenido1");
        Post post2 = new Post("usuario2", "contenido2");
        hilo.agregarPost(post1);
        hilo.agregarPost(post2);
        Collection<Post> postsEsperados = Arrays.asList(post1, post2);
        assertEquals(postsEsperados, hilo.getPosts());
    }

    @Test
    public void testGetId() {
        assertEquals("1", hilo.getId());
    }

    @Test
    public void testGetUsuarioCreador() {
        assertEquals("usuario1", hilo.getUsuarioCreador());
    }
}
