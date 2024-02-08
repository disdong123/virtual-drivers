package kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.RouteKey
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.DrivingDirectionRouteEntity

class DrivingDirectionRouteImpl(
    private val entity: DrivingDirectionRouteEntity,
) : DrivingDirectionRoute {
    override val id: Long
        get() = entity.id
    override val routeKey: RouteKey
        get() = RouteKey(entity.directionId, entity.routeOrder)
    override val subRoutes: List<Position>
        get() = entity.subRoutes

    override fun finish() {
        entity.isDeleted = true
    }
}
