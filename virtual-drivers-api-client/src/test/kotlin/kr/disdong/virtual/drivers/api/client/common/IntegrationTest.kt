package kr.disdong.virtual.drivers.api.client.common

import kr.disdong.virtual.drivers.api.client.ApiClientApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = [ApiClientApplication::class]
)
@ActiveProfiles("test")
class IntegrationTest
