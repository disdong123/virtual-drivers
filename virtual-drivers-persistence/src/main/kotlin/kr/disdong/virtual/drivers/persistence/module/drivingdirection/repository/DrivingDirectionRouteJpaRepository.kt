package kr.disdong.virtual.drivers.persistence.module.drivingdirection.repository

import com.querydsl.core.BooleanBuilder
import com.querydsl.jpa.impl.JPAQueryFactory
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.RouteKey
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.DrivingDirectionRouteEntity
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.QDrivingDirectionRouteEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DrivingDirectionRouteJpaRepository : JpaRepository<DrivingDirectionRouteEntity, Long>, DrivingDirectionRouteCustomJpaRepository

interface DrivingDirectionRouteCustomJpaRepository {
    fun findCurrentRoutes(pairs: List<RouteKey>): List<DrivingDirectionRouteEntity>
}

class DrivingDirectionRouteCustomJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : DrivingDirectionRouteCustomJpaRepository {
    private val drivingDirectionRouteEntity = QDrivingDirectionRouteEntity.drivingDirectionRouteEntity
    override fun findCurrentRoutes(pairs: List<RouteKey>): List<DrivingDirectionRouteEntity> {
        val builder = BooleanBuilder()
        pairs.map {
            builder.or(
                drivingDirectionRouteEntity.directionId.eq(it.directionId)
                    .and(drivingDirectionRouteEntity.routeOrder.eq(it.order))
            )
        }

        return jpaQueryFactory
            .selectFrom(drivingDirectionRouteEntity)
            .where(
                builder,
                drivingDirectionRouteEntity.isDeleted.isFalse,
            )
            .fetch()
    }
}
