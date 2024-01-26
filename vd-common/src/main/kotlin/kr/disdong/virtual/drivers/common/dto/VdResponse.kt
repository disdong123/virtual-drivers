package kr.disdong.virtual.drivers.common.dto

import kr.disdong.virtual.drivers.common.exception.VdException
import org.springframework.http.HttpStatus

class VdResponse<T>(
    val code: Int,
    val data: T? = null,
    val message: String? = null
) {
    companion object {
        fun <T> of(
            exception: VdException
        ): VdResponse<T> {
            return VdResponse(
                code = exception.getCode(),
                message = exception.message,
            )
        }

        fun <T> of(
            content: T? = null,
        ): VdResponse<T> {
            return VdResponse(
                code = HttpStatus.OK.value(),
                data = content
            )
        }

        fun <T> of(
            code: HttpStatus,
            content: T? = null,
        ): VdResponse<T> {
            return VdResponse(
                code = code.value(),
                data = content
            )
        }
    }
}
