package kr.disdong.virtual.drivers.server.module.translator.controller

import kr.disdong.virtual.drivers.common.dto.VdResponse
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetPositionByAddressRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.helper.AddressTranslator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/translation")
class AddressTranslationController(
    private val addressTranslator: AddressTranslator,
) {

    @GetMapping("/address")
    fun getPositionByAddress(
        @ModelAttribute request: GetPositionByAddressRequest
    ): VdResponse<Position> {
        return VdResponse.of(addressTranslator.translate(request.address))
    }
}
