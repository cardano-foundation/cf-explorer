package com.sotatek.cardano.common.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Word128TypeValidator.class)
@Documented
public @interface Word128Type {
  String message() default "The value must be Word128Type";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}

class Word128TypeValidator implements ConstraintValidator<Word128Type, BigDecimal> {

  @Override
  public boolean isValid(BigDecimal decimal, ConstraintValidatorContext constraintValidatorContext) {
    return decimal.compareTo(new BigDecimal("0")) < 0
        || decimal.compareTo(new BigDecimal("340282366920938463463374607431768211455")) > 0;
  }
}