package com.hexagonal.entry.rest.convert

import com.hexagonal.domain.model.User
import com.hexagonal.domain.model.Vaccine
import com.hexagonal.domain.model.VaccineApplication
import com.hexagonal.entry.rest.dto.VaccineApplicationRequest
import com.hexagonal.entry.rest.dto.VaccineApplicationResponse

class EntryMapper {
    companion object {
        fun toVaccineApplication(
            request: VaccineApplicationRequest
        ): VaccineApplication {
            val vaccine = Vaccine(
                name = request.vaccineName
            )
            val user = User(
                name = request.userName,
                email = request.userEmail,
                age = request.userAge
            )
            return VaccineApplication(
                vaccine = vaccine,
                user = user
            )
        }

        fun toVaccineApplicationResponse(
            vaccineApplication: VaccineApplication
        ): VaccineApplicationResponse {
            return VaccineApplicationResponse(
                id = vaccineApplication.id
            )
        }
    }
}