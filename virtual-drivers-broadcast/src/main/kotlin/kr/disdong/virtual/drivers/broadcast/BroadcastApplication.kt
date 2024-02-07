package kr.disdong.virtual.drivers.broadcast

import kr.disdong.virtual.drivers.cache.CacheApplication
import kr.disdong.virtual.drivers.domain.DomainApplication
import kr.disdong.virtual.drivers.persistence.PersistenceApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@Import(DomainApplication::class, CacheApplication::class, PersistenceApplication::class)
class BroadcastApplication
