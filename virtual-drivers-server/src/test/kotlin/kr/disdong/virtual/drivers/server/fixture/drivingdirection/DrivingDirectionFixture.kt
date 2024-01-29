package kr.disdong.virtual.drivers.server.fixture.drivingdirection

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.server.fixture.FixtureUtil

object DrivingDirectionFixture {
    fun any(): DrivingDirection = FixtureUtil.monkey().giveMeBuilder<DrivingDirection>()
        .sample()
}
