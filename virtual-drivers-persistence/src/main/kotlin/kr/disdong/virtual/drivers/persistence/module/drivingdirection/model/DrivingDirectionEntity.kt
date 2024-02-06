package kr.disdong.virtual.drivers.persistence.module.drivingdirection.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.persistence.common.model.BaseEntity
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.impl.DrivingDirectionImpl
import java.time.ZonedDateTime

@Entity(name = "driving_direction")
class DrivingDirectionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(
        nullable = false,
        unique = false,
    )
    val startAddress: String,

    @Column(
        nullable = false,
        unique = false,
    )
    val endAddress: String,

    @Column(
        nullable = false,
        unique = false,
    )
    val startLatitude: Double,

    @Column(
        nullable = false,
        unique = false,
    )
    val startLongitude: Double,

    @Column(
        nullable = false,
        unique = false,
    )
    val endLatitude: Double,

    @Column(
        nullable = false,
        unique = false,
    )
    val endLongitude: Double,

    @Column(
        nullable = false,
        unique = false,
    )
    val startAt: ZonedDateTime,

    @Column(
        nullable = false,
        unique = false,
    )
    val endAt: ZonedDateTime,

    @Column(
        nullable = false,
        unique = false,
    )
    val distance: Int,

    @Column(
        nullable = false,
        unique = false,
    )
    val duration: Int,

    @Column(
        nullable = false,
        unique = false,
    )
    val carId: Long,
) : BaseEntity() {
    companion object {
        fun of(drivingDirection: PlainDrivingDirection): DrivingDirectionEntity {
            return DrivingDirectionEntity(
                startAddress = drivingDirection.startAddress,
                endAddress = drivingDirection.endAddress,
                startLatitude = drivingDirection.startPosition.latitude,
                startLongitude = drivingDirection.startPosition.longitude,
                endLatitude = drivingDirection.endPosition.latitude,
                endLongitude = drivingDirection.endPosition.longitude,
                startAt = drivingDirection.startAt,
                endAt = drivingDirection.endAt,
                distance = drivingDirection.distance,
                duration = drivingDirection.duration,
                carId = drivingDirection.carId,
            )
        }
    }

    fun toDrivingDirection(): DrivingDirection {
        return DrivingDirectionImpl(this)
    }
}
