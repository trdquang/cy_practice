package org.example.cafeweb.service;

import org.example.cafeweb.dto.request.CartRequest;
import org.example.cafeweb.dto.request.OrderDetailRequest;
import org.example.cafeweb.dto.request.ProductRequest;
import org.example.cafeweb.dto.response.CartRespone;
import org.example.cafeweb.dto.response.ProductResponse;
import org.example.cafeweb.search.CartSearch;
import org.example.cafeweb.search.ProductSearch;

import java.util.List;
import java.util.Set;

public interface ICartService {
    List<CartRespone> getAll(CartSearch cartSearch);
    CartRequest add (CartRequest cartRequest);
    int edit(CartRequest cartRequest);
    int deleteById (Integer id);
    CartRespone findById(Integer id);
}
