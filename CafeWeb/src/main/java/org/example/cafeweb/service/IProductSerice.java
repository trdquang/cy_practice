package org.example.cafeweb.service;

import org.example.cafeweb.dto.request.OrderDetailRequest;
import org.example.cafeweb.dto.request.ProductRequest;
import org.example.cafeweb.dto.response.ProductResponse;
import org.example.cafeweb.search.ProductSearch;

import java.util.List;
import java.util.Set;

public interface IProductSerice {
    List<ProductResponse> getAll(ProductSearch productSearch, int activeStatus);
//    List<ProductResponse>getAllActive(ProductSearch productSearch);
    int add (ProductRequest productRequest);
    int edit(ProductRequest productRequest);
    int editWithOrder(OrderDetailRequest orderDetailRequest);
    int deleteById (String id);
    ProductResponse findById(String id);
    Set<String> getAllProductLine(int statusActive);
    Set<String>getAllProductVendor(int statusActive);
    int changeStatus(String id, int active);
}
