package org.aptiway.Entity

import io.quarkus.hibernate.orm.panache.PanacheEntity
import jakarta.persistence.Entity


@Entity(name = "AppUser")
data class User(
    val id: Long?,
    var name: String,
    var email: String,
    var password: String,
    var firstName: String,
    var lastName: String
) : PanacheEntity(){
    constructor(): this(null,"","","","","")
}