package kr.disdong.virtual.drivers.cache.common

import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.PositionInfoRedisCache
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class IntegrationTest {

    @MockBean
    protected lateinit var positionInfoRedisCache: PositionInfoRedisCache
}
