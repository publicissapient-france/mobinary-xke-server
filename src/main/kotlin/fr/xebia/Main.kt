package fr.xebia

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get


fun Application.main() {
    install(DefaultHeaders)
    install(CallLogging)
    install(Routing) {
        get("/") {
            val game = HeroOuterClass.Hero.newBuilder()
                    .setId(666)
                    .setName("Eric Cartman")
                    .setDescription("Whateva, I do what I want!")
                    .build()

            call.respond(game.toByteArray())
        }
    }
}