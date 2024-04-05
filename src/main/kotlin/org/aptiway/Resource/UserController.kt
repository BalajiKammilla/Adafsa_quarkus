package org.aptiway.Resource

import io.quarkus.hibernate.orm.panache.Panache
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.aptiway.Entity.User
import org.aptiway.Repository.userRepo

@ApplicationScoped
@Path("/api")
class UserController(@Inject private val userRepo: userRepo) {

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    fun save(user: User):Response {
        userRepo.persist(user)
        return Response.ok(user).build()
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun get(): List<User>{
        return userRepo.listAll()
    }
}
class GetResponseOfUser(
    data:List<User>
)