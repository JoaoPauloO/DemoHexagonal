package com.hexagonal.entry.adapter

import com.hexagonal.domain.model.VaccineApplication
import com.hexagonal.domain.port.EntryPoint
import com.hexagonal.domain.port.Token
import com.hexagonal.domain.service.CreateVaccineApplication
import io.micronaut.context.annotation.Prototype

@Prototype
class EntryPointAdapter(
    private val tokenService: Token,
    private val createVaccineApplication: CreateVaccineApplication
) : EntryPoint {
    override fun createVaccineApplication(
        vaccineApplication: VaccineApplication
    ): VaccineApplication {
        val user = vaccineApplication.user
        val token = tokenService.get(
            user = user
        )
        return createVaccineApplication.execute(
            vaccineApplication = vaccineApplication,
            tokenValue = token
        )
    }
}