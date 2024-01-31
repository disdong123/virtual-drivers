package kr.disdong.virtual.drivers.server.module.user.service

import kr.disdong.virtual.drivers.domain.module.user.model.PlainUser
import kr.disdong.virtual.drivers.domain.module.user.repository.UserRepository
import kr.disdong.virtual.drivers.persistence.module.user.model.UserEntity
import kr.disdong.virtual.drivers.persistence.module.user.model.impl.UserImpl
import kr.disdong.virtual.drivers.server.module.user.dto.CreateUserBody
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UserServiceTest {

    private val sut = UserService(object : UserRepository {
        override fun save(user: PlainUser) = UserImpl(UserEntity(name = "name", phone = "010"))
    })

    @Test
    fun `샘플 테스트 1`() {
        // given, when
        val response = sut.create(CreateUserBody("name", "010"))

        // then
        assertEquals("name", response.name)
        assertEquals("010", response.phone)
    }
}
