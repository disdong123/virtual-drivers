package kr.disdong.virtual.drivers.server.module.drivingdirection.helper

import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.GeocodeClient
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import org.springframework.stereotype.Component

@Component
class AddressTranslator(
    private val geocodeClient: GeocodeClient,
) {
    fun translate(address: String): Position {
        return geocodeClient.getPositionByAddress(address)
    }
}
