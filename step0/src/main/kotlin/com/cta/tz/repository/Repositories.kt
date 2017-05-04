package com.cta.tz.repository

import com.cta.tz.domain.*
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>

interface SongRepository : CrudRepository<Song, Long>

interface LiveRepository : CrudRepository<Live, Long>

interface SingerRepository : CrudRepository<Singer, Long>

interface PlaylistRepository : CrudRepository<Playlist, Long>

interface TotoRepository : CrudRepository<Toto, Long>
