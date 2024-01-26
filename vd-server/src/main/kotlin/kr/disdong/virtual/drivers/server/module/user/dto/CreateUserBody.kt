package kr.disdong.virtual.drivers.server.module.user.dto

import kr.disdong.virtual.drivers.domain.module.user.model.PlainUser
import kr.disdong.virtual.drivers.domain.module.user.model.impl.PlainUserImpl

class CreateUserBody(
    val name: String,
    val phone: String,
) {

    fun toUser(): PlainUser {
        return PlainUserImpl(
            name = name,
            phone = phone,
        )
    }
}
