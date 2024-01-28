package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client

import kr.disdong.virtual.drivers.api.client.config.feign.NaverMapFeignConfig
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.dto.DrivingDirectionFeignResponse
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "DrivingDirectionFeignClient", url = "\${naver.map.base-url}", configuration = [NaverMapFeignConfig::class])
interface DrivingDirectionFeignClient {

    @GetMapping("/driving")
    fun getDrivingDirection(
        @RequestParam start: String,
        @RequestParam goal: String,
        @RequestParam option: String,
    ): DrivingDirectionFeignResponse
}

fun Position.toNaverMapPosition(): String {
    return "$longitude,$latitude"
}

enum class DrivingDirectionOption(val value: String, val desc: String) {
    TRAFAST("trafast", "빠른길"),
    TRACOMFORT("tracomfort", "편한길"),
    TRAOPTIMAL("traoptimal", "최적"),
}
