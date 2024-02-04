package kr.disdong.virtual.drivers.server

import kr.disdong.virtual.drivers.api.client.ApiClientApplication
import kr.disdong.virtual.drivers.broadcast.BroadcastApplication
import kr.disdong.virtual.drivers.cache.CacheApplication
import kr.disdong.virtual.drivers.domain.DomainApplication
import kr.disdong.virtual.drivers.domain.module.car.repository.CarRepository
import kr.disdong.virtual.drivers.domain.module.user.repository.UserRepository
import kr.disdong.virtual.drivers.persistence.PersistenceApplication
import kr.disdong.virtual.drivers.server.module.drivingdirection.service.DrivingDirectionService
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(DomainApplication::class, PersistenceApplication::class, DomainApplication::class, ApiClientApplication::class, CacheApplication::class, BroadcastApplication::class)
class ServerApplication(
    private val userRepository: UserRepository,
    private val carRepository: CarRepository,
    private val drivingDirectionService: DrivingDirectionService,
) : InitializingBean {
    override fun afterPropertiesSet() {
        println("ServerApplication.afterPropertiesSet")
        // val user = userRepository.save(PlainUserImpl(name = "userName", phone = "010-1234-5678"))
        // carRepository.saveAll(
        //    listOf(
        //        PlainCarImpl(carName = "carName", carNumber = "carNumber1", ownerId = user.id),
        //        PlainCarImpl(carName = "carName", carNumber = "carNumber2", ownerId = user.id),
        //    )
        // )
        // drivingDirectionService.create(
        //    GetDrivingDirectionRequest(
        //        startLatitude = 37.5519,
        //        startLongitude = 126.9918,
        //        goalLatitude = 37.4563,
        //        goalLongitude = 126.7052
        //    )
        // )
    }
}

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
