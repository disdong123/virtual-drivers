package kr.disdong.virtual.drivers.domain.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.RouteKey

interface PositionInfoCache {

    fun get(): List<PositionInfo>
    fun add(value: PositionInfo)
    fun addAll(values: List<PositionInfo>)
}

data class PositionInfo(
    val directionId: Long,
    val routeOrder: Int = 0,
    val index: Int = 0,
    val endPosition: Position,
) {
    fun toRouteKey(): RouteKey {
        return RouteKey(directionId, routeOrder)
    }

    fun isEndPosition(position: Position): Boolean {
        return position == endPosition
    }

    fun getNextPositionInfo(subRouteSize: Int): PositionInfo {
        return if (index + 1 < subRouteSize) {
            copy(index = index + 1)
        } else {
            copy(routeOrder = routeOrder + 1, index = 0)
        }
    }
}
