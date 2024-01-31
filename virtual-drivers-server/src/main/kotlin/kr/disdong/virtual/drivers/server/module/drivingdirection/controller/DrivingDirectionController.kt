package kr.disdong.virtual.drivers.server.module.drivingdirection.controller

import kr.disdong.virtual.drivers.common.dto.VdResponse
import kr.disdong.virtual.drivers.domain.module.drivingdirection.client.Position
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionResponse
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetPositionByAddressRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.helper.AddressTranslator
import kr.disdong.virtual.drivers.server.module.drivingdirection.service.DrivingDirectionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/driving-direction")
class DrivingDirectionController(
    private val drivingDirectionService: DrivingDirectionService,
    private val addressTranslator: AddressTranslator,
) {

    @GetMapping
    fun getDrivingDirection(
        @ModelAttribute request: GetDrivingDirectionRequest,
    ): VdResponse<GetDrivingDirectionResponse> {
        return VdResponse.of(GetDrivingDirectionResponse.from(drivingDirectionService.create(request)))
    }

    @GetMapping("/position-test")
    fun getPositionByAddress(
        @ModelAttribute request: GetPositionByAddressRequest
    ): VdResponse<Position> {
        println(request)
        return VdResponse.of(addressTranslator.translate(request.address))
    }
}
