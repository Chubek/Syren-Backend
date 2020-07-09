package com.syren.backend.syrenbackend.dao

import com.syren.backend.syrenbackend.dto.modeldataclass.*
import com.syren.backend.syrenbackend.model.resource.*

interface MediaResourceServiceInterface {

    fun createAudioResource(audioResourceDto: AudioResourceDto): String

    fun createVideoResource(videoResourceDto: VideoResourceDto): String

    fun createImageResource(imageResourceDto: ImageResourceDto): String

    fun updateAudioResource(audioResourceDto: AudioResourceDto): Void

    fun updateVideoResource(videoResourceDto: VideoResourceDto): Void

    fun updateImageResource(imageResourceDto: ImageResourceDto): Void

    fun deleteAudioResource(audioResourceDto: AudioResourceDto): Void

    fun deleteVideoResource(videoResourceDto: VideoResourceDto): Void

    fun deleteImageResource(imageResourceDto: ImageResourceDto): Void

    fun getAudioResource(id: String): AudioResource

    fun getVideoResource(id: String): VideoResource

    fun getImageResource(id: String): ImageResource


}

interface WebPageResourceServiceInterface {

    fun createWebPageResource(webPageResourceDto: WebPageResourceDto): String

    fun updateWebPageResource(id: String, webPageResourceDto: WebPageResourceDto): Void

    fun getWebPageResource(id: String): WebPageResource

    fun deleteWebPageResource(id: String): Void

}


interface WidgetResourceServiceInterface {

    fun createWidgetResource(widgetResourceDto: WidgetResourceDto): String

    fun updateWidgetResource(id: String, widgetResourceDto: WidgetResourceDto): Void

    fun getWidgetResource(id: String): WidgetResource

    fun deleteWidgetResource(id: String): Void
}