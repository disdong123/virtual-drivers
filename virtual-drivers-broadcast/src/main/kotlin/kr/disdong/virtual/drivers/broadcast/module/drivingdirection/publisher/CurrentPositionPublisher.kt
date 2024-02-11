package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.publisher

import kr.disdong.virtual.drivers.broadcast.module.drivingdirection.constant.Constants
import kr.disdong.virtual.drivers.broadcast.module.drivingdirection.helper.CurrentPositionFinder
import kr.disdong.virtual.drivers.common.logger.logger
import kr.disdong.virtual.drivers.pubsub.module.drivingdirection.dto.CurrentPositionResponse
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component

@Component
class CurrentPositionPublisher(
    private val simpMessagingTemplate: SimpMessagingTemplate,
    private val currentPositionFinder: CurrentPositionFinder,
) {

    private val logger = logger<CurrentPositionPublisher>()

    // @Scheduled(fixedRate = 1000)
    @Deprecated("position-handler 가 없는 경우 사용할 수 있습니다.")
    fun publishAll() {
        simpMessagingTemplate.convertAndSend(Constants.TOPIC_CURRENT_POSITION, currentPositionFinder.findAll())
    }

    fun publish(currentPositionResponse: CurrentPositionResponse) {
        simpMessagingTemplate.convertAndSend(Constants.TOPIC_CURRENT_POSITION, currentPositionResponse)
    }
}
