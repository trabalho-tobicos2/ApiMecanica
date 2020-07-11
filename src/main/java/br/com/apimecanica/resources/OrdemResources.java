package br.com.apimecanica.resources;

import br.com.apimecanica.models.Ordem;
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
 *
 * @author user
 */
@Stateless
@Path("ordens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class OrdemResources {

    @PersistenceContext(unitName = "MecanicaPU")
    EntityManager entityManager;

    @GET
    public List<Ordem> getOrdens() {
        return entityManager
                .createQuery("SELECT DISTINCT o FROM Ordem o inner join fetch o.servicos s", Ordem.class)
                .getResultList();
    }

    @POST
    public Response addOrdem(Ordem ordem) {
        entityManager.persist(ordem);
        return Response
                .status(Response.Status.CREATED)
                .entity(ordem)
                .build();
    }

    @GET
    @Path("{id}")
    public Ordem getOrdem(@PathParam("id") UUID id) {
        Ordem ordem  = entityManager.find(Ordem.class, id);
        ordem.getServicos().size();
        return ordem;
      //  return entityManager.find(Ordem.class, id);
    }

    @DELETE
    @Path("{id}")
    public void removeOrdem(@PathParam("id") UUID id) {
        Ordem ordem = entityManager.find(Ordem.class, id);
        entityManager.remove(ordem);
    }

    @PUT
    @Path("{id}")
    public Ordem updateOrdem(@PathParam("id") UUID id, Ordem o) {
        o.setId(id);
        entityManager.merge(o);
        return o;
    }

}
