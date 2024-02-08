package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.helper

import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfo
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NextPositionInfoFinderTest {

    @Test
    fun find() {
        // given
        val currentPositionInfo = NextPositionInfo(
            routeOrder = 0,
            index = 0
        )
        val subRouteSize = 1

        // when
        val result = NextPositionInfoFinder.find(currentPositionInfo, subRouteSize)

        // then
        assertEquals(NextPositionInfo(routeOrder = 0, index = 1), result)
    }
}