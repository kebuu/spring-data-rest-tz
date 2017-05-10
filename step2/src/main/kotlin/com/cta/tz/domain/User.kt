package com.cta.tz.domain

import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class User(
        var firstName: String? = null,
        var lastName: String? = null,
        var login: String,
        var password: String,

        @OneToMany
        var friends: Set<User> = HashSet(),

        @OneToMany(mappedBy = "owner")
        var playlists: Set<Playlist> = HashSet()): AbstractEntity() {

    constructor(): this(login = "", password = "")
}