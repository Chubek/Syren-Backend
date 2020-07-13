package com.syren.backend.syrenbackend.model.moderator

import lombok.experimental.Accessors
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Accessors(chain = true)
@Document(collection = "user.moderator")
data class Moderator(@Id val id: String = UUID.randomUUID().toString(),
                     @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true) val email: String,
                     val password: String, val firstName: String, val lastName: String, val mobileNumber: String)