package org.example.cafeweb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailRequest {
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
}
