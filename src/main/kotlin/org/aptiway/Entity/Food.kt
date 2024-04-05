package org.aptiway.Entity

import io.quarkus.hibernate.orm.panache.PanacheEntity
import jakarta.persistence.Entity

@Entity(name = "food")
data class Food(
    val id: Long?,
    var foodName: String,
    var foodNameArabic: String,
    var weight: Int,
    var portionRequired: Int,
):PanacheEntity(){
    constructor():this(null,"","",0,0)
}
