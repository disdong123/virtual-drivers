package kr.disdong.virtual.drivers.domain.module.drivingdirection.model

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position

interface PlainDrivingDirectionRoute : DrivingDirectionRouteData

interface DrivingDirectionRoute : DrivingDirectionRouteData

interface DrivingDirectionRouteData {
    val id: Long
    val directionId: Long
    val order: Int
    val subRoutes: List<Position>
}
