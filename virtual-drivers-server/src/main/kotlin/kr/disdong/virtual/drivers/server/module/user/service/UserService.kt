package kr.disdong.virtual.drivers.server.module.user.service

import kr.disdong.virtual.drivers.domain.module.user.model.User
import kr.disdong.virtual.drivers.domain.module.user.repository.UserRepository
import kr.disdong.virtual.drivers.server.module.user.dto.CreateUserBody
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun create(request: CreateUserBody): User {
        return userRepository.save(request.toUser())
    }
}
