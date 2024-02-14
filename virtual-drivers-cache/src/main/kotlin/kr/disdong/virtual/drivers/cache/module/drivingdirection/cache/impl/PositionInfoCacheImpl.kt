package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.PositionInfoRedisCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfoCache
import org.springframework.stereotype.Component

@Component
class PositionInfoCacheImpl(
    private val positionInfoRedisCache: PositionInfoRedisCache,
) : PositionInfoCache {
    override fun getAll(): List<PositionInfo> {
        return positionInfoRedisCache.get()
    }

    override fun add(value: PositionInfo) {
        val position = getAll().toMutableList()
        position.add(value)
        addAll(position)
    }

    override fun addAll(values: List<PositionInfo>) {
        positionInfoRedisCache.addAll(values)
    }
}
