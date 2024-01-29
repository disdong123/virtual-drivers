package kr.disdong.virtual.drivers.persistence.module.car.model.impl

import kr.disdong.virtual.drivers.domain.module.car.model.Car
import kr.disdong.virtual.drivers.persistence.module.car.model.CarEntity

class CarImpl(
    private val entity: CarEntity,
) : Car {
    override val id: Long
        get() = entity.id
    override val carName: String
        get() = entity.carName
    override val carNumber: String
        get() = entity.carNumber
    override val ownerId: Long
        get() = entity.ownerId
}
