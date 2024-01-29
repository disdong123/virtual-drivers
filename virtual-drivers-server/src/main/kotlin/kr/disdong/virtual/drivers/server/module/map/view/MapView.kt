package kr.disdong.virtual.drivers.server.module.map.view

import kr.disdong.virtual.drivers.api.client.config.feign.properties.NaverMapProperties
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class MapView(
    private val naverMapProperties: NaverMapProperties,
) {

    @GetMapping("/map")
    fun map(
        model: Model
    ): String {
        model.addAttribute("naverMapClientId", naverMapProperties.clientId)
        return "NaverMap"
    }
}
