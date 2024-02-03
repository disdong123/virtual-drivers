package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.DrivingDirectionRouteLocalCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.DrivingDirectionRouteCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.springframework.stereotype.Component

@Component
class DrivingDirectionRouteCacheImpl(
    private val drivingDirectionRouteLocalCache: DrivingDirectionRouteLocalCache,
) : DrivingDirectionRouteCache {
    override fun get(startPosition: Position, endPosition: Position): List<Position> {
        val key = "${startPosition.latitude},${startPosition.longitude},${endPosition.latitude},${endPosition.longitude}"
        return drivingDirectionRouteLocalCache.get(key)
    }

    override fun put(startPosition: Position, endPosition: Position, value: List<Position>) {
        val key = "${startPosition.latitude},${startPosition.longitude},${endPosition.latitude},${endPosition.longitude}"
        drivingDirectionRouteLocalCache.put(key, value)
    }
}
