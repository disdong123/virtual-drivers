package kr.disdong.virtual.drivers.api.client.common

import kr.disdong.virtual.drivers.api.client.ApiClientApplication
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.GeocodeFeignClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [ApiClientApplication::class]
)
@ActiveProfiles("test")
class IntegrationTest {

    @MockBean
    protected lateinit var geocodeFeignClient: GeocodeFeignClient
}
