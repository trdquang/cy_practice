package myproject.dto.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private Long id;
    private String username;
    private String password;
    private String fullname;
    private String avatar;

    private int active;
    private String email;
    private String role;

    private Date create_date;
    private Date update_date;
}
