package com.syren.backend.syrenbackend.repository.list

import com.syren.backend.syrenbackend.dto.modeldataclass.PlayListDto
import org.springframework.data.mongodb.repository.MongoRepository


interface PlayListRepository: MongoRepository<PlayListDto, String>