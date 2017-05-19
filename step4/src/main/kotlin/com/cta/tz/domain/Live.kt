package com.cta.tz.domain

import com.cta.tz.EmptyObjects
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Live(
        @ManyToOne
        var user: User,

        @ManyToOne
        var song: Song): AbstractEntity() {

        constructor() : this(EmptyObjects.user, EmptyObjects.song)
}