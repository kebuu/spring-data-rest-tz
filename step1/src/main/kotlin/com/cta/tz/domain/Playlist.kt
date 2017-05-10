package com.cta.tz.domain

import com.cta.tz.EmptyObjects
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne

@Entity
class Playlist(
        var name: String,

        @ManyToMany
        var songs: Set<Song> = HashSet(),

        @ManyToOne
        var owner: User): AbstractEntity() {

    constructor() : this("", owner = EmptyObjects.user)
}