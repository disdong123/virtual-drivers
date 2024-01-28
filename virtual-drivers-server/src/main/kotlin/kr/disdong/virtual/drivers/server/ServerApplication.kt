package kr.disdong.virtual.drivers.server

import kr.disdong.virtual.drivers.api.client.ApiClientApplication
import kr.disdong.virtual.drivers.domain.DomainApplication
import kr.disdong.virtual.drivers.persistence.PersistenceApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(DomainApplication::class, PersistenceApplication::class, ApiClientApplication::class)
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
