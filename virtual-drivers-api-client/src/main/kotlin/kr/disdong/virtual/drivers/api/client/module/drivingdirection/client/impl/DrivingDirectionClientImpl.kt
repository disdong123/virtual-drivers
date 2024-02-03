package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.impl

import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.DrivingDirectionFeignClient
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.DrivingDirectionOption
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.toNaverMapPosition
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionApiRequest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionApiResponse
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionClient
import org.springframework.stereotype.Component

@Component
class DrivingDirectionClientImpl(
    private val drivingDirectionFeignClient: DrivingDirectionFeignClient,
) : DrivingDirectionClient {
    override fun getDrivingDirection(request: DrivingDirectionApiRequest): DrivingDirectionApiResponse {
        return drivingDirectionFeignClient.getDrivingDirection(
            request.startPosition.toNaverMapPosition(),
            request.endPosition.toNaverMapPosition(),
            DrivingDirectionOption.TRAFAST.value,
        ).toDrivingDirectionResponse()
    }
}
