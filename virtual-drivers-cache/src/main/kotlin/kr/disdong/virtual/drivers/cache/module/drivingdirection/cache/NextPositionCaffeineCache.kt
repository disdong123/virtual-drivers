package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionFinder
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.cache.CacheManager
import org.springframework.cache.caffeine.CaffeineCache
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.stereotype.Component

@Component
class NextPositionCaffeineCache(
    @Qualifier("caffeineCacheManager")
    private val caffeineCacheManager: CacheManager,
) {
    private val cache = (caffeineCacheManager as CaffeineCacheManager).getCache("virtual-drivers-caffeine-cache")!! as CaffeineCache

    companion object {
        private const val key = "next-position"
    }
    fun get(): List<NextPositionFinder> {
        return (cache.get(key, List::class.java) ?: emptyList<NextPositionFinder>()) as List<NextPositionFinder>
    }

    fun put(value: List<NextPositionFinder>) {
        cache.put(key, value)
    }
}
