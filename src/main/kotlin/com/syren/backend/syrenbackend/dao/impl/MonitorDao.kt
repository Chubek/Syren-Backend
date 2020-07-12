package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.MonitorDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.MonitorDto
import com.syren.backend.syrenbackend.repository.display.MonitorRepository
import org.graalvm.compiler.lir.CompositeValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


@Component
class MonitorDao: MonitorDaoInterface {

    @Autowired
    private lateinit var monitorRepository: MonitorRepository

    override fun createMonitor(monitorDto: MonitorDto): String {
        return monitorRepository.save(monitorDto).Id
    }

    override fun deleteMonitor(id: String) {
        monitorRepository.deleteById(id)
    }

    override fun findByAccessPhrase(accessPhrase: String): MonitorDto {
        return monitorRepository.findByAccessPhrase(accessPhrase)
    }

    override fun getMonitor(id: String): Optional<MonitorDto> {
        return monitorRepository.findById(id)
    }

    override fun findByCurrentStreamId(currentStreamId: String): MonitorDto {
        return monitorRepository.findByCurrentStreamId(currentStreamId)
    }

    override fun findByDefaultStreamId(defaultStreamId: String): MonitorDto {
        return monitorRepository.findByDefaultStreamId(defaultStreamId)
    }

    override fun updateMonitor(monitorDto: MonitorDto) {
        monitorRepository.save(monitorDto)
    }
}