package kr.disdong.virtual.drivers.domain.module.drivingdirection.model

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import java.time.ZonedDateTime

interface PlainDrivingDirection : DrivingDirectionData

interface DrivingDirection : DrivingDirectionData

interface DrivingDirectionData {
    val id: Long
    val startPosition: Position
    val endPosition: Position
    val startAt: ZonedDateTime
    val endAt: ZonedDateTime
    val distance: Int
    val duration: Int
    val route: List<Position>
    val carId: Long
}
