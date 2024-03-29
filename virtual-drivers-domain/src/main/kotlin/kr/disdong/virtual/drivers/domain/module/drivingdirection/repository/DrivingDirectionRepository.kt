package kr.disdong.virtual.drivers.domain.module.drivingdirection.repository

import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.RouteKey

interface DrivingDirectionRepository {
    fun findById(id: Long): DrivingDirection?
    fun findAllByIds(ids: List<Long>): List<DrivingDirection>
    fun findCurrentRoutes(keys: List<RouteKey>): List<DrivingDirectionRoute>
    fun save(drivingDirection: PlainDrivingDirection): DrivingDirection
    fun saveRoutes(drivingDirectionRoutes: List<PlainDrivingDirectionRoute>): List<DrivingDirectionRoute>
}
