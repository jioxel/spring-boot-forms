package com.jioxel.app.cspringbootform.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
@Constraint(validatedBy = IdentificadorRegexValidador.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface IdentificadorRegex {
     String message() default "Identificador invalido";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
