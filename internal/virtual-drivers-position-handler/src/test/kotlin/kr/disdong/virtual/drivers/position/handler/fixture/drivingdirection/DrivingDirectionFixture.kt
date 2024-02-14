package kr.disdong.virtual.drivers.position.handler.fixture.drivingdirection

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.setExp
import kr.disdong.virtual.drivers.domain.module.drivingdirection.model.DrivingDirection
import kr.disdong.virtual.drivers.position.handler.fixture.FixtureUtil

object DrivingDirectionFixture {
    fun any(): DrivingDirection = FixtureUtil.monkey().giveMeBuilder<DrivingDirection>()
        .sample()

    fun any(directionId: Long): DrivingDirection = FixtureUtil.monkey().giveMeBuilder<DrivingDirection>()
        .setExp(DrivingDirection::id, directionId)
        .sample()
}
