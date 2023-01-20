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
@Constraint(validatedBy = LovelaceValidator.class)
@Documented
public @interface Lovelace {
  String message() default "The value must be Lovelace";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };
}

class LovelaceValidator implements ConstraintValidator<Lovelace, BigDecimal> {

  @Override
  public boolean isValid(BigDecimal decimal, ConstraintValidatorContext constraintValidatorContext) {
    return decimal.compareTo(new BigDecimal("0")) >= 0
        && decimal.compareTo(new BigDecimal("18446744073709551615")) <= 0;
  }
}
