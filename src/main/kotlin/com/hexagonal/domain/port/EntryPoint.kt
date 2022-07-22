package com.hexagonal.domain.port

import com.hexagonal.domain.model.VaccineApplication

interface EntryPoint {
    fun createVaccineApplication(vaccineApplication: VaccineApplication): VaccineApplication
}