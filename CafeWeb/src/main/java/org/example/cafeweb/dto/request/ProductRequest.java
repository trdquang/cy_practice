package org.example.cafeweb.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private String productCode;
    private String productName;
    private String productLine;
    private String productVendor;
    private int  quantityInStock;
    private double buyPrice;
    private String image;
    private int active;
}
