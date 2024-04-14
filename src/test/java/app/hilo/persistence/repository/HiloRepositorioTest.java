package app.hilo.persistence.repository;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.hilo.domain.Hilo;
import edu.escuelaing.arep.ase.app.hilo.persistence.dao.HiloDAO;
import edu.escuelaing.arep.ase.app.hilo.persistence.repository.HiloRepositorio;
import edu.escuelaing.arep.ase.app.post.domain.Post;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class HiloRepositorioTest {

    private HiloRepositorio hiloRepositorio;
    private HiloDAO hiloDAO;

    @BeforeEach
    void setUp() {
        hiloDAO = mock(HiloDAO.class);
        hiloRepositorio = new HiloRepositorio(hiloDAO);
    }

    @Test
    void givenHiloWhenAgregarHiloThenHiloIsAdded() throws TwitterException {
        Hilo hilo = new Hilo("2", "JuanPerez", new ArrayList<>());
        when(hiloDAO.agregarHilo(hilo)).thenReturn(hilo);
        Hilo resultado = hiloRepositorio.agregarHilo(hilo);
        verify(hiloDAO, times(1)).agregarHilo(hilo);
        assertEquals(hilo, resultado);
    }

    @Test
    void givenHiloWhenConsultarHilosThenHiloIsReturned() {
        List<Hilo> hilos = new ArrayList<>();
        hilos.add(new Hilo("1", "LuisaGiron", new ArrayList<>()));
        when(hiloDAO.consultarHilos()).thenReturn(hilos);
        List<Hilo> resultado = hiloRepositorio.consultarHilos();
        verify(hiloDAO, times(1)).consultarHilos();
        assertEquals(hilos, resultado);
    }

    @Test
    void givenIdWhenConsultarHiloPorIdThenHiloIsReturned() throws TwitterException {
        Hilo hilo = new Hilo("1", "LuisaGiron", new ArrayList<>());
        when(hiloDAO.consultarHiloPorId("1")).thenReturn(hilo);
        Hilo resultado = hiloRepositorio.consultarHiloPorId("1");
        verify(hiloDAO, times(1)).consultarHiloPorId("1");
        assertEquals(hilo, resultado);
    }

    @Test
    void givenIdWhenConsultarHiloPorIdThenTwitterExceptionIsThrown() throws TwitterException {
        when(hiloDAO.consultarHiloPorId("2")).thenThrow(TwitterException.class);
        assertThrows(TwitterException.class, () -> hiloRepositorio.consultarHiloPorId("2"));
    }

    @Test
    void givenIdAndPostWhenAgregarPostAlHiloThenPostIsAdded() throws TwitterException {
        Post post = new Post("LuisaGiron", "Hola mundo");
        hiloRepositorio.agregarPostAlHilo("1", post);
        verify(hiloDAO, times(1)).agregarPostAlHilo("1", post);
    }

    @Test
    void givenIdAndPostWhenAgregarPostAlHiloThenTwitterExceptionIsThrown() throws TwitterException {
        Post post = new Post("LuisaGiron", "Hola mundo");
        doThrow(TwitterException.class).when(hiloDAO).agregarPostAlHilo("2", post);
        assertThrows(TwitterException.class, () -> hiloRepositorio.agregarPostAlHilo("2", post));
    }
}