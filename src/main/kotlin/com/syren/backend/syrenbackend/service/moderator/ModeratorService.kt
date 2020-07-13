package com.syren.backend.syrenbackend.service.moderator

import com.syren.backend.syrenbackend.dao.impl.ModeratorDao
import com.syren.backend.syrenbackend.dto.modeldataclass.ModeratorDto
import com.syren.backend.syrenbackend.model.moderator.Moderator
import com.syren.backend.syrenbackend.service.security.JWT
import org.apache.catalina.core.ApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
@ComponentScan
class ModeratorService {

    @Autowired
    private lateinit var moderatorDao: ModeratorDao

    @Autowired
    private lateinit var jwt: JWT

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    fun registerModerator(email: String, password: String, firstName: String, lastName: String, mobileNumber: String): String {

        val hash = passwordEncoder.encode(password).toString()

        val moderator = Moderator(email = email, firstName = firstName, lastName = lastName, password = hash, mobileNumber = mobileNumber)

        return jwt.createJwt(moderator.id)
    }




}


