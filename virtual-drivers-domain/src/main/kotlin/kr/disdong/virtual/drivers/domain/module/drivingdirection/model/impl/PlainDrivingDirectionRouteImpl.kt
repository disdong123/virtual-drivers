package kr.disdong.virtual.drivers.domain.module.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirectionRoute

class PlainDrivingDirectionRouteImpl(
    override val id: Long = 0,
    override val directionId: Long,
    override val order: Int,
    override val subRoutes: List<Position>,
) : PlainDrivingDirectionRoute
