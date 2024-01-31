package kr.disdong.virtual.drivers.api.client.module.drivingdirection.exception

import kr.disdong.virtual.drivers.common.exception.VdException

class GeocodeException : VdException("좌표를 가져오는데 실패했습니다.") {
    override fun getCode(): Int {
        return 400
    }
}
