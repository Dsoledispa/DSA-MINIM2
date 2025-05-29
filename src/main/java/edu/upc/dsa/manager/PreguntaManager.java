package edu.upc.dsa.manager;

import edu.upc.dsa.models.Pregunta;

public interface PreguntaManager {

    //RegistrarPregunta o addPregunta
    Pregunta registrarPregunta(Pregunta pregunta);
    Pregunta registrarPregunta(String id_pregunta, String fecha, String titulo, String mensaje, String remitente);

    void clear();
    int sizePreguntas();

}
