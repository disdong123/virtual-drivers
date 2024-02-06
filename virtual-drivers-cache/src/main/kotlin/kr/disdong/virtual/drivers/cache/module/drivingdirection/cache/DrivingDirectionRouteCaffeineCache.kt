package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCache
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.stereotype.Component

@Component
class DrivingDirectionRouteCaffeineCache(
    @Qualifier("caffeineCacheManager")
    private val caffeineCacheManager: CacheManager,
) {
    private val cache = (caffeineCacheManager as CaffeineCacheManager).getCache("virtual-drivers-caffeine-cache")!! as CaffeineCache

    fun get(key: String): List<Position> {
        return cache.get(key, List::class.java) as List<Position>? ?: emptyList()
    }

    fun getAll(): List<List<Position>> {
        return cache.nativeCache.asMap().values.toList() as List<List<Position>>
    }

    fun put(key: String, value: List<Position>) {
        cache.put(key, value)
    }
}
