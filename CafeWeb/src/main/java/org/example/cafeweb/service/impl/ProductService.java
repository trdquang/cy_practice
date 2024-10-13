package org.example.cafeweb.service.impl;

import org.example.cafeweb.dto.request.OrderDetailRequest;
import org.example.cafeweb.dto.request.ProductRequest;
import org.example.cafeweb.dto.response.ProductResponse;
import org.example.cafeweb.search.ProductSearch;
import org.example.cafeweb.service.IProductSerice;
import org.example.cafeweb.util.DBConnect;
import org.example.cafeweb.util.FunctionUtil;

import java.sql.*;
import java.util.*;

public class ProductService implements IProductSerice {

    private DBConnect dbConnect = new DBConnect();
    private Scanner sc = new Scanner(System.in);

    @Override
    public List<ProductResponse> getAll(ProductSearch productSearch, int activeStatus) {
        List<ProductResponse> productResponses = new ArrayList<>();
        try {
            Connection connection = dbConnect.openConnectToDB();
            String sql = "select * from products where products.productName like '%" + productSearch.getProductName()
                    + "%' and products.productLine like '%"+ productSearch.getProductLine()
                    + "%' and products.productVendor like '%"+ productSearch.getProductVendor()
                    + "%'";
            if(activeStatus != 0)
                sql += " and active=1";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String id = resultSet.getString("productCode");
                String name = resultSet.getString("productName") ;
                String line = resultSet.getString("productLine") ;
                Integer quantity = resultSet.getInt("quantityInStock") ;
                Double price = resultSet.getDouble("buyPrice") ;
                String vendorName = resultSet.getString("productVendor");
                String image = resultSet.getString("image");
                int active = resultSet.getInt("active");
//                String vendorName = "";
                productResponses.add(new ProductResponse(id, name, line, quantity, price, vendorName, image, active));
            }
            connection.close();
        }catch (SQLException e){
            System.out.println("err when search product: " + e.getMessage());
        }

