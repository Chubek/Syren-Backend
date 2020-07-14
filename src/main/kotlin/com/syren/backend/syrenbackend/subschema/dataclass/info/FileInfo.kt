package com.syren.backend.syrenbackend.subschema.dataclass.info

import java.nio.file.Path
import java.util.*

data class FileInfo(val id: String = UUID.randomUUID().toString(), val dateUploaded: Date, val pathUrl: String, val serverPath: Path, val checksum: String)
