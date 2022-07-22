package com.hexagonal.domain.model

data class User(
    val name: String,
    val email: String,
    val age: Short? = null
)