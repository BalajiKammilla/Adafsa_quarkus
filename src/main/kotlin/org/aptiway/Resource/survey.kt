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
import org.aptiway.Entity.SurveySection
import org.aptiway.Repository.surveySectionRepo

@ApplicationScoped
@Path("/api/survey")
class survey (@Inject private val surveySectionRepo: surveySectionRepo){

    @POST
    @Path("/addSection")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    fun save(surveySection: SurveySection): Response {
        surveySectionRepo.persist(surveySection)
        return Response.ok(surveySection).build()
    }

    @GET
    @Path("/getAllSections")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    fun getall(): List<SurveySection> {
        return surveySectionRepo.listAll()
    }


    @GET
    @Path("/getSection/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    fun getById(@PathParam("id") id: Long) :SurveySection {
        return surveySectionRepo.findById(id)
    }


    @PUT
    @Path("/updateSection/{id}")
    @Transactional
    fun updateSection(@PathParam("id") id: Long, updateSection: SurveySection): Response {
       val existSection = surveySectionRepo.findById(id)

        if (existSection == null){
            return Response.status(Response.Status.NOT_FOUND)
                .entity("not found")
                .build()
        }

        existSection.sectionId = updateSection.sectionId
        existSection.title = updateSection.title
        existSection.header = updateSection.header
        existSection.questions = updateSection.questions
        existSection.conditions = updateSection.conditions

        surveySectionRepo.persist(existSection)

        return Response.ok(existSection).build()
    }


    @DELETE
    @Path("/deleteSection/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteSection(@PathParam("id") id: Long): Response{
         surveySectionRepo.deleteById(id)
        return Response.ok("Section Deleted by $id").build()
    }


}