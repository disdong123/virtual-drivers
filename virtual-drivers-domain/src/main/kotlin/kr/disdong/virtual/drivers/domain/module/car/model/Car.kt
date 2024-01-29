package kr.disdong.virtual.drivers.domain.module.car.model

interface PlainCar : CarData

interface Car : CarData

interface CarData {
    val id: Long
    val carName: String
    val carNumber: String
    val ownerId: Long
}
