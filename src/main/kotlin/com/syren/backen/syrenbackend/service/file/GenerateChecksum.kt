package com.syren.backen.syrenbackend.service.file

import java.io.FileInputStream
import java.lang.StringBuilder
import java.nio.file.Path
import java.security.DigestInputStream
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


fun generateChecksum(filePath: Path): String {
    try {
        val md = MessageDigest.getInstance("SHA-256")
        val fis = FileInputStream(filePath.toAbsolutePath().toString())
        val dis = DigestInputStream(fis, md)

        while (dis.read() != -1) {
            continue
        }

        val result = StringBuilder()

        for (b: Byte in md.digest()) {
            result.append(java.lang.String.format("%02x", b))
        }

        return result.toString()


    } catch (e: NoSuchAlgorithmException) {
        throw e
    }
}

