package com.cta.tz.domain.projection.playlist

import com.cta.tz.domain.Playlist
import org.springframework.data.rest.core.config.Projection

@Projection(name = "composed", types = arrayOf(Playlist::class))
internal interface Composed : InlinedSong, WithNumberOfSongs