package kr.disdong.virtual.drivers.domain.module.drivingdirection.client

import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.impl.PlainDrivingDirectionImpl
import java.time.ZonedDateTime

interface DrivingDirectionClient {

    fun getDrivingDirection(request: DrivingDirectionApiRequest): DrivingDirectionApiResponse
}

data class DrivingDirectionApiRequest(
    val start: Position,
    val goal: Position,
)

data class DrivingDirectionApiResponse(
    val start: Position,
    val goal: Position,
    val distance: Distance,
    val duration: Duration,
    val departureTime: ZonedDateTime,
    val route: List<Position>,
) {

    fun toPlainDrivingDirection(): PlainDrivingDirection {
        return PlainDrivingDirectionImpl(
            startPosition = start,
            endPosition = goal,
            startAt = departureTime,
            endAt = departureTime.plusSeconds(duration.value.toLong()),
            distance = distance.value,
            duration = duration.value,
            route = route,
            carId = 0,
        )
    }
}

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
