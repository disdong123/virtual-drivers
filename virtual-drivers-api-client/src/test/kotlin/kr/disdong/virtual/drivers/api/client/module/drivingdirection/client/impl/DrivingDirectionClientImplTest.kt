package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.impl

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionApiRequest
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("local")
@Disabled
class DrivingDirectionClientImplTest {
    @Autowired
    private lateinit var sut: DrivingDirectionClientImpl

    @Test
    fun `호출 테스트`() {
        assertNotNull(sut)
        println(
            sut.getDrivingDirection(
                request = DrivingDirectionApiRequest(
                    startPosition = Position(
                        longitude = 126.9918,
                        latitude = 37.5519
                    ),
                    endPosition = Position(
                        longitude = 126.7052,
                        latitude = 37.4563
                    )
                )
            )
        )
    }
}
