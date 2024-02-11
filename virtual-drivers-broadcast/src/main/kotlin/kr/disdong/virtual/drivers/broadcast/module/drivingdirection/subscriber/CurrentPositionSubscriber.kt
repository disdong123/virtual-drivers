package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.subscriber

import com.google.gson.Gson
import kr.disdong.virtual.drivers.broadcast.module.drivingdirection.publisher.CurrentPositionPublisher
import kr.disdong.virtual.drivers.pubsub.module.drivingdirection.dto.CurrentPositionResponse
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Component

@Component
class CurrentPositionSubscriber(
    private val gson: Gson,
    private val currentPositionPublisher: CurrentPositionPublisher,
) : MessageListener {
    override fun onMessage(message: Message, pattern: ByteArray?) {
        currentPositionPublisher.publish(gson.fromJson(String(message.body), CurrentPositionResponse::class.java))
    }
}
