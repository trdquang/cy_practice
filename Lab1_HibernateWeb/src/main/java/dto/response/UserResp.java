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
    private Date createdate;
    private Date updatedate;
    private String fullname;
}
