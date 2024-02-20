package kr.disdong.virtual.drivers.common.exception

import java.lang.RuntimeException

/**
 *
 * @property message
 */
abstract class VdException(
    override val message: String,
) : RuntimeException(message) {

    fun toResponse(): VdExceptionResponse {
        return VdExceptionResponse(getCode(), message)
    }

    abstract fun getCode(): Int
}

class ShouldDefineVdException : VdException("다른 에러로 정의해야합니다.") {
    override fun getCode(): Int {
        return 400
    }
}

class VdExceptionResponse(
    val code: Int,
    val message: String,
) {
    companion object {
        fun unexpectedError(): VdExceptionResponse {
            return VdExceptionResponse(500, "Unexpected error")
        }
    }
}
