package com.cta.tz.domain.projection.playlist

import com.cta.tz.domain.Playlist
import com.cta.tz.domain.Song
import org.springframework.data.rest.core.config.Projection

@Projection(name = "inlinedSongs", types = arrayOf(Playlist::class))
internal interface InlinedSong {

    val name: String

    val songs: Set<Song>
}