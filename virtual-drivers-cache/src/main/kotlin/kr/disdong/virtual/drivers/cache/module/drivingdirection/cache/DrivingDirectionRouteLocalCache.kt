package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.springframework.cache.CacheManager
import org.springframework.stereotype.Component

@Component
class DrivingDirectionRouteLocalCache(
    private val cacheManager: CacheManager,
) {
    private val cache = cacheManager.getCache("virtual-drivers-default-cache")!!

    fun get(key: String): List<Position> {
        return cache.get(key, List::class.java) as List<Position>? ?: emptyList()
    }

    fun put(key: String, value: List<Position>) {
        cache.put(key, value)
    }
}
