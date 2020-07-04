package pl.szatkowskiartur.driver.validation.validators;

import pl.szatkowskiartur.driver.user.NewUser;
import pl.szatkowskiartur.driver.validation.constrains.RetypedPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NewUserRePasswordValidatorForNewUser implements ConstraintValidator<RetypedPassword, NewUser> {

    @Override
    public void initialize(RetypedPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(NewUser newUser, ConstraintValidatorContext constraintValidatorContext) {
        return newUser.getPassword().equals(newUser.getRePassword());
    }
}
