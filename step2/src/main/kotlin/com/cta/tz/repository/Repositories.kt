package com.cta.tz.repository

import com.cta.tz.domain.*
import com.cta.tz.domain.projection.playlist.UserExcerpt
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(excerptProjection = UserExcerpt::class)
interface UserRepository : CrudRepository<User, Long>

interface SongRepository : CrudRepository<Song, Long>

@RepositoryRestResource(exported = false)
interface LiveRepository : CrudRepository<Live, Long>

interface SingerRepository : CrudRepository<Singer, Long>

interface PlaylistRepository : CrudRepository<Playlist, Long>
