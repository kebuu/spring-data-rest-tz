package com.cta.tz.domain

import javax.persistence.Entity

@Entity
class Singer(
        var name: String = "",
        var age: Int? = null): AbstractEntity()