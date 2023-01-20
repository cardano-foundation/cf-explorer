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
@Constraint(validatedBy = Addr29TypeValidator.class)
@Documented
public @interface Addr29Type {
  String message() default "The value must be addr29type";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}

class Addr29TypeValidator  implements ConstraintValidator<Addr29Type, String> {
  @Override
  public boolean isValid(String bytes, ConstraintValidatorContext constraintValidatorContext) {
    return bytes.length() == 58;
  }
}

