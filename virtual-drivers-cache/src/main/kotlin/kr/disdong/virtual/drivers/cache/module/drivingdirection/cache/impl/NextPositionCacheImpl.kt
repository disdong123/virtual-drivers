package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.DrivingDirectionRouteLocalCache
import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.NextPositionCaffeineCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionFinder
import org.springframework.stereotype.Component

@Component
class NextPositionCacheImpl(
    private val drivingDirectionRouteLocalCache: DrivingDirectionRouteLocalCache,
    private val nextPositionCaffeineCache: NextPositionCaffeineCache,
) : NextPositionCache {
    override fun get(): List<NextPositionFinder> {
        return nextPositionCaffeineCache.get()
    }

    override fun add(value: NextPositionFinder) {
        val nextPosition = get().toMutableList()
        nextPosition.add(value)
        put(nextPosition)
    }

    override fun put(values: List<NextPositionFinder>) {
        nextPositionCaffeineCache.put(values)
    }
}
