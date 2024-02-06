package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.listener

import kr.disdong.virtual.drivers.common.logger.logger
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.DrivingDirectionRouteCache
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DrivingDirectionListener(
    private val simpMessagingTemplate: SimpMessagingTemplate,
) {

    private val logger = logger<DrivingDirectionListener>()

    @Scheduled(fixedRate = 1000)
    fun sentToPosition() {
        logger.info("sentToPosition. hello")
        simpMessagingTemplate.convertAndSend("/driving-direction/position", TestMessage("hello world"))

        // cache 조회
        // 다음 position 조회
        // send
    }
}

class NextPositionFinder(
    private val drivingDirectionRouteCache: DrivingDirectionRouteCache,
) {
    fun find() {
        // drivingDirectionRouteCache.get()
    }
}

class TestMessage(
    val message: String
)
