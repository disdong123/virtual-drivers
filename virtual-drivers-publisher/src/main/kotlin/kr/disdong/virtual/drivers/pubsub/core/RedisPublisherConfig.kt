package kr.disdong.virtual.drivers.pubsub.core

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kr.disdong.virtual.drivers.pubsub.module.drivingdirection.dto.CurrentPositionResponse
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisPublisherConfig {

    @Bean
    fun currentPositionRedisTemplate(
        redisConnectionFactory: RedisConnectionFactory
    ): RedisTemplate<String, CurrentPositionResponse> = createObjectRedisTemplate(redisConnectionFactory, CurrentPositionResponse::class.java)

    private fun <T : Any> createObjectRedisTemplate(connectionFactory: RedisConnectionFactory, classInfo: Class<T>): RedisTemplate<String, T> {
        return RedisTemplate<String, T>().apply {
            setConnectionFactory(connectionFactory)
            setEnableTransactionSupport(true)

            val objectMapper = ObjectMapper()
            objectMapper.registerKotlinModule()

            keySerializer = StringRedisSerializer()
            valueSerializer = Jackson2JsonRedisSerializer(objectMapper, classInfo)
        }
    }
}
