package kr.disdong.virtual.drivers.domain.module.drivingdirection.model

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position

interface PlainDrivingDirectionRoute : DrivingDirectionRouteData

interface DrivingDirectionRoute : DrivingDirectionRouteData {
    fun finish()
}

interface DrivingDirectionRouteData {
    val id: Long
    val routeKey: RouteKey
    val subRoutes: List<Position>
}

data class RouteKey(val directionId: Long, val order: Int)
