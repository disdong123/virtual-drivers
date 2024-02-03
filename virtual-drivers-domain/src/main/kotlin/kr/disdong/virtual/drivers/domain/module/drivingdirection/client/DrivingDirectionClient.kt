package kr.disdong.virtual.drivers.domain.module.drivingdirection.client

import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.impl.PlainDrivingDirectionImpl
import java.time.ZonedDateTime

interface DrivingDirectionClient {

    fun getDrivingDirection(request: DrivingDirectionApiRequest): DrivingDirectionApiResponse
}

data class DrivingDirectionApiRequest(
    val startPosition: Position,
    val endPosition: Position,
)

data class DrivingDirectionApiResponse(
    val startPosition: Position,
    val endPosition: Position,
    val distance: Distance,
    val duration: Duration,
    val departureTime: ZonedDateTime,
    val route: List<Position>,
) {

    fun toPlainDrivingDirection(startAddress: String, endAddress: String): PlainDrivingDirection {
        return PlainDrivingDirectionImpl(
            startAddress = startAddress,
            endAddress = endAddress,
            startPosition = startPosition,
            endPosition = endPosition,
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
