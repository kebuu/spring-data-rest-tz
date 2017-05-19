package com.cta.tz.validator

import com.cta.tz.domain.Song
import org.springframework.validation.Errors
import org.springframework.validation.Validator

class SongValidator: Validator {
    override fun validate(p0: Any, p1: Errors) {
        println("validate")
        p1.reject("truc", "titi")
        if (p0 is Song) {
            p1.reject(p0::timeSecond.name, "titi")
            p1.rejectValue(p0::timeSecond.name, "titi", "toti")
        }
    }

    override fun supports(p0: Class<*>): Boolean {
        return p0 == Song::class.java
    }
}