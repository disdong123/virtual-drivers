package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.DrivingDirectionRouteLocalCache
import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.NextPositionInfoCaffeineCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfoCache
import org.springframework.stereotype.Component

@Component
class NextPositionInfoCacheImpl(
    private val drivingDirectionRouteLocalCache: DrivingDirectionRouteLocalCache,
    private val nextPositionInfoCaffeineCache: NextPositionInfoCaffeineCache,
) : NextPositionInfoCache {
    override fun get(): List<NextPositionInfo> {
        return nextPositionInfoCaffeineCache.get()
    }

    override fun add(value: NextPositionInfo) {
        val nextPosition = get().toMutableList()
        nextPosition.add(value)
        put(nextPosition)
    }

    override fun put(values: List<NextPositionInfo>) {
        nextPositionInfoCaffeineCache.put(values)
    }
}
