package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.helper

import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfo

object NextPositionInfoFinder {

    fun find(currentPositionInfo: NextPositionInfo, subRouteSize: Int): NextPositionInfo {
        return if (currentPositionInfo.index + 1 < subRouteSize) {
            currentPositionInfo.copy(index = currentPositionInfo.index + 1)
        } else {
            currentPositionInfo.copy(routeOrder = currentPositionInfo.routeOrder + 1, index = 0)
        }
    }
}
