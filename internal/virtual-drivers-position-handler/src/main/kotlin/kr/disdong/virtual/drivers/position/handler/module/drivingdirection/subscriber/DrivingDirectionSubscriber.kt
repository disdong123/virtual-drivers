package kr.disdong.virtual.drivers.position.handler.module.drivingdirection.subscriber

import com.fasterxml.jackson.databind.ObjectMapper
import kr.disdong.virtual.drivers.common.logger.logger
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Component

@Component
class DrivingDirectionSubscriber(
    private val objectMapper: ObjectMapper,
) : MessageListener {
    private val logger = logger<DrivingDirectionSubscriber>()
    companion object {
        private const val DATABASE = "virtual_drivers"
        private const val TABLE = "driving_direction"
        private const val TYPE = "insert"
    }

    /**
     * TODO
     *  current position 에 대한 관리는 이 서버에서 진행합니다.
     *  PositionInfo 캐싱도 여기서 하도록 합니다.
     */
    override fun onMessage(message: Message, pattern: ByteArray?) {
        logger.info("message: ${String(message.body)}")
        logger.info("pattern: ${String(pattern!!)}")

        // TODO
        //  Get DrivingDirectionRoute
        //  Cache PositionInfo
    }
}

data class MaxwellMessageBody(
    val database: String,
    val table: String,
    val type: String,
    val ts: Long,
    val xid: Long,
    val commit: Boolean,
    val data: Any,
)
