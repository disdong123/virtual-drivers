package kr.disdong.virtual.drivers.server.fixture.drivingdirection

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.DrivingDirectionApiResponse
import kr.disdong.virtual.drivers.server.fixture.FixtureUtil

object DrivingDirectionResponseFixture {
    fun any(): DrivingDirectionApiResponse = FixtureUtil.monkey().giveMeBuilder<DrivingDirectionApiResponse>()
        .sample()
}
