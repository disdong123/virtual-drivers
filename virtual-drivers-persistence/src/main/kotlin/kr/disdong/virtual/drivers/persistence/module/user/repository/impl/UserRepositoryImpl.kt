package kr.disdong.virtual.drivers.persistence.module.user.repository.impl

import kr.disdong.virtual.drivers.domain.module.user.model.PlainUser
import kr.disdong.virtual.drivers.domain.module.user.model.User
import kr.disdong.virtual.drivers.domain.module.user.repository.UserRepository
import kr.disdong.virtual.drivers.persistence.module.user.model.UserEntity
import kr.disdong.virtual.drivers.persistence.module.user.repository.UserJpaRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userJpaRepository: UserJpaRepository
) : UserRepository {

    override fun save(user: PlainUser): User {
        return userJpaRepository.save(UserEntity.of(user)).toUser()
    }
}
