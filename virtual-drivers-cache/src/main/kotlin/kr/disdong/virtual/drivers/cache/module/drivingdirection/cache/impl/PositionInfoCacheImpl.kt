package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.DrivingDirectionRouteLocalCache
import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.PositionInfoCaffeineCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfoCache
import org.springframework.stereotype.Component

@Component
class PositionInfoCacheImpl(
    private val drivingDirectionRouteLocalCache: DrivingDirectionRouteLocalCache,
    private val positionInfoCaffeineCache: PositionInfoCaffeineCache,
) : PositionInfoCache {
    override fun get(): List<PositionInfo> {
        return positionInfoCaffeineCache.get()
    }

    override fun add(value: PositionInfo) {
        val position = get().toMutableList()
        position.add(value)
        put(position)
    }

    override fun put(values: List<PositionInfo>) {
        positionInfoCaffeineCache.put(values)
    }
}
