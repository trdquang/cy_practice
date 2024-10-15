package org.example.cafeweb.dto.pageable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.cafeweb.dto.response.CartRespone;
import org.example.cafeweb.dto.response.ProductResponse;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CartPageable {
    int totalPages;
    int currentPage;
    private String message;
    List<CartRespone> cartResponeList;
}
