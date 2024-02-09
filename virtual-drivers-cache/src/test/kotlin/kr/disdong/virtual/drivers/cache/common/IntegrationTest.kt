package kr.disdong.virtual.drivers.cache.common

import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.PositionInfoRedisCache
import org.junit.jupiter.api.BeforeAll
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.GenericContainer
import org.testcontainers.utility.DockerImageName

@SpringBootTest
@ActiveProfiles("test")
class IntegrationTest {

    @MockBean
    protected lateinit var positionInfoRedisCache: PositionInfoRedisCache
    companion object {
        private val redis = GenericContainer(DockerImageName.parse("redis:alpine")).withExposedPorts(6379)
        // TODO
        @JvmStatic
        @BeforeAll
        fun beforeAll() {
            redis.start()
            println("???")
            println(redis.getMappedPort(6379))
        }
    }
}
