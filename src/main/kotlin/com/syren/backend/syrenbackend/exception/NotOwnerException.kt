package com.syren.backend.syrenbackend.exception

class NotOwnerException(message: String): Exception(message = "This doesn't belong to you.")