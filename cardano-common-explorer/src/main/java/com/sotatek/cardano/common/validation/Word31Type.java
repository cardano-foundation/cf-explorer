package com.sotatek.cardano.common.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Word31TypeValidator.class)
@Documented
public @interface Word31Type {
  String message() default "The value must be Word31Type";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}

class Word31TypeValidator implements ConstraintValidator<Word31Type, Integer> {

  @Override
  public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
    return integer >= 0;
  }
}