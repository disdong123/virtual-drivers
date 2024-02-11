package kr.disdong.virtual.drivers.pubsub.module.drivingdirection.publisher

import kr.disdong.virtual.drivers.pubsub.module.drivingdirection.constant.Constants.TOPIC_CURRENT_POSITION
import kr.disdong.virtual.drivers.pubsub.module.drivingdirection.dto.CurrentPositionResponse
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class CurrentPositionPublisher(
    private val redisTemplate: RedisTemplate<String, CurrentPositionResponse>
) {

    fun publish(currentPositionResponse: CurrentPositionResponse) {
        redisTemplate.convertAndSend(TOPIC_CURRENT_POSITION, currentPositionResponse)
    }
}
