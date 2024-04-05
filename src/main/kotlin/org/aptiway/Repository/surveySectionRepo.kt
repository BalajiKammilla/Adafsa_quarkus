package org.aptiway.Repository

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase
import jakarta.enterprise.context.ApplicationScoped
import org.aptiway.Entity.SurveySection

@ApplicationScoped
class surveySectionRepo: PanacheRepositoryBase<SurveySection, Long> {
}