package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.impl

import kr.disdong.virtual.drivers.api.client.common.IntegrationTest
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.GeocodeAddress
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.GeocodeResponse
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.GeocodeStatus
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.exception.GeocodeException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired

class GeocodeClientImplITest : IntegrationTest() {

    @Autowired
    private lateinit var sut: GeocodeClientImpl

    @Nested
    @DisplayName("주소로 좌표정보 조회 성공 시")
    inner class SuccessCase {
        @Test
        fun `좌표결과가 없으면 예외가 발생한다`() {
            whenever(geocodeFeignClient.getPositionByAddress(any())).thenReturn(
                GeocodeResponse(status = GeocodeStatus.OK, addresses = listOf())
            )

            assertThrows<GeocodeException> {
                sut.getPositionByAddress("서울특별시 강남구 봉은사로 524")
            }
        }

        @Test
        fun `좌표결과가 있으면 좌표 결과를 반환한다`() {
            whenever(geocodeFeignClient.getPositionByAddress(any())).thenReturn(
                GeocodeResponse(status = GeocodeStatus.OK, addresses = listOf(GeocodeAddress(x = "126.9918", y = "37.5519")))
            )

            val response = sut.getPositionByAddress("서울특별시 강남구 봉은사로 524")

            assertEquals(126.9918, response.longitude)
            assertEquals(37.5519, response.latitude)
        }
    }

    @Nested
    @DisplayName("주소로 좌표정보 조회 실패 시")
    inner class FailureCase {
        @Test
        fun `예외가 발생한다`() {
            whenever(geocodeFeignClient.getPositionByAddress(any())).thenReturn(
                GeocodeResponse(status = GeocodeStatus.INVALID_REQUEST, addresses = listOf())
            )

            assertThrows<GeocodeException> {
                sut.getPositionByAddress("서울특별시 강남구 봉은사로 524")
            }
        }
    }
}
