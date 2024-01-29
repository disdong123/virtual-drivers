package kr.disdong.virtual.drivers.persistence.module.drivingdirection.repository

import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.DrivingDirectionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DrivingDirectionJpaRepository : JpaRepository<DrivingDirectionEntity, Long>
