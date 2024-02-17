package kr.disdong.virtual.drivers.domain.module.drivingdirection.client

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.ZonedDateTime

class DrivingDirectionApiResponseTest {

    @DisplayName("길찾기 응답을 저장할 때")
    @Nested
    inner class ToPlainDrivingDirectionRoutes {
        private val SUB_ROUTE_MAX_SIZE = 5

        @Test
        fun `route 가 매우 많을 수 있으므로 100개씩 끊어서 저장한다`() {
            val sut = `길찾기 응답값`(999)

            val response = sut.toPlainDrivingDirectionRoutes(1)

            assertEquals(response.size, 200)
            assertEquals(response[0].subRoutes.size, SUB_ROUTE_MAX_SIZE)
            assertEquals(response[199].subRoutes.size, 4)
        }

        @Test
        fun `route 수가 1인 경우`() {
            val sut = `길찾기 응답값`(1)

            val response = sut.toPlainDrivingDirectionRoutes(1)

            assertEquals(response.size, 1)
            assertEquals(response[0].subRoutes.size, 1)
        }

        @Test
        fun `route 수가 0인 경우`() {
            val sut = `길찾기 응답값`(0)

            val response = sut.toPlainDrivingDirectionRoutes(1)

            assertEquals(response.size, 0)
        }
    }

    private fun `길찾기 응답값`(loop: Int): DrivingDirectionApiResponse {
        return DrivingDirectionApiResponse(
            startPosition = Position(
                longitude = 126.9918,
                latitude = 37.5519
            ),
            endPosition = Position(
                longitude = 126.7052,
                latitude = 37.4563
            ),
            distance = Distance(
                value = 42615
            ),
            duration = Duration(
                value = 2676400
            ),
            departureTime = ZonedDateTime.parse("2024-01-28T21:53:01.000+09:00"),
            route = List(loop) {
                Position(
                    longitude = 126.9944870,
                    latitude = 37.5529616
                )
            }
        )
    }
}
