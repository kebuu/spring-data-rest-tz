package com.cta.tz.domain.projection.playlist

import com.cta.tz.domain.User
import org.springframework.data.rest.core.config.Projection

@Projection(name = "userExcerpt", types = arrayOf(User::class))
internal interface UserExcerpt {

    val firstName: String
    val lastName: String
    val login: String
}