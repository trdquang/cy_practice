package myproject.service.impl;

import myproject.dto.request.HotelRequest;
import myproject.dto.response.HotelRespone;
import myproject.search.HotelSearch;
import myproject.service.IHotelService;
import myproject.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelService implements IHotelService {
    private DBConnect dbConnect = new DBConnect();
    @Override
    public List<HotelRespone> getAll(HotelSearch hotelSearch) {
        List<HotelRespone> hotelResponeList = new ArrayList<>();
        String sql = "select * from hotel ht" +
                " where 1 = 1";
        try(Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idHotel = resultSet.getInt("ht.id_hotel");
                String nameHotel = resultSet.getString("ht.name_hotel");
                String nameAddress = resultSet.getString("ht.address");
                String image = resultSet.getString("ht.image");

                HotelRespone hotelRespone = new HotelRespone(idHotel, nameHotel, nameAddress, image);
                hotelResponeList.add(hotelRespone);
            }
        }catch (SQLException e){
            System.out.println("Lỗi tìm hotel: " + e);
        }

        return hotelResponeList;
    }

    @Override
    public HotelRequest add(HotelRequest hotelRequest) {
        String sql = "insert into hotel (id_hotel, name_hotel, address, image) values (0, ?, ?, ?)";
        try(Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, hotelRequest.getNameHotel());
            preparedStatement.setString(2, hotelRequest.getAddress());
            preparedStatement.setString(3, hotelRequest.getImage());

            preparedStatement.executeUpdate();
            System.out.println("add hotel ok");
        }catch (SQLException e){
            System.out.println("err when save hotel: " + e);
        }
        return hotelRequest;
    }

    @Override
    public int edit(HotelRequest hotelRequest) {
        return 0;
    }

    @Override
    public HotelRespone findById(int id) {
        return null;
    }
}
