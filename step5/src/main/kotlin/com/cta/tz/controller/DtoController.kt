package com.cta.tz.controller

import com.cta.tz.domain.User
import com.cta.tz.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@RepositoryRestController
class DtoController(val repository: UserRepository) {

    @Autowired
    lateinit var entityLinks: RepositoryEntityLinks

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/users/search/howManyPlaylist")
    @ResponseBody
    fun howManyPlaylist(): ResponseEntity<*>? {
        val dtos = repository.howManyPlaylist()

        val resources = Resources(dtos)
        resources.add(ControllerLinkBuilder.linkTo(User::class.java).withRel("users"))
        resources.add(entityLinks.linkToSingleResource(User::class.java, 1L))


        return ResponseEntity.ok(resources)
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/users/search/listSomethings")
    @ResponseBody
    fun howManyPlaylist2(): ResponseEntity<*> {
        val dtos = repository.howManyPlaylist()

        val resource = Resource(dtos[0])

        return ResponseEntity.ok(resource)
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/users/search/howManyPlaylist3")
    @ResponseBody
    fun howManyPlaylist3(): ResponseEntity<*> {
        val dtos = repository.howManyPlaylist()

        return ResponseEntity.ok(dtos)
    }
}