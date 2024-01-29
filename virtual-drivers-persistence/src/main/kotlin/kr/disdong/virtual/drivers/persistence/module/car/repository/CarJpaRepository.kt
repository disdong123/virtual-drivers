package kr.disdong.virtual.drivers.persistence.module.car.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import kr.disdong.virtual.drivers.persistence.module.car.model.CarEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarJpaRepository : JpaRepository<CarEntity, Long>, CarCustomJpaRepository

interface CarCustomJpaRepository

class CarJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : CarCustomJpaRepository
