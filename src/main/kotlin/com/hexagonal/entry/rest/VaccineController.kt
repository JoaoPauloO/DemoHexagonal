package com.hexagonal.entry.rest

import com.hexagonal.domain.port.EntryPoint
import com.hexagonal.entry.rest.convert.EntryMapper
import com.hexagonal.entry.rest.dto.VaccineApplicationRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller
class VaccineController(
    private val entryPont: EntryPoint
) {

    @Post("/vaccine/application")
    fun createVaccineApplication(
        @Body request: VaccineApplicationRequest
    ): HttpResponse<Any> {
        val vaccineApplication = EntryMapper.toVaccineApplication(request)
        val createResult = entryPont.createVaccineApplication(
            vaccineApplication = vaccineApplication
        )
        val response = EntryMapper.toVaccineApplicationResponse(
            vaccineApplication = createResult
        )
        return HttpResponse.ok(response)
    }
}