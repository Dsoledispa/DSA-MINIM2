package edu.upc.dsa.services;

import edu.upc.dsa.config.IniciarDatos;
import edu.upc.dsa.manager.PreguntaManager;
import edu.upc.dsa.manager.PreguntaManagerImpl;
import edu.upc.dsa.models.Pregunta;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/pregunta", description = "Servicio de preguntas")
@Path("/pregunta")
public class PreguntaService {
    final static Logger logger = Logger.getLogger(PreguntaService.class);

    private final PreguntaManager pm;

    public PreguntaService() {
        this.pm = PreguntaManagerImpl.getInstance();
        IniciarDatos.init();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarPregunta(Pregunta pregunta) {
        try {
            pm.registrarPregunta(pregunta);
            return Response.ok("{message: Pregunta recibida correctamente}").build();
        } catch (Exception e) {
            logger.error("Error al registrar la pregunta", e);
            return Response.status(500).entity("{error:Error al registrar la pregunta}").build();
        }
    }
}
