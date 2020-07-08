package com.syren.backen.syrenbackend.model.stream

import com.syren.backen.syrenbackend.service.dataclass.NotificationAlert
import com.syren.backen.syrenbackend.service.dataclass.records.OverrideRecord
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
@Document(collection = "stream.override.message")
class OverrideMessage {
    @Id
    private lateinit var id: String


    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var notificationAlert: NotificationAlert

    private lateinit var records: MutableList<OverrideRecord>
}