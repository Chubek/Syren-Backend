package com.syren.backend.syrenbackend.service.dataclass.info.monitor

import com.syren.backend.syrenbackend.service.enumclass.WifiMode

data class MonitorNetwork(val wifiEnabled: Boolean, val networkName: String, val wifiMode: WifiMode, val hidden: Boolean, val checkSum: String)