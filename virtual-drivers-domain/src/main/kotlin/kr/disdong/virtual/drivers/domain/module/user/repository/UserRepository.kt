package kr.disdong.virtual.drivers.domain.module.user.repository

import kr.disdong.virtual.drivers.domain.module.user.model.PlainUser
import kr.disdong.virtual.drivers.domain.module.user.model.User

interface UserRepository {

    fun save(user: PlainUser): User
}
