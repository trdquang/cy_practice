package org.example.cafeweb.service.impl;

import org.example.cafeweb.dto.request.CartRequest;
import org.example.cafeweb.dto.response.CartRespone;
import org.example.cafeweb.search.CartSearch;
import org.example.cafeweb.service.ICartService;
import org.example.cafeweb.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartService implements ICartService {
    private DBConnect dbConnect = new DBConnect();
    private Scanner sc = new Scanner(System.in);

    @Override
    public List<CartRespone> getAll(CartSearch cartSearch) {
        List<CartRespone> cartResponeList = new ArrayList<>();
//        String sql = "select * from cart where customerNumber = ?";
        String sql = "SELECT ca.cartId, ca.customerNumber, ca.productCode,cus.customerName, prd.productName,ca.quantity, ca.price" +
                "  FROM cart ca " +
                "join customers cus on ca.customerNumber = cus.customerNumber " +
                "join products prd on ca.productCode = prd.productCode " +
                "WHERE ca.customerNumber = ?;";
        try(Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, cartSearch.getCustomerNumber());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 int cartId = resultSet.getInt("ca.cartId");
                 int customerId = resultSet.getInt("ca.customerNumber");
                 String productCode = resultSet.getString("ca.productCode");
                 String customerName = resultSet.getString("cus.customerName");
                 String productName = resultSet.getString("prd.productName");
                 int quantity = resultSet.getInt("ca.quantity");
                 double priceEach = resultSet.getDouble("ca.price");
                 CartRespone cartRespone = new CartRespone(cartId, customerId, productCode, customerName, productName, quantity,
                         priceEach);
                 cartResponeList.add(cartRespone);
            }

        }catch (SQLException e){
            System.out.println("err when search cart: " + e);
        }
        return cartResponeList;
    }

    @Override
    public CartRequest add(CartRequest cartRequest) {
        String sql = "insert into cart (cartID, customerNumber, productCode, quantity, price) " +
                "value(?, ?, ?, ?, ?)";
        try(Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, cartRequest.getCustomerId());
            preparedStatement.setString(3, cartRequest.getProductCode());
            preparedStatement.setInt(4, cartRequest.getQuantity());
            preparedStatement.setDouble(5, cartRequest.getPriceEach());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Err when save cart " + e);
        }
        return cartRequest;
    }

    @Override
    public int edit(CartRequest cartRequest) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from cart where cartId = ?";
        try(Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("delete cart success");
        }catch (SQLException e){
            System.out.println("Err when delete " + e);
        }
        return 0;
    }

    @Override
    public CartRespone findById(Integer id) {
//        CartRespone cartRespone = new CartRespone();
        String sql = "SELECT ca.cartId, ca.customerNumber, ca.productCode,cus.customerName, prd.productName,ca.quantity, ca.price" +
                "  FROM cart ca " +
                "join customers cus on ca.customerNumber = cus.customerNumber " +
                "join products prd on ca.productCode = prd.productCode " +
                "WHERE ca.cartID = ?;";
        try(Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet =  preparedStatement.executeQuery();
            while (resultSet.next()){
                int cartId = resultSet.getInt("ca.cartId");
                int customerId = resultSet.getInt("ca.customerNumber");
                String productCode = resultSet.getString("ca.productCode");
                String customerName = resultSet.getString("cus.customerName");
                String productName = resultSet.getString("prd.productName");
                int quantity = resultSet.getInt("ca.quantity");
                double priceEach = resultSet.getDouble("ca.price");
                CartRespone cartRespone = new CartRespone(cartId, customerId, productCode, customerName, productName, quantity,
                        priceEach);
                return cartRespone;
            }
        }catch (SQLException e){
            System.out.println("err when search cart by id: " + e);
        }
        return new CartRespone();
    }
}
