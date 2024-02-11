package kr.disdong.virtual.drivers.broadcast.core.config

import kr.disdong.virtual.drivers.broadcast.module.drivingdirection.subscriber.CurrentPositionSubscriber
import kr.disdong.virtual.drivers.pubsub.module.drivingdirection.constant.Constants.TOPIC_CURRENT_POSITION
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer

@Configuration
class RedisBroadcastConfig(
    private val currentPositionSubscriber: CurrentPositionSubscriber
) {

    @Bean
    fun redisMessageListener(connectionFactory: RedisConnectionFactory): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            setConnectionFactory(connectionFactory)
            addMessageListener(currentPositionSubscriber, ChannelTopic(TOPIC_CURRENT_POSITION))
        }
    }
}
