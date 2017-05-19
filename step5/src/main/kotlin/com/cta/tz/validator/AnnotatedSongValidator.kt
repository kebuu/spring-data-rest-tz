package com.cta.tz.validator

import com.cta.tz.domain.Song
import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ObjectError

@RepositoryEventHandler
@Component
class AnnotatedSongValidator {

    @HandleBeforeCreate
    fun handleSongCreated(p: Song, e: Errors) {
        println("handleSongCreated")
        e.globalErrors.add(ObjectError("toto", "titi"))
    }
}