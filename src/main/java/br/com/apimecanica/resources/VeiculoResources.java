package br.com.apimecanica.resources;

import br.com.apimecanica.models.Veiculo;
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
@Path("veiculos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class VeiculoResources {

    @PersistenceContext(unitName = "MecanicaPU")
    EntityManager entityManager;

    @GET
    public List<Veiculo> getVeiculos() {
        return entityManager
                .createQuery("SELECT v FROM Veiculo v", Veiculo.class)
                .getResultList();
    }

    @POST
    public Response addVeiculo(Veiculo veiculo) {
        entityManager.persist(veiculo);
        return Response
                .status(Response.Status.CREATED)
                .entity(veiculo)
                .build();
    }

    @GET
    @Path("{id}")
    public Veiculo getVeiculo(@PathParam("id") UUID id) {
        return entityManager.find(Veiculo.class, id);
    }

    @DELETE
    @Path("{id}")
    public void removeVeiculo(@PathParam("id") UUID id) {
        Veiculo veiculo = entityManager.find(Veiculo.class, id);
        entityManager.remove(veiculo);
    }

    @PUT
    @Path("{id}")
    public Veiculo updateVeiculo(@PathParam("id") UUID id, Veiculo v) {
        v.setId(id);
        entityManager.merge(v);
        return v;
    }
}
