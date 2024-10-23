package dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResp {
    private int id;
    private String name;

    private int idCategory;
    private String categoryName;
}
