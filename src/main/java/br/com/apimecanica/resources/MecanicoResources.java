package br.com.apimecanica.resources;

import br.com.apimecanica.models.Mecanico;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
@Path("mecanicos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MecanicoResources {
    
    @PersistenceContext(unitName = "MecanicaPU")
    EntityManager entityManager;
    
    @GET
    public List<Mecanico> getMecanicos() {
        return entityManager
                .createQuery("SELECT m FROM Mecanico m", Mecanico.class)
                .getResultList();
    }
    
    @POST
    public Response addMecanico(Mecanico mecanico) {
        entityManager.persist(mecanico);
        return Response
                .status(Response.Status.CREATED)
                .entity(mecanico)
                .build();
    }
    
    @GET
    @Path("{id}")
    public Mecanico getMecanico(@PathParam("id") UUID id) {
        return entityManager.find(Mecanico.class, id);
    }
        
    @DELETE
    @Path("{id}")
    public void removeMecanico(@PathParam("id") UUID id) {
        Mecanico mecanico = entityManager.find(Mecanico.class, id);
        entityManager.remove(mecanico);
    }
    
    @PUT
    @Path("{id}")
    public Mecanico updateMecanico(@PathParam("id") UUID id, Mecanico m) {
        m.setId(id);
        entityManager.merge(m);
        return m;
    }
       
} 