package pl.szatkowskiartur.driver.user;

import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface UserMapper {

    User newUserToUser(NewUser newUser);

}
