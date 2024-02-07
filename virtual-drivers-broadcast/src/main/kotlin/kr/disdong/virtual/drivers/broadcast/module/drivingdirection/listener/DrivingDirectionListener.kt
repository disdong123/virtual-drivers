package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.listener

import kr.disdong.virtual.drivers.common.logger.logger
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfoCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DrivingDirectionListener(
    private val simpMessagingTemplate: SimpMessagingTemplate,
    private val nextPositionFinder: NextPositionFinder,
) {

    private val logger = logger<DrivingDirectionListener>()

    @Scheduled(fixedRate = 1000)
    fun sentToPosition() {
        logger.info("sentToPosition. hello")
        nextPositionFinder.find()
    }
}

@Component
class NextPositionFinder(
    private val nextPositionInfoCache: NextPositionInfoCache,
    private val drivingDirectionRepository: DrivingDirectionRepository,
    private val simpMessagingTemplate: SimpMessagingTemplate,
) {
    fun find() {
        val nextPositionInfos = nextPositionInfoCache.get()
        val drivingDirectionRoutes = drivingDirectionRepository.findCurrentRoutes(nextPositionInfos.map { Pair(it.directionId, it.routeOrder) })
        val newNextPositionInfos = mutableListOf<NextPositionInfo>()

        nextPositionInfos.map { nextPositionInfo ->
            val route = drivingDirectionRoutes.find { it.directionId == nextPositionInfo.directionId && it.order == nextPositionInfo.routeOrder }
            println("route: ${route?.id} ${route?.subRoutes}")
            val nextPosition = route!!.subRoutes[nextPositionInfo.index]

            if (nextPositionInfo.index + 1 < route.subRoutes.size) {
                newNextPositionInfos.add(nextPositionInfo.copy(index = nextPositionInfo.index + 1))
            } else {
                newNextPositionInfos.add(nextPositionInfo.copy(routeOrder = nextPositionInfo.routeOrder + 1, index = 0))
            }

            simpMessagingTemplate.convertAndSend("/driving-direction/position", nextPosition)

            if (nextPosition == nextPositionInfo.endPosition) {
                route.finish()
            }
        }

        nextPositionInfoCache.put(newNextPositionInfos)
    }
}

class TestMessage(
    val message: String
)
