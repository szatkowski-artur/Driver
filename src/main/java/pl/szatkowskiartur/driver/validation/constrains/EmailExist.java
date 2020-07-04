package pl.szatkowskiartur.driver.validation.constrains;

import pl.szatkowskiartur.driver.validation.validators.NewUserEmailDbValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NewUserEmailDbValidatorForString.class)
public @interface EmailExist {

    String message() default "Account with that email already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
