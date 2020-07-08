package com.syren.backen.syrenbackend.model.moderator

import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.experimental.Accessors
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "user.moderator")
class Moderator {
    @Id
    private lateinit var id: String

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var email: String

    private lateinit var password: String

    private lateinit var firstName: String

    private lateinit var lastName: String

    private lateinit var mobileNumber: String

    fun getFullName(): String {
        return "$firstName $lastName"
    }




}