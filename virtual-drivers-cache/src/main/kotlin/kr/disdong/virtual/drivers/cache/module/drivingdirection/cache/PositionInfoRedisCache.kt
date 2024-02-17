package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import org.springframework.context.annotation.Profile
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class PositionInfoRedisCache(
    private val redisTemplate: RedisTemplate<String, PositionInfo>
) {
    companion object {
        private const val key = "position-info"
    }
    fun get(): List<PositionInfo> {
        return redisTemplate.opsForList().range(key, 0, -1) ?: emptyList()
    }

    fun add(value: PositionInfo) {
        redisTemplate.opsForList().rightPush(key, value)
    }

    fun deleteAndAddAll(value: List<PositionInfo>): Long? {
        delete()
        if (value.isEmpty()) {
            return 0
        }

        return redisTemplate.opsForList().rightPushAll(key, value)
    }

    fun delete() {
        redisTemplate.delete(key)
    }

    /**
     * TODO 테스트 용
     *
     * @return
     */
    @Profile("test")
    fun flushAll() {
        redisTemplate.connectionFactory!!.connection.flushAll()
    }
}
