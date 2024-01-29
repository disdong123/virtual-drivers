package kr.disdong.virtual.drivers.domain.module.drivingdirection.repository

import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection

interface DrivingDirectionRepository {
    fun findById(id: Long): DrivingDirection
    fun save(drivingDirection: PlainDrivingDirection): DrivingDirection
}
