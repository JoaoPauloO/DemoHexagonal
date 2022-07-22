package com.hexagonal.infra.databasestatic.entity

class VaccineApplicationEntity(
    var id: String = String(),
    val vaccine: VaccineEntity,
    val user: UserEntity
)