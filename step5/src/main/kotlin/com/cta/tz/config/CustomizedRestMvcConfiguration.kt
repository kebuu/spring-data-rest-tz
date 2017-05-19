package com.cta.tz.config

import com.cta.tz.domain.Playlist
import com.cta.tz.domain.Singer
import com.cta.tz.domain.Song
import com.cta.tz.domain.User
import com.cta.tz.validator.SongValidator
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener
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

    override fun configureJacksonObjectMapper(objectMapper: ObjectMapper) {
        val hibernate5Module = Hibernate5Module()
        hibernate5Module.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS)
        objectMapper.registerModule(hibernate5Module)
    }

    override fun configureValidatingRepositoryEventListener(v: ValidatingRepositoryEventListener) {
        v.addValidator("beforeSave", SongValidator())
    }
}