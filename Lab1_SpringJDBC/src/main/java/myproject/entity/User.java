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

//    public User( Long id,
//                String username, String password,
//                String fullname, String avatar, int active,
//                String email, String role,Date create_date,
//                 Date update_date) {
//        super(create_date, update_date);
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.fullname = fullname;
//        this.avatar = avatar;
//        this.active = active;
//        this.email = email;
//        this.role = role;
//    }

    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String avatar;

    private int active;
    private String email;
    private String role;


}
