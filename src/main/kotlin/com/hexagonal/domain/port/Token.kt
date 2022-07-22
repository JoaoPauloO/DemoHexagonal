package com.hexagonal.domain.port

import com.hexagonal.domain.model.User

interface Token {
    fun get(
        user: User?
    ): String?
}