package kr.disdong.virtual.drivers.common.exception

import java.lang.RuntimeException

/**
 *
 * @property message
 */
abstract class VdException(
    override val message: String,
) : RuntimeException(message) {

    abstract fun getCode(): Int
}

class ShouldDefineVdException : VdException("다른 에러로 정의해야합니다.") {
    override fun getCode(): Int {
        return 400
    }
}
