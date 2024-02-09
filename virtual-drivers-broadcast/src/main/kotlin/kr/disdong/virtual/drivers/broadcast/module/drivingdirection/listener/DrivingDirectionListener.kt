package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.listener

import kr.disdong.virtual.drivers.broadcast.module.drivingdirection.constant.Constants
import kr.disdong.virtual.drivers.broadcast.module.drivingdirection.helper.CurrentPositionFinder
import kr.disdong.virtual.drivers.common.logger.logger
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DrivingDirectionListener(
    private val simpMessagingTemplate: SimpMessagingTemplate,
    private val currentPositionFinder: CurrentPositionFinder,
) {

    private val logger = logger<DrivingDirectionListener>()

    @Scheduled(fixedRate = 1000)
    fun sendCurrentPositions() {
        logger.info("sendCurrentPositions")
        simpMessagingTemplate.convertAndSend(Constants.NEXT_POSITION_DESTINATION, currentPositionFinder.findAll())
    }
}
