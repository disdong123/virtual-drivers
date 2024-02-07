package kr.disdong.virtual.drivers.server.module.drivingdirection.service

import kr.disdong.virtual.drivers.domain.module.car.repository.CarRepository
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfoCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionClient
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.persistence.module.car.model.CarEntity
import kr.disdong.virtual.drivers.persistence.module.car.model.impl.CarImpl
import kr.disdong.virtual.drivers.server.fixture.drivingdirection.DrivingDirectionFixture
import kr.disdong.virtual.drivers.server.fixture.drivingdirection.DrivingDirectionResponseFixture
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionResponse
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class DrivingDirectionServiceTest {

    private val drivingDirectionClient: DrivingDirectionClient = mock()
    private val drivingDirectionRepository: DrivingDirectionRepository = mock()
    private val carRepository: CarRepository = mock()
    private val nextPositionInfoCache: NextPositionInfoCache = mock()
    private val sut = DrivingDirectionService(drivingDirectionClient, drivingDirectionRepository, carRepository, nextPositionInfoCache)

    @Test
    fun `simple test`() {
        // given
        val request = GetDrivingDirectionRequest("", 37.001, 127.001, "", 37.001, 127.001)
        whenever(drivingDirectionClient.getDrivingDirection(any())).thenReturn(DrivingDirectionResponseFixture.any())
        whenever(drivingDirectionRepository.save(any())).thenReturn(DrivingDirectionFixture.any())
        whenever(nextPositionInfoCache.get()).thenReturn(emptyList())
        whenever(carRepository.findNoDrivingCar()).thenReturn(CarImpl(CarEntity(1, "carName", "carNumber", 1)))

        // when
        val response = sut.create(request)

        // then
        assertInstanceOf(GetDrivingDirectionResponse::class.java, response)
    }
}
