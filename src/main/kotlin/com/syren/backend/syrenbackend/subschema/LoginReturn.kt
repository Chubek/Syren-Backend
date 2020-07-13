package com.syren.backend.syrenbackend.subschema

import com.syren.backend.syrenbackend.model.moderator.Moderator


data class LoginReturn(val moderator: Moderator, val token: String)