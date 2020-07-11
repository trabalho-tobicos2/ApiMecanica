package br.com.apimecanica.resources;

import br.com.apimecanica.models.Servico;
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
@Path("servicos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServicoResources {
    
    @PersistenceContext(unitName = "MecanicaPU")
    EntityManager entityManager;

    @GET
    public List<Servico> getServicos() {
        return entityManager
                .createQuery("SELECT s FROM Servico s", Servico.class)
                .getResultList();
    }

    @POST
    public Response addServico(Servico servico) {
        entityManager.persist(servico);
        return Response
                .status(Response.Status.CREATED)
                .entity(servico)
                .build();
    }

    @GET
    @Path("{id}")
    public Servico getServico(@PathParam("id") UUID id) {
        return entityManager.find(Servico.class, id);
    }

    @DELETE
    @Path("{id}")
    public void removeServico(@PathParam("id") UUID id) {
        Servico servico = entityManager.find(Servico.class, id);
        entityManager.remove(servico);
    }

    @PUT
    @Path("{id}")
    public Servico updateServico(@PathParam("id") UUID id, Servico s) {
        s.setId(id);
        entityManager.merge(s);
        return s;
    }

}
