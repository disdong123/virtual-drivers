package kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.impl

import kr.disdong.virtual.drivers.api.client.module.drivingdirection.client.GeocodeFeignClient
import kr.disdong.virtual.drivers.api.client.module.drivingdirection.exception.GeocodeException
import kr.disdong.virtual.drivers.common.logger.logger
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.GeocodeClient
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.springframework.stereotype.Component

@Component
class GeocodeClientImpl(
    private val geocodeFeignClient: GeocodeFeignClient,
) : GeocodeClient {
    private val logger = logger<GeocodeClientImpl>()

    override fun getPositionByAddress(address: String): Position {
        val response = geocodeFeignClient.getPositionByAddress(address)
        if (response.isSuccess().not()) {
            logger.error("response: $response")
            throw GeocodeException()
        }

        return response.toPosition()
    }
}
