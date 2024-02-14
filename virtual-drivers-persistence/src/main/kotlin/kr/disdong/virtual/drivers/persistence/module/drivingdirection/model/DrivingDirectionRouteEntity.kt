package kr.disdong.virtual.drivers.persistence.module.drivingdirection.model

import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.Lob
import jakarta.persistence.Table
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.persistence.common.model.BaseEntity
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.converter.DrivingDirectionRouteConverter
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.impl.DrivingDirectionRouteImpl

@Entity(name = "driving_direction_route")
@Table(name = "driving_direction_route", indexes = [Index(name = "idx_direction_id_route_order", columnList = "directionId, routeOrder", unique = true)])
class DrivingDirectionRouteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column
    val directionId: Long,

    @Column
    val routeOrder: Int,

    @Convert(converter = DrivingDirectionRouteConverter::class)
    @Column
    @Lob
    val subRoutes: List<Position>
) : BaseEntity() {
    companion object {
        fun of(plainDrivingDirectionRoute: PlainDrivingDirectionRoute): DrivingDirectionRouteEntity {
            return DrivingDirectionRouteEntity(
                directionId = plainDrivingDirectionRoute.routeKey.directionId,
                routeOrder = plainDrivingDirectionRoute.routeKey.order,
                subRoutes = plainDrivingDirectionRoute.subRoutes,
            )
        }
    }

    fun toDrivingDirectionRoute(): DrivingDirectionRoute {
        return DrivingDirectionRouteImpl(this)
    }
}
