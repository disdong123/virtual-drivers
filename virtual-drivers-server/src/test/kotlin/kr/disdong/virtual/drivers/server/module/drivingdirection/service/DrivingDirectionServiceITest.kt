package kr.disdong.virtual.drivers.server.module.drivingdirection.service

import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.server.common.IntegrationTest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionRequest
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class DrivingDirectionServiceITest : IntegrationTest() {

    @Autowired
    private lateinit var sut: DrivingDirectionService

    @Test
    fun `simple test`() {
        // given
        val request = GetDrivingDirectionRequest(37.001, 127.001, 37.001, 127.001)

        // when
        val response = sut.create(request)

        // then
        assertInstanceOf(DrivingDirection::class.java, response)
    }
}
