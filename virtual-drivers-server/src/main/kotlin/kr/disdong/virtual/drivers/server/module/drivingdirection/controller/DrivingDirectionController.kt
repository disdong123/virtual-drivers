package kr.disdong.virtual.drivers.server.module.drivingdirection.controller

import kr.disdong.virtual.drivers.common.dto.VdResponse
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.GetDrivingDirectionResponse
import kr.disdong.virtual.drivers.server.module.drivingdirection.service.DrivingDirectionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/driving-direction")
class DrivingDirectionController(
    private val drivingDirectionService: DrivingDirectionService,
) {

    // http://localhost:8080/api/driving-direction?startLatitude=127.001&startLongitude=37.001&goalLatitude=127.001&goalLongitude=37.001
    // http://localhost:8080/api/driving-direction?startLongitude=126.9918&startLatitude=37.5519&goalLongitude=126.7052&goalLatitude=37.4563
    @GetMapping
    fun getDrivingDirection(
        @ModelAttribute request: GetDrivingDirectionRequest,
    ): VdResponse<GetDrivingDirectionResponse> {
        return VdResponse.of(GetDrivingDirectionResponse.from(drivingDirectionService.getDrivingDirection(request)))
    }
}
