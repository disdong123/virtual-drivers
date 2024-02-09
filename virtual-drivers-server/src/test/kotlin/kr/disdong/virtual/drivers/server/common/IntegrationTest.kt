package kr.disdong.virtual.drivers.server.common

import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.PositionInfoRedisCache
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionClient
import kr.disdong.virtual.drivers.server.ServerApplication
import kr.disdong.virtual.drivers.server.fixture.drivingdirection.DrivingDirectionResponseFixture
import org.junit.jupiter.api.BeforeEach
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [ServerApplication::class]
)
@ActiveProfiles("test")
class IntegrationTest {
    @MockBean
    private lateinit var drivingDistanceClient: DrivingDirectionClient

    @MockBean
    protected lateinit var positionInfoRedisCache: PositionInfoRedisCache

    @BeforeEach
    fun setUp() {
        whenever(drivingDistanceClient.getDrivingDirection(any()))
            .thenReturn(DrivingDirectionResponseFixture.any())
    }
}
