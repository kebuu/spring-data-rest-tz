package com.cta.tz.domain.projection.playlist

import com.cta.tz.domain.Playlist
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.rest.core.config.Projection

@Projection(name = "withSize", types = arrayOf(Playlist::class))
internal interface WithNumberOfSongs {

    @Value("#{target.songs.size()}")
    fun getSize(): Int
}