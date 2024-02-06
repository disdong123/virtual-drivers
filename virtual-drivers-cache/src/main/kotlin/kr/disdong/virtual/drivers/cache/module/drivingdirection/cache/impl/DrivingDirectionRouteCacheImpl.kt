package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.DrivingDirectionRouteCaffeineCache
import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.DrivingDirectionRouteLocalCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.DrivingDirectionRouteCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.springframework.stereotype.Component

@Component
class DrivingDirectionRouteCacheImpl(
    private val drivingDirectionRouteLocalCache: DrivingDirectionRouteLocalCache,
    private val drivingDirectionRouteCaffeineCache: DrivingDirectionRouteCaffeineCache,
) : DrivingDirectionRouteCache {
    override fun get(startPosition: Position, endPosition: Position): List<Position> {
        val key = "${startPosition.latitude},${startPosition.longitude},${endPosition.latitude},${endPosition.longitude}"
        return drivingDirectionRouteCaffeineCache.get(key)
    }

    override fun getAll(): List<List<Position>> {
        return drivingDirectionRouteCaffeineCache.getAll()
    }

    override fun put(startPosition: Position, endPosition: Position, value: List<Position>) {
        val key = "${startPosition.latitude},${startPosition.longitude},${endPosition.latitude},${endPosition.longitude}"
        drivingDirectionRouteCaffeineCache.put(key, value)
    }
}
