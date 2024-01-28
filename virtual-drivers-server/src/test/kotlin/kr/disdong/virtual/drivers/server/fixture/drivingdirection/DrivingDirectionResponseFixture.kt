package kr.disdong.virtual.drivers.server.fixture.drivingdirection

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionResponse
import kr.disdong.virtual.drivers.server.fixture.FixtureUtil

object DrivingDirectionResponseFixture {
    fun any(): DrivingDirectionResponse = FixtureUtil.monkey().giveMeBuilder<DrivingDirectionResponse>()
        .sample()
}
