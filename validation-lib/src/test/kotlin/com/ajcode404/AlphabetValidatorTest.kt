package com.ajcode404

import jakarta.validation.Validation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AlphabetValidatorTest {


    data class User(
        @field:AlphabetOnly
        val name: String
    )

    private val validator = Validation
        .buildDefaultValidatorFactory().validator

    @Test
    fun `test alphabetOnly constraint`() {
        val validUser = User(name = "John")
        val invalidUser = User(name = "J123")
        assertEquals(0, validator.validate(validUser).size)
        assertEquals(1, validator.validate(invalidUser).size)
    }
}