package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.impl

import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.GeocodeFeignClient
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.exception.GeocodeException
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.GeocodeClient
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.springframework.stereotype.Component

@Component
class GeocodeClientImpl(
    private val geocodeFeignClient: GeocodeFeignClient,
) : GeocodeClient {
    override fun getPositionByAddress(address: String): Position {
        val response = geocodeFeignClient.getPositionByAddress(address)
        if (response.isSuccess().not()) {
            throw GeocodeException()
        }

        return response.toPosition()
    }
}
