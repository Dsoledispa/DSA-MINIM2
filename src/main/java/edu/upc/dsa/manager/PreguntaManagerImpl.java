package edu.upc.dsa.manager;

import edu.upc.dsa.models.Pregunta;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class PreguntaManagerImpl implements PreguntaManager{

    private static PreguntaManager instance;
    protected List<Pregunta> preguntas;
    final static Logger logger = Logger.getLogger(PreguntaManagerImpl.class);

    private PreguntaManagerImpl(){
        this.preguntas = new ArrayList<>();
    }

    // Patron singleton
    public static PreguntaManager getInstance() {
        if (instance == null) instance = new PreguntaManagerImpl();
        return instance;
    }

    @Override
    public Pregunta registrarPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
        logger.info("Pregunta : " +this.preguntas);
        return pregunta;
    }

    @Override
    public Pregunta registrarPregunta(String id_pregunta, String fecha, String titulo, String mensaje, String remitente) {
        return this.registrarPregunta(new Pregunta(id_pregunta, fecha, titulo, mensaje, remitente));
    }

    @Override
    public void clear() {
        this.preguntas.clear();
    }

    @Override
    public int sizePreguntas() {
        return this.preguntas.size();
    }
}
