package org.example.cafeweb.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private int orderNumber;
    private String productCode;
    private String productName;
    private String customerName;
    private int quantityOrdered;
    private double priceEach;
    private String image;
    private int active;
}
