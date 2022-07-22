package com.hexagonal.domain.model

data class VaccineApplication(
    var id: String = String(),
    val vaccine: Vaccine,
    val user: User
)