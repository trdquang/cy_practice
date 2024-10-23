package dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResp {
    private int id;
    private String name;

    private List<ProductResp> productRespList;
}
