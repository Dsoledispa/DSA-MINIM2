package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Pregunta {
    private String id_pregunta;
    private String fecha;
    private String titulo;
    private String mensaje;
    private String remitente; //nombreUsu

    public Pregunta() {
        setId_pregunta(RandomUtils.getId());
    }

    public Pregunta(String id_pregunta, String fecha, String titulo, String mensaje, String remitente) {
        this(); // Llama al constructor sin parámetros (asigna un id aleatorio).
        if (id_pregunta != null) setId_pregunta(id_pregunta);
        setFecha(fecha);
        setTitulo(titulo);
        setMensaje(mensaje);
        setRemitente(remitente);
    }

    public String getId_pregunta() { return id_pregunta; }
    public void setId_pregunta(String id_pregunta) { this.id_pregunta = id_pregunta; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getRemitente() { return remitente; }
    public void setRemitente(String remitente) { this.remitente = remitente; }

    @Override
    public String toString() {
        return "Pregunta [id_pregunta=" + id_pregunta + ", fecha=" + fecha + ", titulo=" + titulo +
                ", mensaje=" + mensaje + ", remitente=" + remitente + "]";
    }
}
