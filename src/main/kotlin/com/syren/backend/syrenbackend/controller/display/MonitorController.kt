package com.syren.backend.syrenbackend.controller.display

import com.syren.backend.syrenbackend.model.display.Monitor
import com.syren.backend.syrenbackend.service.display.MonitorService
import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorOrientation
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorSoundOutput
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorStatus
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.WifiMode
import com.syren.backend.syrenbackend.subschema.requestobjects.BasicMonitorInfoRequest
import com.syren.backend.syrenbackend.subschema.requestobjects.MonitorLocationRequest
import com.syren.backend.syrenbackend.subschema.requestobjects.MonitorNetworkRequest
import com.syren.backend.syrenbackend.subschema.requestobjects.MonitorSoundDisplayRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/monitor")
class MonitorController {
    @Autowired
    private lateinit var ownershipService: OwnershipService

    @Autowired
    private lateinit var jwtComponent: JWTComponent

    @Autowired
    private lateinit var monitorService: MonitorService

    @PostMapping("/create/{accessPhrase}")
    @ResponseBody
    fun createMonitor(@RequestHeader("x-auth-token") token: String, @PathVariable accessPhrase: String): String {
        val moderatorId = jwtComponent.decodeJwt(token)

        val id = monitorService.createMonitorWithAccessPhrase(accessPhrase)

        ownershipService.addToMonitorList(moderatorId, id)

        return id
    }


    @PutMapping("/update/basicInfo/{id}")
    @ResponseBody
    fun editMonitorBasicInfo(@PathVariable id: String, @RequestHeader("x-auth-token") token: String, @RequestBody basicMonitorRequest: BasicMonitorInfoRequest): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.monitorList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        monitorService.updateMonitorBasicInfo(id, basicMonitorRequest.tags.toMutableList(), MonitorOrientation.valueOf(basicMonitorRequest.monitorOrientation), MonitorStatus.valueOf(basicMonitorRequest.monitorStatus))


        return ResponseEntity(HttpStatus.OK)

    }

    @PutMapping("/update/location/{id}")
    @ResponseBody
    fun editMonitorLocation(@PathVariable id: String, @RequestHeader("x-auth-token") token: String, @RequestBody monitorLocationRequest: MonitorLocationRequest): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.monitorList.contains(id)) {

            return ResponseEntity(HttpStatus.FORBIDDEN)

        }

        monitorService.updateMonitorLocation(id, monitorLocationRequest.city, monitorLocationRequest.lat, monitorLocationRequest.lng)

        return ResponseEntity(HttpStatus.OK)

    }

    @PutMapping("/update/network/{id}")
    @ResponseBody
    fun editMonitorNetwork(@PathVariable id: String, @RequestHeader("x-auth-token") token: String, @RequestBody monitorNetworkRequest: MonitorNetworkRequest): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.monitorList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        monitorService.updateMonitorNetwork(id, monitorNetworkRequest.wifiEnabled,
                monitorNetworkRequest.networkName,
                WifiMode.valueOf(monitorNetworkRequest.wifiMode),
                monitorNetworkRequest.hidden,
                monitorNetworkRequest.checkSum)


        return ResponseEntity(HttpStatus.OK)

    }

    @PutMapping("/update/soundDisplay/{id}")
    @ResponseBody
    fun editMonitorSoundDisplay(@PathVariable id: String, @RequestHeader("x-auth-token") token: String, @RequestBody monitorSoundDisplayRequest: MonitorSoundDisplayRequest): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.monitorList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        monitorService.updateMonitorSoundDisplay(id, monitorSoundDisplayRequest.width,
                monitorSoundDisplayRequest.height,
                monitorSoundDisplayRequest.refreshRate,
                monitorSoundDisplayRequest.colorDepth,
                MonitorSoundOutput.valueOf(monitorSoundDisplayRequest.soundOutput),
                monitorSoundDisplayRequest.volume)

        return ResponseEntity(HttpStatus.OK)
    }


    @PutMapping("/update/accessPhrase/{id}")
    @ResponseBody
    fun editAccessPhrase(@PathVariable id: String, @PathVariable accessPhrase: String): ResponseEntity<String> {
        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.monitorList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        monitorService.updateMonitorAccessPhrase(id, accessPhrase)

        return ResponseEntity(HttpStatus.OK)

    }

    @PutMapping("/update/currentStream/{id}")
    @ResponseBody
    fun editCurrentStream(@PathVariable id: String, @PathVariable currentStream: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.monitorList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        monitorService.updateMonitorCurrentStream(id, currentStream)

        return ResponseEntity(HttpStatus.OK)

    }

    @PutMapping("/update/defaultStream/{id}")
    @ResponseBody
    fun editDefaultStream(@PathVariable id: String, @PathVariable defaultStream: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.monitorList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        monitorService.updateMonitorDefaultStream(id, defaultStream)

        return ResponseEntity(HttpStatus.OK)

    }

    @GetMapping("/get/{id}")
    @ResponseBody
    fun getMonitor(@PathVariable id: String): Monitor {

        return monitorService.getMonitor(id)

    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    fun deleteMonitor(@RequestHeader("x-auth-token") token: String, @PathVariable id: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.monitorList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        monitorService.deleteMonitor(id)

        return ResponseEntity(HttpStatus.GONE)

    }


}