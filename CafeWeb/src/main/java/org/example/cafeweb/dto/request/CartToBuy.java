package org.example.cafeweb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartToBuy {
    private int idCart;
    private int idProduct;
    private int quantity;
}
