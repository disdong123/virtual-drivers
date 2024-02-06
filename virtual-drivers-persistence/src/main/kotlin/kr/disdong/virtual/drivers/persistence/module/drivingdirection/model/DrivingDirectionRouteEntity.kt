package kr.disdong.virtual.drivers.persistence.module.drivingdirection.model

import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.persistence.common.model.BaseEntity
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.converter.DrivingDirectionRouteConverter
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.impl.DrivingDirectionRouteImpl

@Entity(name = "driving_direction_route")
class DrivingDirectionRouteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column
    val directionId: Long,

    @Column
    val routeOrder: Int,

    @Convert(converter = DrivingDirectionRouteConverter::class)
    @Column(
        nullable = false,
        unique = false,
        columnDefinition = "TEXT"
    )
    val subRoutes: List<Position>
) : BaseEntity() {
    companion object {
        fun of(plainDrivingDirectionRoute: PlainDrivingDirectionRoute): DrivingDirectionRouteEntity {
            return DrivingDirectionRouteEntity(
                directionId = plainDrivingDirectionRoute.directionId,
                routeOrder = plainDrivingDirectionRoute.order,
                subRoutes = plainDrivingDirectionRoute.subRoutes,
            )
        }
    }

    fun toDrivingDirectionRoute(): DrivingDirectionRoute {
        return DrivingDirectionRouteImpl(
            id = id,
            directionId = directionId,
            order = routeOrder,
            subRoutes = subRoutes,
        )
    }
}
