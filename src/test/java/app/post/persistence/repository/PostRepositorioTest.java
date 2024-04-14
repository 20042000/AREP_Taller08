package app.post.persistence.repository;

import edu.escuelaing.arep.ase.app.post.domain.Post;
import edu.escuelaing.arep.ase.app.post.persistence.dao.PostDAO;
import edu.escuelaing.arep.ase.app.post.persistence.repository.PostRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PostRepositorioTest {

    private PostRepositorio postRepositorio;
    private PostDAO postDAO;

    @BeforeEach
    void setUp() {
        postDAO = mock(PostDAO.class);
        postRepositorio = new PostRepositorio(postDAO);
    }

    @Test
    void givenPostWhenConsultarPostsThenPostIsReturned() {
        Post post = new Post("LuisaGiron", "Hola mundo");
        when(postDAO.consultarPosts()).thenReturn(List.of(post));
        List<Post> resultado = postRepositorio.consultarPosts();
        verify(postDAO, times(1)).consultarPosts();
        assertEquals(1, resultado.size());
        assertEquals(post, resultado.get(0));
    }

    @Test
    void givenEmptyPostDAOWhenConsultarPostsThenEmptyListIsReturned() {
        when(postDAO.consultarPosts()).thenReturn(List.of());
        List<Post> resultado = postRepositorio.consultarPosts();
        verify(postDAO, times(1)).consultarPosts();
        assertEquals(0, resultado.size());
    }
}