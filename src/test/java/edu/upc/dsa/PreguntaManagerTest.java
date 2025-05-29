package edu.upc.dsa;

import edu.upc.dsa.manager.PreguntaManager;
import edu.upc.dsa.manager.PreguntaManagerImpl;
import edu.upc.dsa.models.Pregunta;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PreguntaManagerTest {

    final static Logger logger = Logger.getLogger(PreguntaManagerTest.class);
    PreguntaManager pm;

    @Before
    public void setUp() {
        this.pm = PreguntaManagerImpl.getInstance();
        this.pm.clear(); // Limpiamos antes de cada test
    }

    @After
    public void tearDown() {
        this.pm.clear(); // Limpiamos después de cada test
    }

    @Test
    public void registrarPreguntaTest() {
        assertEquals(0, pm.sizePreguntas());

        Pregunta p = new Pregunta(null, "2025-05-29", "Título de prueba", "Mensaje de prueba", "UsuarioTest");
        Pregunta registrada = pm.registrarPregunta(p);

        assertNotNull(registrada);
        assertEquals(1, pm.sizePreguntas());
        assertEquals("Título de prueba", registrada.getTitulo());
        assertEquals("Mensaje de prueba", registrada.getMensaje());
        assertEquals("UsuarioTest", registrada.getRemitente());
    }

    @Test
    public void registrarPreguntaConParametrosTest() {
        assertEquals(0, pm.sizePreguntas());

        Pregunta p = pm.registrarPregunta(null, "2025-05-29", "Título 2", "Mensaje 2", "OtroUsuario");

        assertNotNull(p);
        assertEquals(1, pm.sizePreguntas());
        assertEquals("Título 2", p.getTitulo());
    }

    @Test
    public void clearTest() {
        pm.registrarPregunta(null, "2025-05-29", "Prueba", "Texto", "Tester");
        assertEquals(1, pm.sizePreguntas());

        pm.clear();
        assertEquals(0, pm.sizePreguntas());
    }
}
