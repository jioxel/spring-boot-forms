package com.jioxel.app.cspringbootform.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido,String>{

     @Override
     public boolean isValid(String value, ConstraintValidatorContext context) {
          if(value.isBlank() || value.isEmpty()){
               return false;
          }
          return true;
     }
     
}
