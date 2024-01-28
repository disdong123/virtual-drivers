package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.impl

import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.DrivingDirectionFeignClient
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.DrivingDirectionOption
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.toNaverMapPosition
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionClient
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionRequest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionResponse
import org.springframework.stereotype.Component

@Component
class DrivingDirectionClientImpl(
    private val drivingDirectionFeignClient: DrivingDirectionFeignClient,
) : DrivingDirectionClient {
    override fun getDrivingDirection(request: DrivingDirectionRequest): DrivingDirectionResponse {
        return drivingDirectionFeignClient.getDrivingDirection(
            request.start.toNaverMapPosition(),
            request.goal.toNaverMapPosition(),
            DrivingDirectionOption.TRAFAST.value,
        ).toDrivingDirectionResponse()
    }
}
