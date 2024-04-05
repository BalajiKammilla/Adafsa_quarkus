package org.aptiway.Resource

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import kotlinx.coroutines.selects.ProcessResultFunction
import org.aptiway.Entity.Roles
import org.aptiway.Repository.RolesRepo

@ApplicationScoped
@Path("/api/role")
class Role (@Inject private val rolesRepo: RolesRepo){

    @POST
    @Path("/addRole")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    fun save(roles: Roles): Response {
        rolesRepo.persist(roles)
        return Response.ok(roles).build()
    }

    @GET
    @Path("/getRoles")
    @Produces(MediaType.APPLICATION_JSON)
    fun getById(): List<Roles>{
        return rolesRepo.listAll()
    }

    @PUT
    @Path("/updateRole/{id}")
    @Transactional
    fun update(@PathParam("id") id: Long, updateRole:Roles):Response{
        val existingRole = rolesRepo.findById(id)
        if (existingRole == null){
            return Response.status(Response.Status.NOT_FOUND)
                .entity("not found by $id")
                .build()
        }

        existingRole.roleName = updateRole.roleName

        rolesRepo.persist(existingRole)
        return Response.ok(existingRole).build()
    }
}