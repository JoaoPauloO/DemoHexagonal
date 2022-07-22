package com.hexagonal.domain.service

import com.hexagonal.domain.model.VaccineApplication
import com.hexagonal.domain.port.Repository
import com.hexagonal.domain.valueobject.TokenValue
import io.micronaut.context.annotation.Prototype

@Prototype
class CreateVaccineApplication(
    private val repository: Repository
) {
    fun execute(
        vaccineApplication: VaccineApplication,
        tokenValue: TokenValue
    ): VaccineApplication {
        if (!tokenValue.isValid) {
            throw Exception("Xabu in token!")
        }
        val token = tokenValue.value
        val user = vaccineApplication.user
        val existsUser = repository.existsUser(
            email = user.email
        )
        val vaccine = vaccineApplication.vaccine
        val existsVaccine = repository.existsVaccine(
            name = vaccine.name
        )
        if (!existsUser or !existsVaccine) {
            throw Exception("User or Vaccine does not exists.")
        }
        return repository.save(
            vaccineApplication = vaccineApplication
        )
    }

    private fun isValidToken(
        token: String?
    ): Boolean {
        return token != null
    }
}