package myproject.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends Base{

    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String avatar;

    private int active;
    private String email;
    private String role;


}
