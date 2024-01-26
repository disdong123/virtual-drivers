package kr.disdong.virtual.drivers.domain.module.user.model.impl

import kr.disdong.virtual.drivers.domain.module.user.model.PlainUser

class PlainUserImpl(
    override val id: Long = 0,
    override var name: String,
    override val phone: String
) : PlainUser
