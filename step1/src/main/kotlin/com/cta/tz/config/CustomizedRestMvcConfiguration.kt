package com.cta.tz.config

import com.cta.tz.domain.*
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AssignableTypeFilter
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
import org.springframework.stereotype.Component

@Component
class CustomizedRestMvcConfiguration : RepositoryRestConfigurerAdapter() {

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration) {
        config.setBasePath("/rest-api") // <=> spring.data.rest.base-path="/rest-api" (application.properties)
        config.exposeIdsFor(Song::class.java, Playlist::class.java, Singer::class.java, User::class.java)

//        val provider = ClassPathScanningCandidateComponentProvider(true)
//        provider.addIncludeFilter(AssignableTypeFilter(AbstractEntity::class.java))
//        val entityClasses = provider.findCandidateComponents("com.cta.tz.domain").map { Class.forName(it.beanClassName) }
//        config.exposeIdsFor(*entityClasses.toTypedArray())
    }
}