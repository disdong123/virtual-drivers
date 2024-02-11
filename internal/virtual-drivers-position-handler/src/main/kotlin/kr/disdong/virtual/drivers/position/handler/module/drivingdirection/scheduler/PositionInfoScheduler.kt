package kr.disdong.virtual.drivers.position.handler.module.drivingdirection.scheduler

import kr.disdong.virtual.drivers.position.handler.module.drivingdirection.helper.CurrentPositionFinder
import kr.disdong.virtual.drivers.pubsub.module.drivingdirection.publisher.CurrentPositionPublisher
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class PositionInfoScheduler(
    private val currentPositionPublisher: CurrentPositionPublisher,
    private val currentPositionFinder: CurrentPositionFinder,
) {

    /**
     * 향후 실 주행 데이터를 이용하게 된다면 각 차량마다 독립적으로 현재 위치 정보가 발생됩니다.
     * 발생한 데이터를 실시간으로 publish 하는게 좋을지, 아니면 캐싱하여 주기적으로 한번에 publish 하는게 좋을지 테스트 해보면 좋을듯 합니다.
     * 비록 여기서는 실 주행데이터가 없어서 현재 위치 정보를 한번에 가져오지만 publish 는 실시간으로 해보는 시나리오로 합니다.
     * : positionInfoPublisher.sendAll(currentPositionResponses)
     */
    @Scheduled(fixedRate = 1000)
    fun run() {
        val currentPositionResponses = currentPositionFinder.findAll()

        currentPositionResponses.forEach {
            currentPositionPublisher.publish(it)
        }
    }
}
