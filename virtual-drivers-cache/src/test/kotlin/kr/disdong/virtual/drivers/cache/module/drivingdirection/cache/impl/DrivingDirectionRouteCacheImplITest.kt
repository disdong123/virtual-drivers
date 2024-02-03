package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.common.IntegrationTest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class DrivingDirectionRouteCacheImplITest : IntegrationTest() {

    @Autowired
    private lateinit var sut: DrivingDirectionRouteCacheImpl

    @Test
    fun `simple test`() {
        assertNotNull(sut)

        val route = listOf(Position(1.0, 2.0), Position(3.0, 4.0))
        assertEquals(sut.get(route[0], route[1]), emptyList<Position>())

        sut.put(route[0], route[1], route)
        assertEquals(sut.get(route[0], route[1]), route)
        assertInstanceOf(List::class.java, sut.get(route[0], route[1]))
    }
}
