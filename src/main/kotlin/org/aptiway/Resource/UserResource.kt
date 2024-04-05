//package org.aptiway.Resource
//
//import jakarta.enterprise.context.ApplicationScoped
//import jakarta.inject.Inject
//import jakarta.ws.rs.*
//import jakarta.ws.rs.core.MediaType
//import jakarta.ws.rs.core.Response
//import org.aptiway.Entity.User
//import org.aptiway.Repository.UserRepository
//
//@ApplicationScoped
//@Path("/users")
//class UserResource(@Inject private val userRepository: UserRepository) {
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    fun getUsers(): List<User> = userRepository.listAll()
//
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    fun getUserById(@PathParam("id") id: Long): User? = userRepository.findById(id)
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    fun createUser(user: User): Response {
//        userRepository.persist(user)
//        return Response.status(Response.Status.CREATED).entity(user).build()
//    }
//
////    @PUT
////    @Path("/{id}")
////    @Consumes(MediaType.APPLICATION_JSON)
////    @Produces(MediaType.APPLICATION_JSON)
////    fun updateUser(@PathParam("id") id: Long, updatedUser: User): Response {
////        val existingUser = userRepository.findById(id)
////        if (existingUser == null) {
////            return Response.status(Response.Status.NOT_FOUND).build()
////        }
////        // Update user properties
////        existingUser.name = updatedUser.name
////        existingUser.email = updatedUser.email
////        existingUser.password = updatedUser.password
////        existingUser.firstName = updatedUser.firstName
////        existingUser.lastName = updatedUser.lastName
////        userRepository.persist(existingUser)
////        return Response.ok(existingUser).build()
////    }
//
//    @DELETE
//    @Path("/{id}")
//    fun deleteUser(@PathParam("id") id: Long): Response {
//        val user = userRepository.findById(id)
//        if (user != null) {
//            userRepository.delete(user)
//            return Response.status(Response.Status.NO_CONTENT).build()
//        }
//        return Response.status(Response.Status.NOT_FOUND).build()
//    }
//}