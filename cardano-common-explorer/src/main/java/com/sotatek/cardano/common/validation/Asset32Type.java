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
@Constraint(validatedBy = Asset32TypeValidator.class)
@Documented
public @interface Asset32Type {
  String message() default "The value must be Asset32Type";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}

class Asset32TypeValidator implements ConstraintValidator<Asset32Type, byte[]> {

  @Override
  public boolean isValid(byte[] data, ConstraintValidatorContext constraintValidatorContext) {
    return data.length == 32;
  }
}
