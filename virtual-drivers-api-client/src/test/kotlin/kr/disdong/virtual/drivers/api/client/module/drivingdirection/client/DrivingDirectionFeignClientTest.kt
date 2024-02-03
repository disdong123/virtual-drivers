package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("local")
@Disabled
class DrivingDirectionFeignClientTest {

    @Autowired
    private lateinit var sut: DrivingDirectionFeignClient

    @Test
    fun `호출 테스트`() {
        assertNotNull(sut)
        println(
            sut.getDrivingDirection(
                start = "126.9918,37.5519",
                goal = "126.7052,37.4563",
                option = "trafast"
            )
        )
    }
}
