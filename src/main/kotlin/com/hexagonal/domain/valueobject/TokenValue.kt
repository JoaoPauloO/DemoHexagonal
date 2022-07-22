package com.hexagonal.domain.valueobject

class TokenValue(
    private val _value: String? = null
) {
    val isValid get() = this._value != null

    val value: String get() = this._value
        ?: throw Exception("Token is null")
}