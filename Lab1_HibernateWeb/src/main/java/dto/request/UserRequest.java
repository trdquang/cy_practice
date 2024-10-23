package dto.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    private int id;
    private String userName;
    private String passWord;
    private String fullName;
    private int active;
    private String avatar;
    private String role;
    private Date createDate;
    private Date updateDate;
}
