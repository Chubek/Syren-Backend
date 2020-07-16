package com.syren.backend.syrenbackend.service.display

import com.syren.backend.syrenbackend.dao.impl.MonitorDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.display.Monitor
import com.syren.backend.syrenbackend.repository.display.MonitorRepository
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorOrientation
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorSoundOutput
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorStatus
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.WifiMode
import com.syren.backend.syrenbackend.subschema.dataclass.info.MonitorInformation
import com.syren.backend.syrenbackend.subschema.dataclass.info.monitor.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service


@Service
@ComponentScan
class MonitorService {

    @Autowired
    private lateinit var monitorDao: MonitorDao

    @Autowired
    private lateinit var monitorRepository: MonitorRepository

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createMonitorWithAccessPhrase(accessPhrase: String): String {

        val basicMonitorInfo = BasicMonitorInfo(tags = mutableListOf(), monitorOrientation = MonitorOrientation.NORMAL)
        val monitorNetwork = MonitorNetwork(wifiEnabled = true, networkName = "", wifiMode = WifiMode.WPA_WPA2, hidden = false, checkSum = "")
        val monitorLocation = MonitorLocation(cityName = "London", lat = 2322.23, lng = 1323.33)
        val monitorResolution = MonitorResolution(width = 1920, height = 1080, colorDepth = 8, refreshRate = 60.00)
        val monitorSoundDisplay = MonitorSoundDisplay(resolution = monitorResolution, soundOutput = MonitorSoundOutput.ANALOGUE, volume = 80)

        val monitorInformation = MonitorInformation(basicMonitorInfo = basicMonitorInfo, monitorNetwork = monitorNetwork, location = monitorLocation, soundAndDisplay = monitorSoundDisplay, status = MonitorStatus.WORKING)

        val monitor = Monitor(accessPhrase = accessPhrase,
                formerStreams = mutableListOf(),
                information = monitorInformation)

        val monitorDto = dtoMappers.monitorMapperDto(monitor)

        return monitorDao.createMonitor(monitorDto)

    }

    fun updateMonitorBasicInfo(id: String, tags: MutableList<String>, monitorOrientation: MonitorOrientation, monitorStatus: MonitorStatus) {

        val monitorDto = monitorRepository.findById(id)

        var monitor = dtoMappers.monitorMapperEntity(monitorDto.get())

        val basicMonitorInfo = BasicMonitorInfo(tags, monitorOrientation)

        monitor.information.basicMonitorInfo = basicMonitorInfo
        monitor.information.status = monitorStatus

        val newDto = dtoMappers.monitorMapperDto(monitor)

        monitorDao.updateMonitor(newDto)

    }

    fun updateMonitorLocation(id: String, city: String, lat: Double, lng: Double) {

        val monitorDto = monitorRepository.findById(id)

        var monitor = dtoMappers.monitorMapperEntity(monitorDto.get())

        val monitorLocation = MonitorLocation(city, lat, lng)

        monitor.information.location = monitorLocation

        val newDto = dtoMappers.monitorMapperDto(monitor)

        monitorDao.updateMonitor(newDto)

    }

    fun updateMonitorNetwork(id: String, wifiEnabled: Boolean, networkName: String, wifiMode: WifiMode, hidden: Boolean, checkSum: String) {

        val monitorDto = monitorRepository.findById(id)

        var monitor = dtoMappers.monitorMapperEntity(monitorDto.get())

        val monitorNetwork = MonitorNetwork(wifiEnabled, networkName, wifiMode, hidden, checkSum)

        monitor.information.monitorNetwork = monitorNetwork

        val newDto = dtoMappers.monitorMapperDto(monitor)

        monitorDao.updateMonitor(newDto)

    }

    fun updateMonitorSoundDisplay(id: String, width: Int, height: Int, refreshRate: Double, colorDepth: Int, soundOutput: MonitorSoundOutput, volume: Int) {

        val monitorDto = monitorRepository.findById(id)

        var monitor = dtoMappers.monitorMapperEntity(monitorDto.get())

        val monitorResolution = MonitorResolution(width, height, refreshRate, colorDepth)

        val monitorDisplaySound = MonitorSoundDisplay(monitorResolution, soundOutput, volume)

        monitor.information.soundAndDisplay = monitorDisplaySound

        val newDto = dtoMappers.monitorMapperDto(monitor)

        monitorDao.updateMonitor(newDto)

    }

    fun updateMonitorAccessPhrase(id: String, accessPhrase: String) {

        val monitorDto = monitorRepository.findById(id)

        var monitor = dtoMappers.monitorMapperEntity(monitorDto.get())

        monitor.accessPhrase = accessPhrase

        val newDto = dtoMappers.monitorMapperDto(monitor)

        monitorDao.updateMonitor(newDto)

    }

    fun updateMonitorCurrentStream(id: String, currentStreamId: String) {

        val monitorDto = monitorRepository.findById(id)

        var monitor = dtoMappers.monitorMapperEntity(monitorDto.get())

        monitor.currentStreamId = currentStreamId

        val newDto = dtoMappers.monitorMapperDto(monitor)

        monitorDao.updateMonitor(newDto)

    }

    fun updateMonitorDefaultStream(id: String, defaultStreamId: String) {

        val monitorDto = monitorRepository.findById(id)

        var monitor = dtoMappers.monitorMapperEntity(monitorDto.get())

        monitor.defaultStreamId = defaultStreamId

        val newDto = dtoMappers.monitorMapperDto(monitor)

        monitorDao.updateMonitor(newDto)

    }


    fun getMonitor(id: String): Monitor {

        val monitorDto = monitorDao.getMonitor(id)

        return dtoMappers.monitorMapperEntity(monitorDto.get())


    }


    fun deleteMonitor(id: String) {
        monitorDao.deleteMonitor(id)
    }

}