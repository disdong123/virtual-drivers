package kr.disdong.virtual.drivers.domain.module.drivingdirection.client

interface GeocodeClient {
    fun getPositionByAddress(address: String): Position
}
