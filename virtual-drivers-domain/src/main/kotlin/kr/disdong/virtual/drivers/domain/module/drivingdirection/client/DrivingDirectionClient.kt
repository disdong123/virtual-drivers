package kr.disdong.virtual.drivers.domain.module.drivingdirection.client

import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.PlainDrivingDirectionRoute
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.RouteKey
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.impl.PlainDrivingDirectionImpl
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.impl.PlainDrivingDirectionRouteImpl
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

    fun toPlainDrivingDirection(startAddress: String, endAddress: String, carId: Long): PlainDrivingDirection {
        return PlainDrivingDirectionImpl(
            startAddress = startAddress,
            endAddress = endAddress,
            startPosition = startPosition,
            endPosition = endPosition,
            startAt = departureTime,
            endAt = departureTime.plusSeconds(duration.value.toLong()),
            distance = distance.value,
            duration = duration.value,
            carId = carId,
        )
    }

    fun toPlainDrivingDirectionRoutes(directionId: Long): List<PlainDrivingDirectionRoute> {
        val SIZE = 100
        var temp = 0
        var order = 0
        val routes = mutableListOf<PlainDrivingDirectionRoute>()
        while (temp < route.size) {
            // Calculate the end index ensuring it doesn't go beyond the route's size
            val end = minOf(temp + SIZE, route.size)
            // Extract the sublist and create a new PlainDrivingDirectionRouteImpl with it
            val subRoute = route.subList(temp, end)
            routes.add(PlainDrivingDirectionRouteImpl(subRoutes = subRoute, routeKey = RouteKey(directionId = directionId, order = order++)))
            // Update temp to the end of the current sublist
            temp += SIZE
        }

        // Remove the following lines as they are no longer needed with the above correction
        // if (temp < route.size) {
        //     routes.add(PlainDrivingDirectionRouteImpl(subRoutes = route.subList(temp, route.size), directionId = directionId, order = order++))
        // }

        return routes
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
