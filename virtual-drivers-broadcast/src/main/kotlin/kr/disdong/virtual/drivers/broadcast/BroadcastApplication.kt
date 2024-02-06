package kr.disdong.virtual.drivers.broadcast

import kr.disdong.virtual.drivers.domain.DomainApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@Import(DomainApplication::class)
class BroadcastApplication
