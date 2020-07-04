package pl.szatkowskiartur.driver.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserServiceImpl userService;

    @PutMapping("/new")
    public void addUser(@RequestBody @Valid NewUser user) {
        userService.addUser(user);
    }

}
