package org.example.cafeweb.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private String productCode;
    private String productName;
    private String productLine;
    private int  quantityInStock;
    private double buyPrice;
    private String productVendor;
    private String image;
    private int active;
//    private
}
