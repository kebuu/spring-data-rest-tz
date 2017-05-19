package com.cta.tz.domain

import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Version

@Entity
class Song(
        var name: String = "",

        @ManyToOne
        var singer: Singer? = null,

        var type: SongType = SongType.OTHER,
        var timeSecond: Int = -1,
        var text: String? = null,
        @Version var version: Long? = null) : AbstractEntity()