package kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.DrivingDirectionEntity
import java.time.ZonedDateTime

class DrivingDirectionImpl(
    private val entity: DrivingDirectionEntity,
) : DrivingDirection {
    override val id: Long
        get() = entity.id
    override val startAddress: String
        get() = entity.startAddress
    override val startPosition: Position
        get() = Position(entity.startLatitude, entity.startLongitude)
    override val endPosition: Position
        get() = Position(entity.endLatitude, entity.endLongitude)
    override val startAt: ZonedDateTime
        get() = entity.startAt
    override val endAddress: String
        get() = entity.endAddress
    override val endAt: ZonedDateTime
        get() = entity.endAt
    override val distance: Int
        get() = entity.distance
    override val duration: Int
        get() = entity.duration
    override val carId: Long
        get() = entity.carId
}
