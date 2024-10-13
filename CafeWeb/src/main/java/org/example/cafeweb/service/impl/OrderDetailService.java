package org.example.cafeweb.service.impl;

import org.example.cafeweb.dto.request.OrderDetailRequest;
import org.example.cafeweb.dto.response.OrderDetailResponse;
import org.example.cafeweb.search.OrderSearch;
import org.example.cafeweb.service.IOrderDetailService;
import org.example.cafeweb.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailService implements IOrderDetailService {
    private DBConnect dbConnect = new DBConnect();
    @Override
    public List<OrderDetailResponse> getAll(OrderSearch orderSearch) {
        return List.of();
    }

    @Override
    public int add(OrderDetailRequest orderDetailRequest) {
        int status = 0;
        String sql = "INSERT INTO orderdetails (orderNumber, productCode, quantityOrdered, priceEach) " +
                "VALUES (?, ?, ?, ?) ";
//                "ON DUPLICATE KEY UPDATE " +
//                "quantityOrdered = ?, priceEach = ?";
        try(Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, orderDetailRequest.getOrderNumber());
            preparedStatement.setString(2, orderDetailRequest.getProductCode());
            preparedStatement.setInt(3, orderDetailRequest.getQuantityOrdered());
            preparedStatement.setDouble(4, orderDetailRequest.getPriceEach());
//            preparedStatement.setString(5, orderDetailRequest.getProductCode());

            status = preparedStatement.executeUpdate();
//            System.out.println("status = " + status);

        }catch (SQLException e){
            System.out.println("Err save order detail: " + e.getMessage());
        }
        return status;
    }

    @Override
    public int edit(OrderDetailRequest orderDetailRequest) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public OrderDetailResponse findById(String id) {
        return null;
    }
}
