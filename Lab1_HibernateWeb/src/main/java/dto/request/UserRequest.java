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
    private Date create_date;
    private Date update_date;
    private String fullname;
}
