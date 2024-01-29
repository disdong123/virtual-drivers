package kr.disdong.virtual.drivers.server.module.drivingdirection.dto

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionApiRequest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
data class GetDrivingDirectionRequest(
    val startLatitude: Double,
    val startLongitude: Double,
    val goalLatitude: Double,
    val goalLongitude: Double,
) {

    fun toDrivingDirectionRequest() = DrivingDirectionApiRequest(
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
    val route: List<Position>,
) {

    companion object {

        fun from(response: DrivingDirection): GetDrivingDirectionResponse {
            return GetDrivingDirectionResponse(
                start = response.startPosition,
                goal = response.startPosition,
                distance = response.distance,
                duration = response.duration,
                route = response.route,
            )
        }
    }
}
