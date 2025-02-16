package com.ajcode404

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [AlphabetValidator::class])
annotation class AlphabetOnly(
    val message: String = "Only letters are allowed",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class AlphabetValidator : ConstraintValidator<AlphabetOnly, String> {

    override fun isValid(value: String?, p1: ConstraintValidatorContext?): Boolean {
        return value?.matches(Regex("^[A-Za-z]+$")) ?: false
    }

}