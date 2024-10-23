package dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResp {
    private int id;
    private String userName;
    private String passWord;
    private String fullName;
    private int active;
    private String avatar;
    private String role;
    private Date createdate;
    private Date updatedate;

}
