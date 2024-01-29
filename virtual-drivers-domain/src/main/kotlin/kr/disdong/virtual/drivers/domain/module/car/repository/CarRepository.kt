package kr.disdong.virtual.drivers.domain.module.car.repository

import kr.disdong.virtual.drivers.domain.module.car.model.Car
import kr.disdong.virtual.drivers.domain.module.car.model.PlainCar

interface CarRepository {
    fun save(car: PlainCar): Car
    fun saveAll(cars: List<PlainCar>): List<Car>
}
