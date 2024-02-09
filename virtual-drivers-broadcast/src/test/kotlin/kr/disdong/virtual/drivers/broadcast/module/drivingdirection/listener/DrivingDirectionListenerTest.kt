package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.listener

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Disabled
class DrivingDirectionListenerTest {
    @Autowired
    private lateinit var sut: DrivingDirectionListener

    @Test
    fun `simple test`() {
        assertNotNull(sut)
        sut.sendCurrentPositions()
    }
}
