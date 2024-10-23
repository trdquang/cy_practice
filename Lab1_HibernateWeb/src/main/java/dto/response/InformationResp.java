package dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationResp {
    private int id;
    private String name_info;

    private int productId;
    private String productName;
}