        return productResponses;
    }

    @Override
    public int add(ProductRequest productRequest) {

        String sql = "INSERT INTO products (productCode, productName, productLine, productVendor, quantityInStock," +
                "buyPrice, image, active) VALUES (CONCAT('P', SUBSTRING(REPLACE(UUID(), '-', ''), 1, 5)), ?, ?, ?, ?, ?, ?, ?)";

        int rowsAffected = 0;

        try (Connection connection = dbConnect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

//            preparedStatement.setString(1, productRequest.getProductCode() != null ? productRequest.getProductCode() : "");
            preparedStatement.setString(1, productRequest.getProductName());
            preparedStatement.setString(2, productRequest.getProductLine());
            preparedStatement.setString(3, productRequest.getProductVendor());
            preparedStatement.setInt(4, productRequest.getQuantityInStock());
            preparedStatement.setDouble(5, productRequest.getBuyPrice());
            preparedStatement.setString(6, productRequest.getImage());
            preparedStatement.setInt(7, productRequest.getActive());

            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Add product success");
        } catch (SQLException e) {
            System.out.println("Error when save product: " + e.getMessage());
        }

        return rowsAffected; // Trả về số lượng bản ghi bị ảnh hưởng
    }

    @Override
    public int edit(ProductRequest productRequest) {
//        String sql = "UPDATE products " +
//                "SET productName = ? " +
//                "WHERE productCode = 's1';";
        String sql = "UPDATE products " +
                "SET productName = ?, " +
                "productLine = ?, " +
                "productVendor = ?, " +
                "quantityInStock = ?, " +
                "buyPrice = ?, " +
                "image = ?, " +
                "active = ? " +
                "WHERE productCode = ?";

        try (Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, productRequest.getProductName());
            preparedStatement.setString(2, productRequest.getProductLine());
            preparedStatement.setString(3, productRequest.getProductVendor());
            preparedStatement.setInt(4, productRequest.getQuantityInStock());
            preparedStatement.setDouble(5, productRequest.getBuyPrice());
            preparedStatement.setString(6, productRequest.getImage());
            preparedStatement.setInt(7, productRequest.getActive());
            preparedStatement.setString(8, productRequest.getProductCode());

            int cnt = preparedStatement.executeUpdate();
//            System.out.println("row : " + cnt);
            System.out.println("Edit product success");
        }catch (SQLException e){
            System.out.println("Err when edit product " + e);
        }

        return 0;
    }

    @Override
    public int editWithOrder( OrderDetailRequest orderDetailRequest) {
        int status = 0;
        ProductResponse productResponse = findById(orderDetailRequest.getProductCode());
        String sql = "UPDATE products  " +
                "SET quantityInStock = ? " +
                "WHERE productCode = ? ";
        try(Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            int newQuantity = productResponse.getQuantityInStock() - orderDetailRequest.getQuantityOrdered();
            preparedStatement.setInt(1, newQuantity);
            preparedStatement.setString(2, orderDetailRequest.getProductCode());

            status = preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Err when update product: " + e.getMessage());
        }
        return status;
    }


    @Override
    public int deleteById(String productCode) {
        String sql = "DELETE FROM products WHERE productCode = ?";
        int rowsAffected = 0;

        try (Connection connection = dbConnect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, productCode); // Thiết lập productCode vào PreparedStatement

            rowsAffected = preparedStatement.executeUpdate(); // Thực hiện câu lệnh DELETE
        } catch (SQLException e) {
            System.out.println("Error (SQL): " + e.getMessage());
        }

        return rowsAffected; // Trả về số lượng bản ghi bị ảnh hưởng
    }

    @Override
    public ProductResponse findById(String id) {
        String sql = "select * from products where productCode = ? ";

        try (Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setString(1, id);
//            if(activeStatus != 0)
//                preparedStatement.setInt(2, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String idP = FunctionUtil.defaultIfNull(resultSet.getString("productCode"));
                String nameP = FunctionUtil.defaultIfNull(resultSet.getString("productName"));
                String lineP = FunctionUtil.defaultIfNull(resultSet.getString("productLine"));
                Integer intQuantity = FunctionUtil.defaultIfNull(resultSet.getInt("quantityInStock"));
                Double price = FunctionUtil.defaultIfNull(resultSet.getDouble("buyPrice"));
                String vendorName = FunctionUtil.defaultIfNull(resultSet.getString("productVendor"));
                String image = FunctionUtil.defaultIfNull(resultSet.getString("image"));
                Integer active = FunctionUtil.defaultIfNull(resultSet.getInt("active"));

                ProductResponse productResponse = new ProductResponse(idP, nameP, lineP, intQuantity, price, vendorName,image, active);
                return productResponse;
            }
        }catch (Exception e){
            System.out.println("Err: " + e.getMessage());
        }
        return new ProductResponse();
    }

    @Override
    public Set<String> getAllProductLine(int statusActive) {
        List<ProductResponse> productResponses = getAll(new ProductSearch("", "", "", 0, 0), statusActive);
        Set<String> nameLine = new TreeSet<>();
        for(int i = 0; i < productResponses.size(); i++){
            nameLine.add(productResponses.get(i).getProductLine());
        }
        return nameLine;
    }

    @Override
    public Set<String> getAllProductVendor(int activeStatus) {
        List<ProductResponse> productResponses = getAll(new ProductSearch("", "", "", 0, 0), activeStatus);
        Set<String> nameVendor = new TreeSet<>();
        for(int i = 0; i < productResponses.size(); i++){
            nameVendor.add(productResponses.get(i).getProductVendor());
        }
        return nameVendor;
    }

    @Override
    public int changeStatus(String id, int active) {
        String sql = "update products " +
                "SET  active = ? " +
                "where productCode = ?";
        try(Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, active);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
            System.out.println("change active ok");
            return preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("err when change active: " + e);
        }
        return 0;
    }


}
