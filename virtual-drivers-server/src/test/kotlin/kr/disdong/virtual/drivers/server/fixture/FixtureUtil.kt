package kr.disdong.virtual.drivers.server.fixture

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin

object FixtureUtil {
    fun monkey(): FixtureMonkey = FixtureMonkey.builder()
        .plugin(KotlinPlugin())
        .build()
}
