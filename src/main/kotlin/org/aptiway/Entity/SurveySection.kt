package org.aptiway.Entity

import io.quarkus.hibernate.orm.panache.PanacheEntity
import jakarta.persistence.Entity

@Entity(name = "surveyEntity")
data class SurveySection(
    val id:Long?,
    var sectionId: Long,
    var title: String,
    var conditions: List<String>,
    var header: Boolean,
    var questions: List<String>
):PanacheEntity(){
    constructor() : this(null,0, "", emptyList(), false, emptyList())
}
