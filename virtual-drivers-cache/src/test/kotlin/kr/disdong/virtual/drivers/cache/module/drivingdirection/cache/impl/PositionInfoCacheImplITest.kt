package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.common.IntegrationTest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.PositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired

class PositionInfoCacheImplITest : IntegrationTest() {

    @Autowired
    private lateinit var sut: PositionInfoCacheImpl

    @Test
    fun `simple test`() {
        assertNotNull(sut)

        val finder = listOf(PositionInfo(1, 1, 1, Position(1.0, 1.0)))
        whenever(positionInfoRedisCache.get()).thenReturn(emptyList())
        assertEquals(sut.getAll(), emptyList<PositionInfo>())

        sut.deleteAndAddAll(finder)
        whenever(positionInfoRedisCache.get()).thenReturn(finder)
        assertEquals(sut.getAll(), finder)
        assertInstanceOf(List::class.java, sut.getAll())
    }
}
