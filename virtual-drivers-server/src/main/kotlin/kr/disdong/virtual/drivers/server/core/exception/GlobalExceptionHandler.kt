package kr.disdong.virtual.drivers.server.core.exception

import kr.disdong.virtual.drivers.common.exception.VdException
import kr.disdong.virtual.drivers.common.exception.VdExceptionResponse
import kr.disdong.virtual.drivers.common.logger.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(annotations = [RestController::class])
class GlobalExceptionHandler {
    private val logger = logger<GlobalExceptionHandler>()

    @ExceptionHandler(VdException::class)
    fun vdException(e: VdException): ResponseEntity<VdExceptionResponse> {
        return ResponseEntity.ok(e.toResponse())
    }

    @ExceptionHandler(Throwable::class)
    fun throwable(e: Throwable): ResponseEntity<VdExceptionResponse> {
        logger.error("Unexpected error", e)
        return ResponseEntity.status(500).body(VdExceptionResponse.unexpectedError())
    }
}
