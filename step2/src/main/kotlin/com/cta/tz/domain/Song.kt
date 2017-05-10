package com.cta.tz.domain

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Song(
        var name: String = "",

        @ManyToOne
        var singer: Singer? = null,

        var type: SongType = SongType.OTHER,
        var timeSecond: Int = -1,
        var text: String? = null): AbstractEntity()