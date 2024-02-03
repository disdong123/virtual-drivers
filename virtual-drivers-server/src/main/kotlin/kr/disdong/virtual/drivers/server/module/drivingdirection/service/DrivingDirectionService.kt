package kr.disdong.virtual.drivers.server.module.drivingdirection.service

import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.DrivingDirectionRouteCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionClient
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionResponse
import org.springframework.stereotype.Service

@Service
class DrivingDirectionService(
    private val drivingDirectionClient: DrivingDirectionClient,
    private val drivingDirectionRepository: DrivingDirectionRepository,
    private val drivingDirectionRouteCache: DrivingDirectionRouteCache,
) {
    fun create(request: GetDrivingDirectionRequest): GetDrivingDirectionResponse {
        val response = drivingDirectionClient.getDrivingDirection(request.toDrivingDirectionRequest())

        drivingDirectionRouteCache.put(response.startPosition, response.endPosition, response.route)

        return GetDrivingDirectionResponse.of(
            drivingDirectionRepository.save(response.toPlainDrivingDirection(request.startAddress, request.endAddress)),
            drivingDirectionRouteCache.get(response.startPosition, response.endPosition),
        )
    }

    fun getOneById(id: Long): DrivingDirection {
        return drivingDirectionRepository.findById(id)
    }
}
