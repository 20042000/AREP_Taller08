package app.hilo.persistence.dao;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.hilo.domain.Hilo;
import edu.escuelaing.arep.ase.app.hilo.persistence.dao.HiloDAO;
import edu.escuelaing.arep.ase.app.post.domain.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class HiloDAOTest {

    private HiloDAO hiloDAO;

    @BeforeEach
    void setUp() {
        hiloDAO = new HiloDAO();
    }

    @Test
    void givenHiloWhenAgregarHiloThenHiloIsAdded() throws TwitterException {
        Hilo hilo = new Hilo("2", "JuanPerez", new ArrayList<>());
        hiloDAO.agregarHilo(hilo);
        assertTrue(hiloDAO.consultarHilos().contains(hilo));
    }

    @Test
    void givenHiloWhenConsultarHilosThenHiloIsReturned() {
        Hilo hilo = hiloDAO.consultarHilos().get(0);
        assertEquals("1", hilo.getId());
        assertEquals("LuisaGiron", hilo.getUsuarioCreador());
    }

    @Test
    void givenIdWhenConsultarHiloPorIdThenHiloIsReturned() throws TwitterException {
        Hilo hilo = hiloDAO.consultarHiloPorId("1");
        assertEquals("1", hilo.getId());
        assertEquals("LuisaGiron", hilo.getUsuarioCreador());
    }

    @Test
    void givenIdWhenConsultarHiloPorIdThenTwitterExceptionIsThrown() {
        try {
            hiloDAO.consultarHiloPorId("2");
            fail("Did not throw exception");
        } catch (TwitterException e) {
            assertEquals("El hilo no existe", e.getMessage());
        }
    }

    @Test
    void givenIdAndPostWhenAgregarPostAlHiloThenPostIsAdded() throws TwitterException {
        Post post = new Post("LuisaGiron", "Hola mundo");
        hiloDAO.agregarPostAlHilo("1", post);
        Hilo hilo = hiloDAO.consultarHiloPorId("1");
        assertTrue(hilo.getPosts().contains(post));
    }

    @Test
    void givenIdAndPostWhenAgregarPostAlHiloThenTwitterExceptionIsThrown() {
        Post post = new Post("LuisaGiron", "Hola mundo");
        try {
            hiloDAO.agregarPostAlHilo("2", post);
            fail("Did not throw exception");
        } catch (TwitterException e) {
            assertEquals("El hilo no existe", e.getMessage());
        }
    }
}