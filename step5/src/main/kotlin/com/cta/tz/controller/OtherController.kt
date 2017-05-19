package com.cta.tz.controller

import com.cta.tz.domain.User
import com.cta.tz.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryLinksResource
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks
import org.springframework.hateoas.ExposesResourceFor
import org.springframework.hateoas.ResourceProcessor
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@RepositoryRestController
@ExposesResourceFor(User::class)
@RequestMapping("/titi")
open class OtherController(val repository: UserRepository): ResourceProcessor<RepositoryLinksResource> {


    override fun process(resource: RepositoryLinksResource): RepositoryLinksResource {
        resource.add(ControllerLinkBuilder.linkTo(OtherController::class.java).withRel("users"))

        return resource
    }

    @Autowired
    lateinit var entityLinks: RepositoryEntityLinks

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun howManyPlaylist(): ResponseEntity<*>? {
        val dtos = repository.howManyPlaylist()

        val resources = Resources(dtos)
        resources.add(ControllerLinkBuilder.linkTo(User::class.java).withRel("users"))
        resources.add(entityLinks.linkToSingleResource(User::class.java, 1L))


        return ResponseEntity.ok(resources)
    }
}