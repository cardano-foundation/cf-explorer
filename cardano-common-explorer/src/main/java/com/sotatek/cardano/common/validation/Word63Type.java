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
@Constraint(validatedBy = Word63TypeValidator.class)
@Documented
public @interface Word63Type {
  String message() default "The value must be Word63Type";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}
class Word63TypeValidator implements ConstraintValidator<Word63Type, Long> {

  @Override
  public boolean isValid(Long aLong, ConstraintValidatorContext constraintValidatorContext) {
    return aLong >= 0;
  }
}
