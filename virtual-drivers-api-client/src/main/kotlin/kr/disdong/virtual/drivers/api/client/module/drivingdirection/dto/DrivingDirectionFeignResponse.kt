package kr.disdong.virtual.drivers.api.client.module.drivingdirection.dto

import com.fasterxml.jackson.annotation.JsonFormat
import kr.disdong.virtual.drivers.common.exception.VdException
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Distance
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionApiResponse
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Duration
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import java.time.ZonedDateTime

data class DrivingDirectionFeignResponse(
    val code: Int,
    val message: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    val currentDateTime: ZonedDateTime?,
    val route: Route?,
) {

    fun toDrivingDirectionResponse(): DrivingDirectionApiResponse {
        if (route == null) {
            throw InvalidDrivingDirectionResponseException(message)
        }

        val routeData = route.trafast.first()
        return DrivingDirectionApiResponse(
            startPosition = Position(
                latitude = routeData.summary.start.location.last(),
                longitude = routeData.summary.start.location.first(),
            ),
            endPosition = Position(
                latitude = routeData.summary.goal.location.last(),
                longitude = routeData.summary.goal.location.first(),
            ),
            distance = Distance(
                value = routeData.summary.distance,
            ),
            duration = Duration(
                value = routeData.summary.duration,
            ),
            departureTime = routeData.summary.departureTime,
            route = routeData.path.map {
                Position(
                    latitude = it.last(),
                    longitude = it.first(),
                )
            },
        )
    }

    data class Route(
        val trafast: List<RouteData>,
    ) {
        data class RouteData(
            val summary: Summary,
            val path: List<List<Double>>,
        )

        data class Summary(
            val start: LocationSummary,
            val goal: LocationSummary,
            val distance: Int,
            val duration: Int,
            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
            val departureTime: ZonedDateTime,
            val bbox: List<List<Double>>,
            val tollFare: Int,
            val taxiFare: Int,
            val fuelPrice: Int,
        ) {

            data class LocationSummary(
                val location: List<Double>,
            )
        }
    }
}

class InvalidDrivingDirectionResponseException(
    message: String,
) : VdException(message) {
    override fun getCode(): Int {
        return 404
    }
}
