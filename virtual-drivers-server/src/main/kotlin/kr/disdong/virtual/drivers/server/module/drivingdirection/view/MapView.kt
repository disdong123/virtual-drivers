package kr.disdong.virtual.drivers.server.module.drivingdirection.view

import kr.disdong.virtual.drivers.api.client.config.feign.properties.NaverMapProperties
import kr.disdong.virtual.drivers.server.module.drivingdirection.service.DrivingDirectionService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MapView(
    private val naverMapProperties: NaverMapProperties,
    private val drivingDirectionService: DrivingDirectionService,
) {

    @GetMapping("/map/main")
    fun map(
        model: Model
    ): String {
        println(naverMapProperties.clientId)
        model.addAttribute("naverMapProperties", naverMapProperties)
        return "map/NaverMap"
    }
}
