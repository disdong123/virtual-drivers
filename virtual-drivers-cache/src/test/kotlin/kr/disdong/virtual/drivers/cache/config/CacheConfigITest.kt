package kr.disdong.virtual.drivers.cache.config

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cache.CacheManager
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class CacheConfigITest {
    @Autowired
    private lateinit var sut: CacheManager

    @Test
    fun `simple test`() {
        assertNotNull(sut)

        val cache = sut.getCache("virtual-drivers-caffeine-cache")!!
        assertNotNull(cache)
        assertNull(cache.get("hello"))

        cache.put("hello", "world")
        assertEquals("world", cache.get("hello")?.get())
    }
}
