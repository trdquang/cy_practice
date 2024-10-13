package org.example.cafeweb.service;

import org.example.cafeweb.dto.request.OrderDetailRequest;
import org.example.cafeweb.dto.request.OrderRequest;
import org.example.cafeweb.dto.response.OrderDetailResponse;
import org.example.cafeweb.search.OrderSearch;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetailResponse> getAll(OrderSearch orderSearch);
    int add (OrderDetailRequest orderDetailRequest);
    int edit(OrderDetailRequest orderDetailRequest);
    int deleteById (String id);
    OrderDetailResponse findById(String id);
}
