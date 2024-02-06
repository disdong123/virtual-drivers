package kr.disdong.virtual.drivers.persistence.module.drivingdirection.repository

import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.DrivingDirectionRouteEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DrivingDirectionRouteJpaRepository : JpaRepository<DrivingDirectionRouteEntity, Long>
