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
import org.aptiway.Entity.Food
import org.aptiway.Repository.FoodRepo

@ApplicationScoped
@Path("/api/food")
class Foood (@Inject private val foodRepo: FoodRepo){

    @POST
    @Path("/addRecepi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    fun save(food: Food):Response {
        foodRepo.persist(food)
        return Response.ok(food).build()
    }

    @GET
    @Path("/recepis")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll():List<Food> {
        return foodRepo.listAll()
    }

    @GET
    @Path("/recepis/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getByid(@PathParam("id") id: Long): Food? {
        return foodRepo.findById(id)
    }

    @PUT
    @Path("/updateRecepi/{id}")
    @Transactional
    fun updateFood(@PathParam("id") id: Long, updateFood: Food):Response {
        val existFood = foodRepo.findById(id)
        if (existFood == null){
            return Response.status(Response.Status.NOT_FOUND)
                .entity("not found by $id")
                .build()
        }
        existFood.foodName = updateFood.foodName
        existFood.foodNameArabic = updateFood.foodNameArabic
        existFood.weight = updateFood.weight
        existFood.portionRequired = updateFood.portionRequired

        foodRepo.persist(existFood)
        return Response.ok(existFood).build()
    }
}