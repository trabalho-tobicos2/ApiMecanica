package br.com.apimecanica.resources;

import br.com.apimecanica.models.Peca;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author user
 */
@Stateless
@Path("pecas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PecaResources {

    @PersistenceContext(unitName = "MecanicaPU")
    EntityManager entityManager;

    @GET
    public List<Peca> getPecas() {
        return entityManager
                .createQuery("SELECT p FROM Peca p", Peca.class)
                .getResultList();
    }

    @POST
    public Response addPeca(Peca peca) {
        entityManager.persist(peca);
        return Response
                .status(Response.Status.CREATED)
                .entity(peca)
                .build();
    }

    @GET
    @Path("{id}")
    public Peca getPeca(@PathParam("id") UUID id) {
        return entityManager.find(Peca.class, id);
    }

    @DELETE
    @Path("{id}")
    public void removePeca(@PathParam("id") UUID id) {
        Peca peca = entityManager.find(Peca.class, id);
        entityManager.remove(peca);
    }

    @PUT
    @Path("{id}")
    public Peca updatePeca(@PathParam("id") UUID id, Peca p) {
        p.setId(id);
        entityManager.merge(p);
        return p;
    }
}
