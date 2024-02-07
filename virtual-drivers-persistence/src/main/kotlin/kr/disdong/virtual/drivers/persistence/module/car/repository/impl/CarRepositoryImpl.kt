package kr.disdong.virtual.drivers.persistence.module.car.repository.impl

import kr.disdong.virtual.drivers.domain.module.car.model.Car
import kr.disdong.virtual.drivers.domain.module.car.model.PlainCar
import kr.disdong.virtual.drivers.domain.module.car.repository.CarRepository
import kr.disdong.virtual.drivers.persistence.module.car.model.CarEntity
import kr.disdong.virtual.drivers.persistence.module.car.repository.CarJpaRepository
import org.springframework.stereotype.Repository

@Repository
class CarRepositoryImpl(
    private val carJpaRepository: CarJpaRepository
) : CarRepository {
    override fun findAll(): List<Car> {
        return carJpaRepository.findAll().map { it.toCar() }
    }

    override fun findNoDrivingCar(): Car? {
        return carJpaRepository.findNoDrivingCar()?.toCar()
    }

    override fun save(car: PlainCar): Car {
        return carJpaRepository.save(CarEntity.of(car)).toCar()
    }

    override fun saveAll(cars: List<PlainCar>): List<Car> {
        return carJpaRepository.saveAll(cars.map { CarEntity.of(it) }).map { it.toCar() }
    }
}
