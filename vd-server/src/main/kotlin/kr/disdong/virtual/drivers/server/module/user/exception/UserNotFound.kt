package kr.disdong.virtual.drivers.server.module.user.exception

import kr.disdong.virtual.drivers.common.exception.VdException

class UserNotFound(private val userId: Long) : VdException("$userId 유저를 찾을 수 없습니다.") {
    override fun getCode(): Int {
        return 404
    }
}
