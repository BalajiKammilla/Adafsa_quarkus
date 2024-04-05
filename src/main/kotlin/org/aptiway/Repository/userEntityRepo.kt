package org.aptiway.Repository

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.core.Response
import org.aptiway.Entity.User
import org.aptiway.Entity.UserEntity
@ApplicationScoped
class userEntityRepo: PanacheRepositoryBase<UserEntity, Long> {
//    fun findByUser(id: Long): UserEntity? {}
}