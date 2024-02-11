package kr.disdong.virtual.drivers.position.handler.core

import kr.disdong.virtual.drivers.position.handler.module.drivingdirection.subscriber.DrivingDirectionSubscriber
import kr.disdong.virtual.drivers.pubsub.module.drivingdirection.constant.Constants.TOPIC_DIRECTION
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer

@Configuration
class RedisPositionHandlerConfig(
    private val drivingDirectionSubscriber: DrivingDirectionSubscriber
) {

    @Bean
    fun redisMessageListener(connectionFactory: RedisConnectionFactory): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            setConnectionFactory(connectionFactory)
            addMessageListener(drivingDirectionSubscriber, ChannelTopic(TOPIC_DIRECTION))
        }
    }
}
