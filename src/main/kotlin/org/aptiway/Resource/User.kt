package org.aptiway.Resource

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.aptiway.Entity.UserEntity
import org.aptiway.Repository.userEntityRepo

@ApplicationScoped
@Path("/api/user")
class User(@Inject private val userEntityRepo: userEntityRepo) {

    @POST
    @Path("/addUser")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    fun save(userEntity: UserEntity):Response {
        userEntityRepo.persist(userEntity)
        return Response.ok(userEntity).build()
    }

    @GET
    @Path("/getUser")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll(): List<UserEntity> {
        return userEntityRepo.listAll()
    }

    @GET
    @Path("/getUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getById(@PathParam("id") id:Long): UserEntity? {
        return userEntityRepo.findById(id)
    }

    @DELETE
    @Path("/deleteUser/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteById(@PathParam("id") id: Long): Response{
         userEntityRepo.deleteById(id)
        return Response.ok("User Delete by $id").build()
    }

    @PUT
    @Path("/updateUser/{id}")
    @Transactional
    fun update(@PathParam("id") id:Long, updateUser:UserEntity): Response {
        val existingUser = userEntityRepo.findById(id)
        if (existingUser == null){
            return Response.status(Response.Status.NOT_FOUND)
                .entity("user not fund $id")
                .build()
        }
        existingUser.name = updateUser.name
        existingUser.email = updateUser.email
        existingUser.password = updateUser.password
        existingUser.firstName = updateUser.firstName
        existingUser.lastName = updateUser.lastName

        userEntityRepo.persist(existingUser)

        return Response.ok(existingUser).build()
    }

}