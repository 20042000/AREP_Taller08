package app.post.service.implementation;

import edu.escuelaing.arep.ase.app.post.domain.Post;
import edu.escuelaing.arep.ase.app.post.persistence.repository.PostRepositorio;
import edu.escuelaing.arep.ase.app.post.service.implementation.PostServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PostServicioImplTest {

    private PostServicioImpl postServicio;
    private PostRepositorio postRepositorio;

    @BeforeEach
    void setUp() {
        postRepositorio = mock(PostRepositorio.class);
        postServicio = new PostServicioImpl(postRepositorio);
    }

    @Test
    void givenPostWhenConsultarPostsThenPostIsReturned() {
        Post post = new Post("LuisaGiron", "Hola mundo");
        when(postRepositorio.consultarPosts()).thenReturn(List.of(post));
        List<Post> resultado = postServicio.consultarPosts();
        verify(postRepositorio, times(1)).consultarPosts();
        assertEquals(1, resultado.size());
        assertEquals(post, resultado.get(0));
    }

    @Test
    void givenEmptyPostDAOWhenConsultarPostsThenEmptyListIsReturned() {
        when(postRepositorio.consultarPosts()).thenReturn(List.of());
        List<Post> resultado = postServicio.consultarPosts();
        verify(postRepositorio, times(1)).consultarPosts();
        assertEquals(0, resultado.size());
    }
}