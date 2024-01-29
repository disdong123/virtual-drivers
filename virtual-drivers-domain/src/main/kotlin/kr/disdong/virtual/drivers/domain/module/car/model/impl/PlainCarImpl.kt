package kr.disdong.virtual.drivers.domain.module.car.model.impl

import kr.disdong.virtual.drivers.domain.module.car.model.PlainCar

class PlainCarImpl(
    override val id: Long = 0,
    override val carName: String,
    override val carNumber: String,
    override val ownerId: Long
) : PlainCar
