package kr.disdong.virtual.drivers.server.module.drivingdirection.service

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionClient
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.server.fixture.drivingdirection.DrivingDirectionFixture
import kr.disdong.virtual.drivers.server.fixture.drivingdirection.DrivingDirectionResponseFixture
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionRequest
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

class DrivingDirectionServiceTest {

    private val drivingDirectionClient: DrivingDirectionClient = mock()
    private val drivingDirectionRepository: DrivingDirectionRepository = mock()
    private val sut = DrivingDirectionService(drivingDirectionClient, drivingDirectionRepository)

    @Test
    fun `simple test`() {
        // given
        val request = GetDrivingDirectionRequest(37.001, 127.001, 37.001, 127.001)
        whenever(drivingDirectionClient.getDrivingDirection(any())).thenReturn(DrivingDirectionResponseFixture.any())
        whenever(drivingDirectionRepository.save(any())).thenReturn(DrivingDirectionFixture.any())

        // when
        val response = sut.create(request)

        // then
        assertInstanceOf(DrivingDirection::class.java, response)
    }
}
