package kr.disdong.virtual.drivers.cache.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.util.TimeZone

@Configuration
class RedisConfig(
    private val redisProperties: RedisProperties
) {

    @Bean
    fun redisMessageListener(connectionFactory: RedisConnectionFactory): RedisMessageListenerContainer {
        return RedisMessageListenerContainer().apply {
            setConnectionFactory(connectionFactory)
        }
    }

    @Bean
    fun userOauthRedisTemplate(
        redisConnectionFactory: RedisConnectionFactory
    ): RedisTemplate<String, PositionInfo> = createObjectRedisTemplate(redisConnectionFactory, PositionInfo::class.java)

    private fun <T : Any> createObjectRedisTemplate(connectionFactory: RedisConnectionFactory, classInfo: Class<T>): RedisTemplate<String, T> {
        return RedisTemplate<String, T>().apply {
            setConnectionFactory(connectionFactory)
            setEnableTransactionSupport(true)

            val objectMapper = ObjectMapper()
            objectMapper.registerModule(JavaTimeModule())
            objectMapper.registerKotlinModule()
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            objectMapper.enable(SerializationFeature.WRITE_DATES_WITH_ZONE_ID)
            objectMapper.setTimeZone(TimeZone.getDefault())

            keySerializer = StringRedisSerializer()
            valueSerializer = Jackson2JsonRedisSerializer(objectMapper, classInfo)
        }
    }
}
