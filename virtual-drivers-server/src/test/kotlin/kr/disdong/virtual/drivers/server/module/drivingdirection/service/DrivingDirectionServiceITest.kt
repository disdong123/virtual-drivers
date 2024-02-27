package kr.disdong.virtual.drivers.server.module.drivingdirection.service

import kr.disdong.virtual.drivers.domain.module.drivingdirection.repository.DrivingDirectionRepository
import kr.disdong.virtual.drivers.server.common.IntegrationTest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.DrivingDirectionRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.DrivingDirectionResponse
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.springframework.beans.factory.annotation.Autowired

class DrivingDirectionServiceITest : IntegrationTest() {

    @Autowired
    private lateinit var sut: DrivingDirectionService

    @Autowired
    private lateinit var drivingDirectionRepository: DrivingDirectionRepository

    @Test
    fun `simple test`() {
        // given
        val request = DrivingDirectionRequest("", 37.001, 127.001, "", 37.001, 127.001)
        doNothing().`when`(positionInfoRedisCache).add(any())

        // when
        val response = sut.create(request)

        // then
        assertInstanceOf(DrivingDirectionResponse::class.java, response)
    }
}
