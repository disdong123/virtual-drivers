package kr.disdong.springboot.template.server.module.user.dto

import kr.disdong.springboot.template.domain.module.user.model.PlainUser
import kr.disdong.springboot.template.domain.module.user.model.impl.PlainUserImpl

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
