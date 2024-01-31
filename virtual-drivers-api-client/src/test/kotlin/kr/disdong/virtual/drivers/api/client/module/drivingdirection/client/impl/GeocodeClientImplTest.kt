package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.impl

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("local")
@Disabled
class GeocodeClientImplTest {
    @Autowired
    private lateinit var geocodeClientImpl: GeocodeClientImpl

    @Test
    fun `호출 테스트`() {
        println(geocodeClientImpl.getPositionByAddress("서울특별시 강남구 봉은사로 524"))
    }
}
