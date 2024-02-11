package kr.disdong.virtual.drivers.position.handler

import kr.disdong.virtual.drivers.cache.CacheApplication
import kr.disdong.virtual.drivers.domain.DomainApplication
import kr.disdong.virtual.drivers.persistence.PersistenceApplication
import kr.disdong.virtual.drivers.pubsub.PubsubApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@Import(CacheApplication::class, DomainApplication::class, PersistenceApplication::class, PubsubApplication::class)
@EnableScheduling
class PositionHandlerApplication

fun main(args: Array<String>) {
    runApplication<PositionHandlerApplication>(*args)
}
