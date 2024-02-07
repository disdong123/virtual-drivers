package kr.disdong.virtual.drivers.server.module.drivingdirection.exception

import kr.disdong.virtual.drivers.common.exception.VdException

class CarUnavailableException : VdException("Car is not available") {
    override fun getCode(): Int {
        return 400
    }
}
