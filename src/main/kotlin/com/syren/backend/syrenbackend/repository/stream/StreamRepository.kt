package com.syren.backend.syrenbackend.repository.stream

import com.syren.backend.syrenbackend.model.stream.Stream
import org.springframework.data.mongodb.repository.MongoRepository

interface StreamRepository: MongoRepository<Stream, String>