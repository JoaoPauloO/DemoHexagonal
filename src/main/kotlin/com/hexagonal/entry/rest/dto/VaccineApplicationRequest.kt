package com.hexagonal.entry.rest.dto

class VaccineApplicationRequest(
    val vaccineName: String,
    val userName: String,
    val userEmail: String,
    val userAge: Short? = null
)