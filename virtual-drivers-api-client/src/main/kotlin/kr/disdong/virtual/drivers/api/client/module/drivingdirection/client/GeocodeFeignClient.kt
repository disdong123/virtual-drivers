package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client

import kr.disdong.virtual.drivers.api.client.config.feign.NaverMapFeignConfig
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.exception.GeocodeException
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "GeocodeFeignClient", url = "\${naver.map.base-url}/map-geocode/v2", configuration = [NaverMapFeignConfig::class])
interface GeocodeFeignClient {

    @GetMapping("/geocode")
    fun getPositionByAddress(
        @RequestParam query: String,
    ): GeocodeResponse
}

data class GeocodeResponse(
    val status: GeocodeStatus,
    val addresses: List<GeocodeAddress>?,
) {
    fun isSuccess(): Boolean {
        return status == GeocodeStatus.OK
    }

    fun toPosition(): Position {
        if (addresses.isNullOrEmpty()) {
            throw GeocodeException()
        }

        return addresses.first().toPosition()
    }
}

data class GeocodeAddress(
    val x: String, // 경도
    val y: String, // 위도
) {
    fun toPosition(): Position {
        return Position(y.toDouble(), x.toDouble())
    }
}

enum class GeocodeStatus(
    val value: Int,
) {
    OK(200),
    INVALID_REQUEST(400),
    SYSTEM_ERROR(500)
}
