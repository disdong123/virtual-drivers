package kr.disdong.virtual.drivers.persistence.module.drivingdirection.repository.impl

import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.DrivingDirectionEntity
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.repository.DrivingDirectionJpaRepository
import org.springframework.stereotype.Repository

@Repository
class DrivingDirectionRepositoryImpl(
    private val drivingDirectionJpaRepository: DrivingDirectionJpaRepository
) : DrivingDirectionRepository {
    override fun findById(id: Long): DrivingDirection {
        return drivingDirectionJpaRepository.findById(id).orElseThrow().toDrivingDirection()
    }

    override fun save(drivingDirection: PlainDrivingDirection): DrivingDirection {
        return drivingDirectionJpaRepository.save(DrivingDirectionEntity.of(drivingDirection)).toDrivingDirection()
    }
}
