package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.helper

import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfoCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import org.springframework.stereotype.Component

@Component
class NextPositionFinder(
    private val nextPositionInfoCache: NextPositionInfoCache,
    private val drivingDirectionRepository: DrivingDirectionRepository,
) {
    fun findAll(): List<NextPositionResponse> {
        val currentPositionInfos = nextPositionInfoCache.get()
        val drivingDirectionRoutes = drivingDirectionRepository.findCurrentRoutes(currentPositionInfos.map { it.toDrivingDirectionRouteKey() })
        val nextPositionInfos = mutableListOf<NextPositionInfo>()
        val nextPositions = currentPositionInfos.map { nextPositionInfo ->
            val route = drivingDirectionRoutes.find { it.routeKey == nextPositionInfo.toDrivingDirectionRouteKey() }
            val nextPosition = route!!.subRoutes[nextPositionInfo.index]

            nextPositionInfos.add(NextPositionInfoFinder.find(nextPositionInfo, route.subRoutes.size))
            if (nextPosition == nextPositionInfo.endPosition) {
                route.finish()
            }

            NextPositionResponse(nextPositionInfo.directionId, nextPosition)
        }

        nextPositionInfoCache.put(nextPositionInfos)

        return nextPositions
    }
}

data class NextPositionResponse(
    val directionId: Long,
    val nextPosition: Position,
)
