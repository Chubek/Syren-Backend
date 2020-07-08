package com.syren.backend.syrenbackend.repository.list

import com.syren.backend.syrenbackend.model.list.PlayList
import org.springframework.data.mongodb.repository.MongoRepository


interface PlayListRepository: MongoRepository<PlayList, String>