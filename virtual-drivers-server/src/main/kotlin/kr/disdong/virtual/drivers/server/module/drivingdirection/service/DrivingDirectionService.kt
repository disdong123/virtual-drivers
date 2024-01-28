package kr.disdong.virtual.drivers.server.module.drivingdirection.service

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionClient
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionResponse
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionRequest
import org.springframework.stereotype.Service

@Service
class DrivingDirectionService(
    private val drivingDirectionClient: DrivingDirectionClient,
) {

    fun getDrivingDirection(request: GetDrivingDirectionRequest): DrivingDirectionResponse {
        return drivingDirectionClient.getDrivingDirection(request.toDrivingDirectionRequest())
    }
}
