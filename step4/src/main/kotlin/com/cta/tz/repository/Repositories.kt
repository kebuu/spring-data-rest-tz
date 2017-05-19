package com.cta.tz.repository

import com.cta.tz.domain.*
import com.cta.tz.domain.projection.playlist.UserExcerpt
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.security.access.annotation.Secured

@RepositoryRestResource(excerptProjection = UserExcerpt::class)
interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User
}

interface SongRepository : PagingAndSortingRepository<Song, Long> {
    fun findByType(type: SongType): Song
}

@Secured("ROLE_ADMIN")
interface LiveRepository : CrudRepository<Live, Long>

@RepositoryRestResource(path = "artists", collectionResourceRel = "artists", itemResourceRel = "artist")
interface SingerRepository : CrudRepository<Singer, Long>

interface PlaylistRepository : CrudRepository<Playlist, Long> {

    @Query("select p from Playlist p join p.songs song group by p having sum(song.timeSecond) > 400")
    fun findLongPlaylist(): Iterable<Playlist>

    @Secured("ROLE_ADMIN")
    @Query("select count(p) from Playlist p")
    @RestResource(path = "countPlaylist")
    fun findLongPlaylist2(): Int
}
