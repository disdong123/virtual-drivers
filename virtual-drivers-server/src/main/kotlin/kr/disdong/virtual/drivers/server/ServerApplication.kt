package kr.disdong.virtual.drivers.server

import kr.disdong.virtual.drivers.domain.DomainApplication
import kr.disdong.virtual.drivers.persistence.PersistenceApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(DomainApplication::class, PersistenceApplication::class) // scanBasePackages 설정은 지워도 됩니다.
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
