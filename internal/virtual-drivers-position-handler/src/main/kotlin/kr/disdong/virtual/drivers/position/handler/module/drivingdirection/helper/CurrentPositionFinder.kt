package kr.disdong.virtual.drivers.position.handler.module.drivingdirection.helper

import kr.disdong.virtual.drivers.common.exception.ShouldDefineVdException
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfoCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.pubsub.module.drivingdirection.dto.CurrentPositionResponse
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CurrentPositionFinder(
    private val positionInfoCache: PositionInfoCache,
    private val drivingDirectionRepository: DrivingDirectionRepository,
) {

    @Transactional
    fun findAll(): List<CurrentPositionResponse> {
        val currentPositionInfos = positionInfoCache.getAll()
        val currentRoutesMap = drivingDirectionRepository.findCurrentRoutes(currentPositionInfos.map { it.toRouteKey() })
            .associateBy { it.routeKey }
        val drivingDirectionsMap = drivingDirectionRepository.findAllByIds(currentRoutesMap.values.map { it.routeKey.directionId })
            .associateBy { it.id }

        val nextPositionInfos = mutableListOf<PositionInfo>()
        val currentPositionResponses = currentPositionInfos.map { currentPositionInfo ->
            val route = currentRoutesMap[currentPositionInfo.toRouteKey()] ?: throw ShouldDefineVdException()
            val currentPosition = route.subRoutes[currentPositionInfo.index]

            if (currentPositionInfo.isEndPosition(currentPosition)) {
                (drivingDirectionsMap[route.routeKey.directionId] ?: throw ShouldDefineVdException()).finish()
            } else {
                nextPositionInfos.add(currentPositionInfo.getNextPositionInfo(route.subRoutes.size))
            }

            CurrentPositionResponse(currentPositionInfo.directionId, currentPosition)
        }

        positionInfoCache.deleteAndAddAll(nextPositionInfos)
        return currentPositionResponses
    }
}
