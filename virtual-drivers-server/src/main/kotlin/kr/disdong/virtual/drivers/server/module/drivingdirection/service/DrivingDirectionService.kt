package kr.disdong.virtual.drivers.server.module.drivingdirection.service

import jakarta.transaction.Transactional
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
    @Transactional
    fun create(request: GetDrivingDirectionRequest): GetDrivingDirectionResponse {
        val response = drivingDirectionClient.getDrivingDirection(request.toDrivingDirectionRequest())
        val drivingDirection = drivingDirectionRepository.save(response.toPlainDrivingDirection(request.startAddress, request.endAddress))
        val drivingDirectionRoutes = drivingDirectionRepository.saveRoutes(response.toPlainDrivingDirectionRoutes(drivingDirection.id))

        return GetDrivingDirectionResponse.of(
            drivingDirection,
            drivingDirectionRoutes,
        )
    }

    fun getOneById(id: Long): DrivingDirection? {
        return drivingDirectionRepository.findById(id)
    }
}
