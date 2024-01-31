package kr.disdong.virtual.drivers.persistence.module.user.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import kr.disdong.virtual.drivers.persistence.module.user.model.QUserEntity
import kr.disdong.virtual.drivers.persistence.module.user.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<UserEntity, Long>

interface UserCustomJpaRepository {
    fun findByName(name: String): UserEntity?
}

class UserCustomJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : UserCustomJpaRepository {

    private val userEntity = QUserEntity.userEntity
    override fun findByName(name: String): UserEntity? {
        return jpaQueryFactory
            .selectFrom(userEntity)
            .where(
                userEntity.name.eq(name),
                userEntity.isDeleted.isFalse,
            )
            .fetchOne()
    }
}
