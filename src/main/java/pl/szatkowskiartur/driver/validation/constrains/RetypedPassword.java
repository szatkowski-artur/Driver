package pl.szatkowskiartur.driver.validation.constrains;

import pl.szatkowskiartur.driver.validation.validators.NewUserRePasswordValidatorForNewUser;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NewUserRePasswordValidatorForNewUser.class)
public @interface RetypedPassword {


    String message() default "Passwords must be the same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
