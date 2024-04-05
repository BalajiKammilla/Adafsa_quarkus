package org.aptiway.Entity

import io.quarkus.hibernate.orm.panache.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity(name = "userEntity")
data class UserEntity(
    val id: Long?,
    var name: String,
    var email: String,
    var password: String,
    var firstName: String,
    var lastName: String
):PanacheEntity(){
    constructor():this(null,"","","","","")
}
