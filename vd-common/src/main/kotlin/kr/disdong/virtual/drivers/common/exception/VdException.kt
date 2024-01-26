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
