package pl.szatkowskiartur.driver.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.szatkowskiartur.driver.user.UserRepository;
import pl.szatkowskiartur.driver.validation.constrains.UsernameExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NewUserUsernameDbValidatorForString implements ConstraintValidator<UsernameExist, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UsernameExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByUsername(username);
    }
}
