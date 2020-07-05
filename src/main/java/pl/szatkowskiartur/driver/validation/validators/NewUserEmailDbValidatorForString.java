package pl.szatkowskiartur.driver.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.szatkowskiartur.driver.user.UserRepository;
import pl.szatkowskiartur.driver.validation.constrains.EmailExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NewUserEmailDbValidatorForString implements ConstraintValidator<EmailExist, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(EmailExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !userRepository.existsByEmail(email);
    }
}
