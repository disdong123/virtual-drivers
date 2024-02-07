package kr.disdong.virtual.drivers.persistence.module.car.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import kr.disdong.virtual.drivers.domain.module.car.model.PlainCar
import kr.disdong.virtual.drivers.persistence.common.model.BaseEntity
import kr.disdong.virtual.drivers.persistence.module.car.model.impl.CarImpl

@Entity(name = "car")
class CarEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(
        nullable = false,
        unique = false,
        length = 45,
    )
    val carName: String,

    @Column(
        nullable = false,
        unique = true,
        length = 20,
    )
    val carNumber: String,

    @Column(
        nullable = false,
        unique = false,
        length = 100,
    )
    val ownerId: Long,
) : BaseEntity() {
    companion object {
        fun of(car: PlainCar): CarEntity {
            return CarEntity(
                id = car.id,
                carName = car.carName,
                carNumber = car.carNumber,
                ownerId = car.ownerId,
            )
        }
    }

    fun toCar(): CarImpl {
        return CarImpl(this)
    }
}
