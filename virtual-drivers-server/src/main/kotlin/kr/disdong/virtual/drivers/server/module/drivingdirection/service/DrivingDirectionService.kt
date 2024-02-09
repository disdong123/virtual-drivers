package kr.disdong.virtual.drivers.server.module.drivingdirection.service

import jakarta.transaction.Transactional
import kr.disdong.virtual.drivers.domain.module.car.repository.CarRepository
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfoCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionClient
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionResponse
import kr.disdong.virtual.drivers.server.module.drivingdirection.exception.CarUnavailableException
import org.springframework.stereotype.Service

@Service
class DrivingDirectionService(
    private val drivingDirectionClient: DrivingDirectionClient,
    private val drivingDirectionRepository: DrivingDirectionRepository,
    private val carRepository: CarRepository,
    private val positionInfoCache: PositionInfoCache,
) {
    @Transactional
    fun create(request: GetDrivingDirectionRequest): GetDrivingDirectionResponse {
        val car = carRepository.findNoDrivingCar() ?: throw CarUnavailableException()
        val response = drivingDirectionClient.getDrivingDirection(request.toDrivingDirectionRequest())
        val drivingDirection = drivingDirectionRepository.save(response.toPlainDrivingDirection(request.startAddress, request.endAddress, car.id))
        val drivingDirectionRoutes = drivingDirectionRepository.saveRoutes(response.toPlainDrivingDirectionRoutes(drivingDirection.id))

        positionInfoCache.add(PositionInfo(directionId = drivingDirection.id, endPosition = drivingDirectionRoutes.lastOrNull()?.subRoutes?.last() ?: response.endPosition))

        return GetDrivingDirectionResponse.of(
            drivingDirection,
            drivingDirectionRoutes,
        )
    }

    fun getOneById(id: Long): DrivingDirection? {
        return drivingDirectionRepository.findById(id)
    }
}
