package com.hexagonal.infra.authorize.adapter

import com.hexagonal.domain.model.User
import com.hexagonal.domain.port.Token
import io.micronaut.context.annotation.Prototype

@Prototype
class Authorizer : Token {
    override fun get(
        user: User?
    ): String? {
        return if (user != null) {
            "ASODKASDKPASKODAS-TOKEN!"
        } else {
            null
        }
    }
}