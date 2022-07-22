package com.hexagonal.domain.port

import com.hexagonal.domain.model.VaccineApplication

interface Repository {
    fun existsUser(email: String): Boolean
    fun existsVaccine(name: String): Boolean
    fun save(vaccineApplication: VaccineApplication): VaccineApplication
}