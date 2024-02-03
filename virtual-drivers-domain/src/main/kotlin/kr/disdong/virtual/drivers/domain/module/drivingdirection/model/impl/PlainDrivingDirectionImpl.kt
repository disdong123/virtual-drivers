package kr.disdong.virtual.drivers.domain.module.drivingdirection.model.impl

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection
import java.time.ZonedDateTime

class PlainDrivingDirectionImpl(
    override val id: Long = 0,
    override val startAddress: String,
    override val endAddress: String,
    override val startPosition: Position,
    override val endPosition: Position,
    override val startAt: ZonedDateTime,
    override val endAt: ZonedDateTime,
    override val distance: Int,
    override val duration: Int,
    override val route: List<Position>,
    override val carId: Long,
) : PlainDrivingDirection
