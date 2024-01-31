package kr.disdong.virtual.drivers.server.module.user.controller.spec

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.disdong.virtual.drivers.common.dto.VdResponse
import kr.disdong.virtual.drivers.domain.module.user.model.User
import kr.disdong.virtual.drivers.server.module.user.dto.CreateUserBody

@Tag(name = "유저")
interface UserSpec {

    @Operation
    fun create(body: CreateUserBody): VdResponse<User>
}
