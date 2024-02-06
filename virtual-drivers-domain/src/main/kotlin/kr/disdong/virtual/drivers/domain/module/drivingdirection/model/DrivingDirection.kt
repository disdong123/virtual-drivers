package kr.disdong.virtual.drivers.domain.module.drivingdirection.model

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import java.time.ZonedDateTime

interface PlainDrivingDirection : DrivingDirectionData

interface DrivingDirection : DrivingDirectionData

interface DrivingDirectionData {
    val id: Long
    val startAddress: String
    val startPosition: Position
    val startAt: ZonedDateTime
    val endAddress: String
    val endPosition: Position
    val endAt: ZonedDateTime
    val distance: Int
    val duration: Int
    val carId: Long
}
