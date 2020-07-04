package pl.szatkowskiartur.driver.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.szatkowskiartur.driver.role.Role;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@Document(collection = "Users")
public class User {

    @Id
    private String id;

    private String username;

    private String email;

    @ToString.Exclude
    private String password;
//TODO role
//    @ToString.Exclude
//    private Set<Role> roles = new HashSet<>();



}
