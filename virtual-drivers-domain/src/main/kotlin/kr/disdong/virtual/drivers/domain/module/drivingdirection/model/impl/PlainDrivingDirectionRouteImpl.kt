package kr.disdong.virtual.drivers.domain.module.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.RouteKey

class PlainDrivingDirectionRouteImpl(
    override val id: Long = 0,
    override val routeKey: RouteKey,
    override val subRoutes: List<Position>,
) : PlainDrivingDirectionRoute
