package kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.impl

import kr.disdong.virtual.drivers.cache.common.IntegrationTest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.cache.NextPositionFinder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertInstanceOf
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class NextPositionCacheImplITest : IntegrationTest() {

    @Autowired
    private lateinit var sut: NextPositionCacheImpl

    @Test
    fun `simple test`() {
        assertNotNull(sut)

        val carId = 1L
        val finder = listOf(NextPositionFinder(1, 1))
        assertEquals(sut.get(), emptyList<NextPositionFinder>())

        sut.put(finder)
        assertEquals(sut.get(), finder)
        assertInstanceOf(List::class.java, sut.get())
    }
}
