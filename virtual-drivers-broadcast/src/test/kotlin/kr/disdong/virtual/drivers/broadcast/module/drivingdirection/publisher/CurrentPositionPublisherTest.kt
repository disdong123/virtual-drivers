package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.publisher

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Disabled
class CurrentPositionPublisherTest {
    @Autowired
    private lateinit var sut: CurrentPositionPublisher

    @Test
    fun `simple test`() {
        assertNotNull(sut)
        sut.publishAll()
    }
}
