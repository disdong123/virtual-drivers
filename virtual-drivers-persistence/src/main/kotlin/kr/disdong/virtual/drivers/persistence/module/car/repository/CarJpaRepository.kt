package kr.disdong.virtual.drivers.persistence.module.car.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import kr.disdong.virtual.drivers.persistence.module.car.model.CarEntity
import kr.disdong.virtual.drivers.persistence.module.car.model.QCarEntity
import kr.disdong.virtual.drivers.persistence.module.drivingdirection.model.QDrivingDirectionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CarJpaRepository : JpaRepository<CarEntity, Long>, CarCustomJpaRepository

interface CarCustomJpaRepository {
    fun findNoDrivingCar(): CarEntity?
}

class CarJpaRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : CarCustomJpaRepository {

    private val carEntity = QCarEntity.carEntity
    private val drivingDirectionEntity = QDrivingDirectionEntity.drivingDirectionEntity
    override fun findNoDrivingCar(): CarEntity? {
        return jpaQueryFactory
            .selectFrom(carEntity)
            .leftJoin(drivingDirectionEntity).on(
                carEntity.id.eq(drivingDirectionEntity.carId),
                drivingDirectionEntity.isDeleted.isFalse,
            )
            .where(
                drivingDirectionEntity.id.isNull,
                carEntity.isDeleted.isFalse,
            )
            .limit(1)
            .fetchOne()
    }
}
