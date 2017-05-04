package com.cta.tz.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Toto {

    @Id
    @GeneratedValue
    val id: Long? = null
    val name: String = "toto"
}