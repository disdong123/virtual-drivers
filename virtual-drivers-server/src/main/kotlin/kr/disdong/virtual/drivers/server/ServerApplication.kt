package kr.disdong.virtual.drivers.server

import kr.disdong.virtual.drivers.api.client.ApiClientApplication
import kr.disdong.virtual.drivers.broadcast.BroadcastApplication
import kr.disdong.virtual.drivers.cache.CacheApplication
import kr.disdong.virtual.drivers.cache.module.drivingdirection.cache.PositionInfoRedisCache
import kr.disdong.virtual.drivers.domain.DomainApplication
import kr.disdong.virtual.drivers.domain.module.car.model.PlainCar
import kr.disdong.virtual.drivers.domain.module.car.model.impl.PlainCarImpl
import kr.disdong.virtual.drivers.domain.module.car.repository.CarRepository
import kr.disdong.virtual.drivers.domain.module.user.repository.UserRepository
import kr.disdong.virtual.drivers.persistence.PersistenceApplication
import kr.disdong.virtual.drivers.server.module.drivingdirection.service.DrivingDirectionService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(DomainApplication::class, PersistenceApplication::class, DomainApplication::class, ApiClientApplication::class, CacheApplication::class, BroadcastApplication::class)
class ServerApplication(
    private val userRepository: UserRepository,
    private val carRepository: CarRepository,
    private val drivingDirectionService: DrivingDirectionService,
    private val positionInfoCache: PositionInfoRedisCache,
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        println("run()")
        positionInfoCache.flushAll()

        if (carRepository.findAll().isNotEmpty()) {
            return
        }

        // 차량은 임시로 10대 생성
        val cars = mutableListOf<PlainCar>()
        for (i in 1..100) {
            cars.add(PlainCarImpl(carName = "carName $i", carNumber = "carNumber $i", ownerId = 0))
        }
        carRepository.saveAll(cars)
    }
}

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
