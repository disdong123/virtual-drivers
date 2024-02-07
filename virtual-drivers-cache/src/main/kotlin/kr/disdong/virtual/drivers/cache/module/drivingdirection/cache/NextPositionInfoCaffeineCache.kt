package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfo
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCache
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.stereotype.Component

@Component
class NextPositionInfoCaffeineCache(
    @Qualifier("caffeineCacheManager")
    private val caffeineCacheManager: CacheManager,
) {
    private val cache = (caffeineCacheManager as CaffeineCacheManager).getCache("virtual-drivers-caffeine-cache")!! as CaffeineCache

    companion object {
        private const val key = "next-position"
    }
    fun get(): List<NextPositionInfo> {
        return (cache.get(key, List::class.java) ?: emptyList<NextPositionInfo>()) as List<NextPositionInfo>
    }

    fun put(value: List<NextPositionInfo>) {
        cache.put(key, value)
    }
}
