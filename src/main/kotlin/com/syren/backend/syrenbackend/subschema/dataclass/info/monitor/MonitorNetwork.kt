package com.syren.backend.syrenbackend.subschema.dataclass.info.monitor

import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.WifiMode

data class MonitorNetwork(val wifiEnabled: Boolean, val networkName: String, val wifiMode: WifiMode, val hidden: Boolean, val checkSum: String)