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
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*


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

    fun updateMonitorBasicInfo(id: String, tags: MutableList<String>, monitorOrientation: MonitorOrientation) {

        val monitorDto = monitorRepository.findById(id)

        var monitor = dtoMappers.monitorMapperEntity(monitorDto.orElse())

        val basicMonitorInfo = BasicMonitorInfo(tags, monitorOrientation)

        monitor.information.basicMonitorInfo = basicMonitorInfo

        val newDto = dtoMappers.monitorMapperDto(monitor)

        monitorDao.updateMonitor(newDto)

    }



}