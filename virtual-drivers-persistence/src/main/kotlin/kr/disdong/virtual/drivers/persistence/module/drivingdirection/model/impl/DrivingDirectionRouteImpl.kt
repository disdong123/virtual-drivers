package kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirectionRoute

class DrivingDirectionRouteImpl(
    override val id: Long,
    override val directionId: Long,
    override val order: Int,
    override val subRoutes: List<Position>
) : DrivingDirectionRoute
