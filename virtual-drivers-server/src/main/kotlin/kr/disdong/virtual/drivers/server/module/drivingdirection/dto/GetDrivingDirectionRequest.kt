package kr.disdong.virtual.drivers.server.module.drivingdirection.dto

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionApiRequest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
data class GetDrivingDirectionRequest(
    val startAddress: String,
    val startLatitude: Double,
    val startLongitude: Double,
    val endAddress: String,
    val endLatitude: Double,
    val endLongitude: Double,
) {

    fun toDrivingDirectionRequest() = DrivingDirectionApiRequest(
        startPosition = Position(
            latitude = startLatitude,
            longitude = startLongitude,
        ),
        endPosition = Position(
            latitude = endLatitude,
            longitude = endLongitude,
        )
    )
}

data class GetDrivingDirectionResponse(
    val startPosition: Position,
    val endPosition: Position,
    val distance: Int,
    val duration: Int,
    val route: List<Position>,
) {

    companion object {

        fun of(response: DrivingDirection, route: List<Position>): GetDrivingDirectionResponse {
            return GetDrivingDirectionResponse(
                startPosition = response.startPosition,
                endPosition = response.startPosition,
                distance = response.distance,
                duration = response.duration,
                route = route,
            )
        }
    }
}
