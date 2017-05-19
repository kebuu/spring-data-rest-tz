package com.cta.tz

import com.cta.tz.domain.*
import com.cta.tz.repository.*
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder

@SpringBootApplication
open class Step4Application {

    @Bean
    open fun setUp(singerRepository: SingerRepository,
              songRepository: SongRepository,
              userRepository: UserRepository,
              playlistRepository: PlaylistRepository,
              liveRepository: LiveRepository) = CommandLineRunner {
        SecurityContextHolder.getContext().authentication = SetupAuhentication()

        val singer1 = Singer("Coeur de Pirate")
        val singer2 = Singer("Charlotte Marin")
        val singer3 = Singer("Parov Stelar")
        val singer4 = Singer("Benabar")
        singerRepository.save(listOf(singer1, singer2, singer3, singer4))

        val song1 = Song("Mistral gagnant", singer1, SongType.POP, 174, "... et le mistral gagnant")
        val song2 = Song("Adieu", singer1, SongType.POP, 195)
        val song3 = Song("20H30", singer2, SongType.OTHER, 201)
        val song4 = Song("La rando", singer2, SongType.OTHER, 179, "mais c'est pas grave parce que c'est beau")
        val song5 = Song("Le plan B", singer1, SongType.OTHER, 234)
        val song6 = Song("Catgroove", singer2, SongType.POP, 215)
        val song7 = Song("Quatre murs et un toit", singer3, SongType.OTHER, 181, "...de monstres et de dragons....")
        val song8 = Song("Le diner", singer1, SongType.OTHER, 182, "On s'en fout on y va pas...")
        songRepository.save(listOf(song1, song2, song3, song4, song5, song6, song7, song8))

        val user1 = User("Christophe", "Tardella", "ctardella", "password")
        val user2 = User(login = "vtardella", password = "password")
        val user3 = User(login = "mtardella", password = "password")
        val user4 = User("Oriane", "Pichoud", "opichoud", "password")
        userRepository.save(listOf(user1, user2, user3, user4))

        val playlist1 = Playlist("Pop", setOf(song1, song2, song6), user1)
        val playlist2 = Playlist("Benabar", setOf(song7, song8), user1)
        val playlist3 = Playlist("Mix", setOf(song1, song3, song5, song7), user4)
        playlistRepository.save(listOf(playlist1, playlist2, playlist3))

        val live1 = Live(user1, song1)
        val live2 = Live(user2, song2)
        val live3 = Live(user4, song1)
        liveRepository.save(listOf(live1, live2, live3))

        SecurityContextHolder.getContext().authentication = null
    }

//    @Bean
//    fun personProcessor(): ResourceProcessor<Resource<AbstractEntity>> {
//        return ResourceProcessor { resource ->
//            Resource(resource.content)
//        }
//    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Step4Application::class.java, *args)
}

class SetupAuhentication : Authentication {
    override fun setAuthenticated(p0: Boolean) {

    }

    override fun getName(): String {
        return ""
    }

    override fun getCredentials(): Any {
        return ""
    }

    override fun getPrincipal(): Any {
        return Any()
    }

    override fun isAuthenticated() = true

    override fun getDetails() = ""

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(SimpleGrantedAuthority("ROLE_ADMIN"), SimpleGrantedAuthority("ROLE_USER"))
    }
}