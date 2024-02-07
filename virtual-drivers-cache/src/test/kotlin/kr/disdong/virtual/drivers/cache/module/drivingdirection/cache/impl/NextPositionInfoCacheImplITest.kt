package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.common.IntegrationTest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionInfo
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class NextPositionInfoCacheImplITest : IntegrationTest() {

    @Autowired
    private lateinit var sut: NextPositionInfoCacheImpl

    @Test
    fun `simple test`() {
        assertNotNull(sut)

        val carId = 1L
        val finder = listOf(NextPositionInfo(1, 1, 1, Position(1.0, 1.0)))
        assertEquals(sut.get(), emptyList<NextPositionInfo>())

        sut.put(finder)
        assertEquals(sut.get(), finder)
        assertInstanceOf(List::class.java, sut.get())
    }
}
