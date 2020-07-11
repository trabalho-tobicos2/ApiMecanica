package br.com.apimecanica.resources;

import br.com.apimecanica.models.Cliente;
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
@Path("clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ClienteResources {

    @PersistenceContext(unitName = "MecanicaPU")
    EntityManager entityManager;

    @GET
    public List<Cliente> getClientes() {
        return entityManager
                .createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

    @POST
    public Response addCliente(Cliente cliente) {
        entityManager.persist(cliente);
        return Response
                .status(Response.Status.CREATED)
                .entity(cliente)
                .build();
    }

    @GET
    @Path("{id}")
    public Cliente getCliente(@PathParam("id") UUID id) {
        return entityManager.find(Cliente.class, id);
    }

    @DELETE
    @Path("{id}")
    public void removeCliente(@PathParam("id") UUID id) {
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
    }

    @PUT
    @Path("{id}")
    public Cliente updateCliente(@PathParam("id") UUID id, Cliente c) {
        c.setId(id);
        entityManager.merge(c);
        return c;
    }
}
