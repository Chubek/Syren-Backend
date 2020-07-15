package com.syren.backend.syrenbackend.subschema.dataclass.info

import java.nio.file.Path
import java.util.*

data class FileInfo(val id: String = UUID.randomUUID().toString(), val dateUploaded: Date, val bucket: String, val fileName: String)
