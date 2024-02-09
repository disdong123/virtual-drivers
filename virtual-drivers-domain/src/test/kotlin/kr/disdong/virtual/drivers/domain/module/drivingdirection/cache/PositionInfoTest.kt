package kr.disdong.virtual.drivers.domain.module.drivingdirection.cache

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class PositionInfoTest {

    @Nested
    @DisplayName("다음 위치 정보를 반환하는 find 함수는")
    inner class FindTest {
        @Test
        fun `subRoutes 의 수가 현재 index + 1 보다 큰 경우 index 를 증가시켜 반환한다`() {
            // given
            val sut = `위치 정보`(order = 0, index = 0)
            val subRouteSize = 2

            // when
            val result = sut.getNextPositionInfo(subRouteSize)

            // then
            assertEquals(`위치 정보`(order = 0, index = 1), result)
        }

        @Test
        fun `subRoutes 의 수가 현재 index + 1 보다 작거나 같은 경우 order 를 증가시키고 index 를 초기화하여 반환한다`() {
            // given
            val sut = `위치 정보`(order = 0, index = 0)
            val subRouteSize = 1

            // when
            val result = sut.getNextPositionInfo(subRouteSize)

            // then
            assertEquals(`위치 정보`(1, 0), result)
        }

        private fun `위치 정보`(order: Int, index: Int) = PositionInfo(
            directionId = 0,
            routeOrder = order,
            index = index,
            endPosition = Position(0.0, 0.0)
        )
    }
}
