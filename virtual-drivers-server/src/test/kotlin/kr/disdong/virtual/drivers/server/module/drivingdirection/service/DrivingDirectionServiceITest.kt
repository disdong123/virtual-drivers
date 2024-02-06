package kr.disdong.virtual.drivers.server.module.drivingdirection.service

import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.server.common.IntegrationTest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionResponse
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class DrivingDirectionServiceITest : IntegrationTest() {

    @Autowired
    private lateinit var sut: DrivingDirectionService

    @Autowired
    private lateinit var drivingDirectionRepository: DrivingDirectionRepository

    @Test
    fun `simple test`() {
        // given
        val request = GetDrivingDirectionRequest("", 37.001, 127.001, "", 37.001, 127.001)

        // when
        val response = sut.create(request)

        // then
        assertInstanceOf(GetDrivingDirectionResponse::class.java, response)
    }
}
