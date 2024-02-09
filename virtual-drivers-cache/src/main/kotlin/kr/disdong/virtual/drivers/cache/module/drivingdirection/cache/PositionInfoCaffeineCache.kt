package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCache
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.stereotype.Component

@Component
class PositionInfoCaffeineCache(
    @Qualifier("caffeineCacheManager")
    private val caffeineCacheManager: CacheManager,
) {
    private val cache = (caffeineCacheManager as CaffeineCacheManager).getCache("virtual-drivers-caffeine-cache")!! as CaffeineCache

    companion object {
        private const val key = "next-position"
    }
    fun get(): List<PositionInfo> {
        return (cache.get(key, List::class.java) ?: emptyList<PositionInfo>()) as List<PositionInfo>
    }

    fun put(value: List<PositionInfo>) {
        cache.put(key, value)
    }
}
