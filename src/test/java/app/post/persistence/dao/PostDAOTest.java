package app.post.persistence.dao;

import edu.escuelaing.arep.ase.app.post.domain.Post;
import edu.escuelaing.arep.ase.app.post.persistence.dao.PostDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostDAOTest {

    private PostDAO postDAO;

    @BeforeEach
    void setUp() {
        postDAO = new PostDAO();
    }


    @Test
    void givenEmptyPostDAOWhenConsultarPostsThenEmptyListIsReturned() {
        List<Post> resultado = postDAO.consultarPosts();
        assertEquals(0, resultado.size());
    }
}