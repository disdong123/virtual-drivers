package kr.disdong.virtual.drivers.cache.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig(
    private val redisProperties: RedisProperties
) {

    @Bean
    fun positionInfoRedisTemplate(
        redisConnectionFactory: RedisConnectionFactory
    ): RedisTemplate<String, PositionInfo> = createObjectRedisTemplate(redisConnectionFactory, PositionInfo::class.java)

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
