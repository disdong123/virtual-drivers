package kr.disdong.virtual.drivers.broadcast.module.drivingdirection.fixture.drivingdirection

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.setExp
import kr.disdong.virtual.drivers.broadcast.module.drivingdirection.fixture.FixtureUtil
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection

object DrivingDirectionFixture {
    fun any(): DrivingDirection = FixtureUtil.monkey().giveMeBuilder<DrivingDirection>()
        .sample()

    fun any(directionId: Long): DrivingDirection = FixtureUtil.monkey().giveMeBuilder<DrivingDirection>()
        .setExp(DrivingDirection::id, directionId)
        .sample()
}
