package com.syren.backend.syrenbackend.service.moderator

import com.mongodb.internal.connection.tlschannel.util.Util.assertTrue
import com.syren.backend.syrenbackend.dao.impl.ModeratorDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.dto.modeldataclass.ModeratorDto
import com.syren.backend.syrenbackend.model.moderator.Moderator
import com.syren.backend.syrenbackend.service.security.JWT
import com.syren.backend.syrenbackend.subschema.LoginReturn
import org.apache.catalina.core.ApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
@ComponentScan
class ModeratorService {

    @Autowired
    private lateinit var moderatorDao: ModeratorDao

    @Autowired
    private lateinit var jwt: JWT

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    val emailRegex = """(?:[a-z0-9!#${'$'}%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#${'$'}%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])""".toRegex()
    val mobileNumberRegex = """^(00|\+)[1-9]{1}([0-9][\s]*){9,16}${'$'}""".toRegex()

    fun registerModerator(email: String, password: String, firstName: String, lastName: String, mobileNumber: String): String {

        try {
            assertTrue(emailRegex matches  email)
            assertTrue(mobileNumberRegex matches  mobileNumber)
        } catch (e: Exception) {
            throw e
        }


        val hash = passwordEncoder.encode(password).toString()

        val moderator = Moderator(email = email, firstName = firstName, lastName = lastName, password = hash, mobileNumber = mobileNumber)

        val moderatorDto = dtoMappers.moderatorMapperDto(moderator)

        return moderatorDao.createModerator(moderatorDto)
    }

    fun authModerator(loginString: String, password: String): LoginReturn {

        lateinit var moderatorDto: ModeratorDto

       when {
           emailRegex matches loginString -> {
                moderatorDto = moderatorDao.findByEmail(loginString)
           }
           mobileNumberRegex matches  loginString -> {
               moderatorDto = moderatorDao.findByMobileNumber(loginString)
           }
       }


        try {
            assertTrue(passwordEncoder.matches(password, moderatorDto.password))
        } catch (e: Exception) {
            throw e
        }


        val token = jwt.createJwt(moderatorDto.id)

        return LoginReturn(dtoMappers.moderatorMapperEntity(moderatorDto), token)
    }

    fun deleteModerator(id: String) {
        moderatorDao.deleteModerator(id)
    }

    fun getModerator(id: String): Moderator {
        return dtoMappers.moderatorMapperEntity(moderatorDao.getModerator(id).get())
    }

}


