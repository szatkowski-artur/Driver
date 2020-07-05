package pl.szatkowskiartur.driver.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.szatkowskiartur.driver.validation.constrains.EmailExist;
import pl.szatkowskiartur.driver.validation.constrains.RetypedPassword;
import pl.szatkowskiartur.driver.validation.constrains.UsernameExist;

import javax.validation.constraints.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RetypedPassword
public class NewUser {

    @NotBlank
    @Size(min = 3, message = "Username must be at least 3 characters")
    @UsernameExist
    String username;

    @NotBlank
    @Email(message = "This is not proper email address")
    @EmailExist
    String email;

    @NotBlank
    @Size(min = 8, message = "Password must be at least 6 characters")
    @Pattern(regexp = "^(?=.*\\d+)(?=.*[a-z]+)(?=.*[A-Z]+).*$", message = "Password must contain uppercase and lowercase letter and a digit")
    String password;

    @NotBlank
    String rePassword;

    @AssertTrue(message = "Terms & conditions must be accepted")
    @NotNull
    Boolean termsAndConditions;

}
