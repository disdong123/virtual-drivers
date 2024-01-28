package kr.disdong.virtual.drivers.domain.module.drivingdirection.client

import java.time.ZonedDateTime

interface DrivingDirectionClient {

    fun getDrivingDirection(request: DrivingDirectionRequest): DrivingDirectionResponse
}

data class DrivingDirectionRequest(
    val start: Position,
    val goal: Position,
)

data class DrivingDirectionResponse(
    val start: Position,
    val goal: Position,
    val distance: Distance,
    val duration: Duration,
    val departureTime: ZonedDateTime,
    val route: List<Position>,
)

data class Position(
    val latitude: Double,
    val longitude: Double,
)

data class Duration(
    val value: Int,
)

data class Distance(
    val value: Int,
)

data class Price(
    val value: Int,
)
