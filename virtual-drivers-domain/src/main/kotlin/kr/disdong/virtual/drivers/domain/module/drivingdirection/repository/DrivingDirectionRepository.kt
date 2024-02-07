package kr.disdong.virtual.drivers.domain.module.drivingdirection.repository

import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirectionRoute

interface DrivingDirectionRepository {
    fun findById(id: Long): DrivingDirection?
    fun findCurrentRoutes(pairs: List<Pair<Long, Int>>): List<DrivingDirectionRoute>
    fun save(drivingDirection: PlainDrivingDirection): DrivingDirection
    fun saveRoutes(drivingDirectionRoutes: List<PlainDrivingDirectionRoute>): List<DrivingDirectionRoute>
}
