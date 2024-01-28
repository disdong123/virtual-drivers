package kr.disdong.virtual.drivers.server.module.drivingdirection.dto

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionRequest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionResponse
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import java.time.ZonedDateTime
data class GetDrivingDirectionRequest(
    val startLatitude: Double,
    val startLongitude: Double,
    val goalLatitude: Double,
    val goalLongitude: Double,
) {

    fun toDrivingDirectionRequest() = DrivingDirectionRequest(
        start = Position(
            latitude = startLatitude,
            longitude = startLongitude,
        ),
        goal = Position(
            latitude = goalLatitude,
            longitude = goalLongitude,
        )
    )
}

data class GetDrivingDirectionResponse(
    val start: Position,
    val goal: Position,
    val distance: Int,
    val duration: Int,
    val departureTime: ZonedDateTime,
    val route: List<Position>,
) {

    companion object {

        fun from(response: DrivingDirectionResponse): GetDrivingDirectionResponse {
            return GetDrivingDirectionResponse(
                start = response.start,
                goal = response.goal,
                distance = response.distance.value,
                duration = response.duration.value,
                departureTime = response.departureTime,
                route = response.route,
            )
        }
    }
}
