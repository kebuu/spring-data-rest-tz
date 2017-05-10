package com.cta.tz.domain;

import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractEntity(@Id @GeneratedValue val id: Long? = null) {

    override fun toString(): String {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        return if (id == null || other == null || other !is AbstractEntity) {
            false
        } else {
            id == other.id
        }
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}

