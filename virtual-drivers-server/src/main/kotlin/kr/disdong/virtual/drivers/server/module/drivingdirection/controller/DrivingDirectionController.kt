package kr.disdong.virtual.drivers.server.module.drivingdirection.controller

import kr.disdong.virtual.drivers.common.dto.VdResponse
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.DrivingDirectionRequest
import kr.disdong.virtual.drivers.server.module.drivingdirection.dto.DrivingDirectionResponse
import kr.disdong.virtual.drivers.server.module.drivingdirection.service.DrivingDirectionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/driving-direction")
class DrivingDirectionController(
    private val drivingDirectionService: DrivingDirectionService,
) {

    @Deprecated("테스트용입니다. Post 를 이용해주세요.")
    @GetMapping
    fun getDrivingDirection(
        @ModelAttribute request: DrivingDirectionRequest,
    ): VdResponse<DrivingDirectionResponse> {
        return VdResponse.of(drivingDirectionService.create(request))
    }

    @PostMapping
    fun createDrivingDirection(
        @RequestBody request: DrivingDirectionRequest,
    ): VdResponse<DrivingDirectionResponse> {
        return VdResponse.of(drivingDirectionService.create(request))
    }
}
