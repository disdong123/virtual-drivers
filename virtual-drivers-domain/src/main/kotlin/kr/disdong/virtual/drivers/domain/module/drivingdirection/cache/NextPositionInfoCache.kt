package kr.disdong.virtual.drivers.domain.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.RouteKey

interface NextPositionInfoCache {

    fun get(): List<NextPositionInfo>
    fun add(value: NextPositionInfo)
    fun put(values: List<NextPositionInfo>)
}

data class NextPositionInfo(
    val directionId: Long,
    val routeOrder: Int = 1,
    val index: Int = 0,
    val endPosition: Position,
) {
    fun toDrivingDirectionRouteKey(): RouteKey {
        return RouteKey(directionId, routeOrder)
    }
}
