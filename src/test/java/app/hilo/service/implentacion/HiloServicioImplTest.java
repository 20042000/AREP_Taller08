package app.hilo.service.implentacion;

import edu.escuelaing.arep.ase.app.exception.TwitterException;
import edu.escuelaing.arep.ase.app.hilo.domain.Hilo;
import edu.escuelaing.arep.ase.app.hilo.persistence.repository.HiloRepositorio;
import edu.escuelaing.arep.ase.app.hilo.service.HiloServicio;
import edu.escuelaing.arep.ase.app.hilo.service.implentacion.HiloServicioImpl;
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

class HiloServicioImplTest {

    private HiloServicioImpl hiloServicio;
    private HiloRepositorio hiloRepositorio;

    @BeforeEach
    void setUp() {
        hiloRepositorio = mock(HiloRepositorio.class);
        hiloServicio = new HiloServicioImpl(hiloRepositorio);
    }

    @Test
    void givenHiloWhenAgregarHiloThenHiloIsAdded() throws TwitterException {
        Hilo hilo = new Hilo("2", "LuisaGiron", new ArrayList<>());
        when(hiloRepositorio.agregarHilo(hilo)).thenReturn(hilo);
        Hilo resultado = hiloServicio.agregarHilo(hilo);
        verify(hiloRepositorio, times(1)).agregarHilo(hilo);
        assertEquals(hilo, resultado);
    }

    @Test
    void givenHiloWhenConsultarHilosThenHiloIsReturned() {
        List<Hilo> hilos = new ArrayList<>();
        hilos.add(new Hilo("1", "LuisaGiron", new ArrayList<>()));
        when(hiloRepositorio.consultarHilos()).thenReturn(hilos);
        List<Hilo> resultado = hiloServicio.consultarHilos();
        verify(hiloRepositorio, times(1)).consultarHilos();
        assertEquals(hilos, resultado);
    }

    @Test
    void givenIdWhenConsultarHiloPorIdThenHiloIsReturned() throws TwitterException {
        Hilo hilo = new Hilo("1", "LuisaGiron", new ArrayList<>());
        when(hiloRepositorio.consultarHiloPorId("1")).thenReturn(hilo);
        Hilo resultado = hiloServicio.consultarHiloPorId("1");
        verify(hiloRepositorio, times(1)).consultarHiloPorId("1");
        assertEquals(hilo, resultado);
    }

    @Test
    void givenIdWhenConsultarHiloPorIdThenTwitterExceptionIsThrown() throws TwitterException {
        when(hiloRepositorio.consultarHiloPorId("2")).thenThrow(TwitterException.class);
        assertThrows(TwitterException.class, () -> hiloServicio.consultarHiloPorId("2"));
    }

    @Test
    void givenIdAndPostWhenAgregarPostAlHiloThenPostIsAdded() throws TwitterException {
        Post post = new Post("LuisaGiron", "Hola mundo");
        hiloServicio.agregarPostAlHilo("1", post);
        verify(hiloRepositorio, times(1)).agregarPostAlHilo("1", post);
    }

    @Test
    void givenIdAndPostWhenAgregarPostAlHiloThenTwitterExceptionIsThrown() throws TwitterException {
        Post post = new Post("LuisaGiron", "Hola mundo");
        doThrow(TwitterException.class).when(hiloRepositorio).agregarPostAlHilo("2", post);
        assertThrows(TwitterException.class, () -> hiloServicio.agregarPostAlHilo("2", post));
    }

    @Test
    void givenIdAndPostWhenAgregarPostAlHiloThenTwitterExceptionIsThrownForLongComment() {
        Post post = new Post("LuisaGiron",  "Hola mundo, esta es una prueba de un comentario muy largo que excede los 140 caracteres de largo y debería lanzar una excepción de tipo TwitterException.");
        assertThrows(TwitterException.class, () -> hiloServicio.agregarPostAlHilo("1", post));
    }
}