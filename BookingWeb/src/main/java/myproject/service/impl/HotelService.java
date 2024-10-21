package myproject.service.impl;

import myproject.dto.request.HotelRequest;
import myproject.dto.response.HotelRespone;
import myproject.search.HotelSearch;
import myproject.service.IHotelService;
import myproject.util.DBConnect;
import myproject.util.FunctionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class HotelService implements IHotelService {
    private DBConnect dbConnect = new DBConnect();
    @Override
    public List<HotelRespone> getAll(HotelSearch hotelSearch) {
        List<HotelRespone> hotelResponeList = new ArrayList<>();
        String sql = "select * from hotel ht";
        try(Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idHotel = resultSet.getInt("ht.id_hotel");
                String nameHotel = resultSet.getString("ht.name_hotel");
                String nameAddress = resultSet.getString("ht.address");
                String image = resultSet.getString("ht.image");
                Date createDate = FunctionUtil.parseStringToDate(resultSet.getString("create_date"));
                Date updateDate = FunctionUtil.parseStringToDate(resultSet.getString("update_date"));

                HotelRespone hotelRespone = new HotelRespone(idHotel, nameHotel, nameAddress, image, createDate, updateDate);
                hotelResponeList.add(hotelRespone);
            }
        }catch (SQLException e){
            System.out.println("Err search hotel: " + e);
        }

        return hotelResponeList;
    }

    @Override
    public HotelRequest add(HotelRequest hotelRequest) {
        String sql = "insert into hotel (id_hotel, name_hotel, address, image, create_date, update_date) values (0, ?, ?, ?, ?, ?)";
        try(Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, hotelRequest.getNameHotel());
            preparedStatement.setString(2, hotelRequest.getAddress());
            preparedStatement.setString(3, hotelRequest.getImage());
            preparedStatement.setString(4, FunctionUtil.parseDateToString(new Date()));
            preparedStatement.setString(5, FunctionUtil.parseDateToString(new Date()));

            preparedStatement.executeUpdate();
            System.out.println("add hotel ok");
        }catch (SQLException e){
            System.out.println("err when save hotel: " + e);
        }catch (Exception ex1){
            System.out.println("err when save hotel: " + ex1);
        }
        return hotelRequest;
    }

    @Override
    public int edit(HotelRequest hotelRequest) {
        String sql = "update hotel" +
                " set name_hotel = ?, address = ?, image = ?, update_date = ? " +
                " where id_hotel = ?";
        try(Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, hotelRequest.getNameHotel());
            preparedStatement.setString(2, hotelRequest.getAddress());
            preparedStatement.setString(3, hotelRequest.getImage());
            preparedStatement.setString(4, FunctionUtil.parseDateToString(new Date()));
            preparedStatement.setInt(5, hotelRequest.getIdHotel());
            return 1;
        }catch (SQLException e){
            System.out.println("Err when edit hotel: " + e);
        }
        return 0;
    }

    @Override
    public HotelRespone findById(int id) {
        String sql = "select * from hotel ht where id_hotel = ?";
        try(Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idHotel = resultSet.getInt("ht.id_hotel");
                String nameHotel = resultSet.getString("ht.name_hotel");
                String nameAddress = resultSet.getString("ht.address");
                String image = resultSet.getString("ht.image");
                Date createDate = FunctionUtil.parseStringToDate(resultSet.getString("create_date"));
                Date updateDate = FunctionUtil.parseStringToDate(resultSet.getString("update_date"));
                HotelRespone hotelRespone = new HotelRespone(idHotel, nameHotel, nameAddress, image, createDate, updateDate);

                return hotelRespone;
            }
        }catch (SQLException e){
            System.out.println("Err when find hotel by id: " + e);
        }
        return new HotelRespone();
    }

    @Override
    public Set<String> getAllHotelName() {
        Set<String> result = new TreeSet<>();
        String sql = "select distinct name_hotel from hotel";

        try(Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement =  connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                result.add(resultSet.getString("name"));
            }
        }catch (SQLException e){
            System.out.println("Err when get all hotel name: " + e);
        }
        return result;
    }
}
