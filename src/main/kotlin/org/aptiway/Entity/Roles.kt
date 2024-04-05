package org.aptiway.Entity

import io.quarkus.hibernate.orm.panache.PanacheEntity
import jakarta.persistence.Entity

@Entity(name = "UserEntityRoles")
data class Roles(
    val id: Long?,
    var roleName: String
): PanacheEntity(){
    constructor():this(null, "")
}
