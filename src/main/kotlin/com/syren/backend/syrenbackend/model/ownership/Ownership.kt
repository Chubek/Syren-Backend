package com.syren.backend.syrenbackend.model.ownership

import lombok.experimental.Accessors
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Accessors(chain = true)
@Document(collection = "ownership.ownership")
data class Ownership(@Id val id: String = UUID.randomUUID().toString(),
                     @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true) val moderatorId: String, val mediaResourcesList: MutableList<String>,
                     val scriptResourcesList: MutableList<String>, val overrideMessagesList: MutableList<String>, val overrideResourcesList: MutableList<String>,
                     val streamsList: MutableList<String>, val playListsList: MutableList<String>, val scheduleLists: MutableList<String>)