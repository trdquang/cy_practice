package org.example.cafeweb.service.impl;

import org.example.cafeweb.dto.request.OrderDetailRequest;
import org.example.cafeweb.dto.request.OrderRequest;
import org.example.cafeweb.dto.response.OrderDetailResponse;
import org.example.cafeweb.search.OrderSearch;
import org.example.cafeweb.service.IOrderService;
import org.example.cafeweb.util.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {
    private DBConnect dbConnect = new DBConnect();
    @Override
    public List<OrderDetailResponse> getAll(OrderSearch orderSearch) {
        List<OrderDetailResponse> orderResponses = new ArrayList<>();
        String sql =
                "SELECT odt.orderNumber, odt.productCode, odt.quantityOrdered, odt.priceEach, pd.productName, pd.image, pd.active " +
                        "FROM orderdetails odt " +
                        "JOIN products pd ON odt.productCode = pd.productCode " +
                        "WHERE odt.orderNumber IN ( " +
                        "SELECT DISTINCT orderNumber " +
                        "FROM orders " +
                        "WHERE customerNumber = 496)";

        try(Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int orderNumber = resultSet.getInt("orderNumber");
                String productCode = resultSet.getString("productCode");
                int quantityOrdered = resultSet.getInt("quantityOrdered");
                double priceEach = resultSet.getDouble("priceEach");
                String productName = resultSet.getString("productName");
                String image = resultSet.getString("pd.image");
                int active = resultSet.getInt("pd.active");


                OrderDetailResponse orderResponse = new OrderDetailResponse();
                orderResponse.setCustomerName("Kelly s Gift Shop");
                orderResponse.setOrderNumber(orderNumber);
                orderResponse.setProductCode(productCode);
                orderResponse.setQuantityOrdered(quantityOrdered);
                orderResponse.setPriceEach(priceEach);
                orderResponse.setProductName(productName);
                orderResponse.setImage(image);
                orderResponse.setActive(active);

                orderResponses.add(orderResponse);
            }

        }catch (Exception e){

        }
        return orderResponses;
    }

    @Override
    public OrderDetailRequest add(OrderRequest orderRequest) {
        OrderDetailRequest orderDetailRequest = new OrderDetailRequest();
        String sql = "insert into orders (orderNumber, customerNumber) value(?, ?)";
        try(Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)   {

            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, orderRequest.getCustomerNumber());
            int start = preparedStatement.executeUpdate();

            if (start > 0) {
                // Lấy khóa tự động sinh
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // Lấy giá trị khóa tự động sinh bằng tên cột
                        int idOr =  generatedKeys.getInt(1);
                        orderDetailRequest.setOrderNumber(idOr);
                    }
                }catch (Exception e){

                }
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailRequest;
    }

    @Override
    public OrderDetailRequest edit(OrderRequest orderRequest) {
        return null;
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
