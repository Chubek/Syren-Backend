package com.syren.backen.syrenbackend.service.dataclass

import java.nio.file.Path
import java.util.*

data class FileInfo(val id: UUID, val dateUploaded: Date, val pathUrl: String, val serverPath: Path, val checksum: String)
