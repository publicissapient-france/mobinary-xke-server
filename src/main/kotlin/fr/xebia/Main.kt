package fr.xebia

import example.avro.Game
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get


fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/hero") {
            call.respondText("Get a Game or a hero")
        }

        get("/hero") {
            val hero = HeroOuterClass.Hero.newBuilder()
                    .setId(666)
                    .setName("Eric Cartman")
                    .setDescription("Whateva, I do what I want!")
                    .build()
            call.respond(hero.toByteArray())
        }

        get("/game") {
            val game = Game("Game name", "Game desciption");

            call.respond(game.toByteBuffer())
        }
    }
}