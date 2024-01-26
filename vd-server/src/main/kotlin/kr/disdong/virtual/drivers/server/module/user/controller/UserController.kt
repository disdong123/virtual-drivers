package kr.disdong.virtual.drivers.server.module.user.controller

import kr.disdong.virtual.drivers.common.dto.VdResponse
import kr.disdong.virtual.drivers.server.module.user.controller.spec.UserSpec
import kr.disdong.virtual.drivers.server.module.user.dto.CreateUserBody
import kr.disdong.virtual.drivers.server.module.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) : UserSpec {

    @GetMapping("/users/{userId}")
    override fun getByUserId(
        @PathVariable userId: Long,
    ) = VdResponse.of(userService.getByUserId(userId))

    @PostMapping("/users")
    override fun create(
        body: CreateUserBody,
    ) = VdResponse.of(HttpStatus.CREATED, userService.create(body))
}
