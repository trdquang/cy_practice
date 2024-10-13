package org.example.cafeweb.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartRespone {
    private int cartId;
    private int customerId;
    private String productCode;
    private String customerName;
    private String productName;
    private int quantity;
    private double priceEach;
    private String image;
    private int active;
}
