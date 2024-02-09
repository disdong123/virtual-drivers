package kr.disdong.virtual.drivers.persistence.module.drivingdirection.repository.impl

import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.RouteKey
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.DrivingDirectionEntity
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.DrivingDirectionRouteEntity
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.repository.DrivingDirectionJpaRepository
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.repository.DrivingDirectionRouteJpaRepository
import org.springframework.stereotype.Repository

@Repository
class DrivingDirectionRepositoryImpl(
    private val drivingDirectionJpaRepository: DrivingDirectionJpaRepository,
    private val drivingDirectionRouteJpaRepository: DrivingDirectionRouteJpaRepository
) : DrivingDirectionRepository {
    override fun findById(id: Long): DrivingDirection? {
        return drivingDirectionJpaRepository.findById(id).orElse(null)?.toDrivingDirection()
    }

    override fun findAllByIds(ids: List<Long>): List<DrivingDirection> {
        return drivingDirectionJpaRepository.findAllById(ids).map { it.toDrivingDirection() }
    }

    override fun findCurrentRoutes(pairs: List<RouteKey>): List<DrivingDirectionRoute> {
        return drivingDirectionRouteJpaRepository.findCurrentRoutes(pairs).map { it.toDrivingDirectionRoute() }
    }

    override fun save(drivingDirection: PlainDrivingDirection): DrivingDirection {
        return drivingDirectionJpaRepository.save(DrivingDirectionEntity.of(drivingDirection)).toDrivingDirection()
    }

    override fun saveRoutes(drivingDirectionRoutes: List<PlainDrivingDirectionRoute>): List<DrivingDirectionRoute> {
        return drivingDirectionRouteJpaRepository.saveAll(
            drivingDirectionRoutes.map { route ->
                DrivingDirectionRouteEntity.of(route)
            }
        ).map { it.toDrivingDirectionRoute() }
    }
}
