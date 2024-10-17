package myproject.service.impl;

import myproject.dto.response.LocationResponse;
import myproject.service.ILocationService;
import myproject.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationService implements ILocationService {
    private DBConnect connect = new DBConnect();

    @Override
    public List<LocationResponse> getAllProvince() {
        List<LocationResponse> locationResponseList = new ArrayList<>();

        String sql = "select * from location where level = 1";
        try (Connection connection = connect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int level = resultSet.getInt("level");
                int id_pent = resultSet.getInt("id_parent");

                locationResponseList.add(new LocationResponse(id, name, level, id_pent));
            }
        }catch (SQLException e){
            System.out.println("Err when get provonce");
        }

        return locationResponseList;
    }

    @Override
    public List<LocationResponse> getAllDistrictByProvince(int idProvince) {
        List<LocationResponse> locationResponseList = new ArrayList<>();

        String sql = "select * from location where level = 2 and id_parent = ?";
        try (Connection connection = connect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, idProvince);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int level = resultSet.getInt("level");
                int id_pent = resultSet.getInt("id_parent");

                locationResponseList.add(new LocationResponse(id, name, level, id_pent));
            }
        }catch (SQLException e){
            System.out.println("Err when get district");
        }

        return locationResponseList;
    }

    @Override
    public List<LocationResponse> getAllCommueByDistrict(int idDistrict) {
        List<LocationResponse> locationResponseList = new ArrayList<>();

        String sql = "select * from location where level = 3 and id_parent = ?";
        try (Connection connection = connect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, idDistrict);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int level = resultSet.getInt("level");
                int id_pent = resultSet.getInt("id_parent");

                locationResponseList.add(new LocationResponse(id, name, level, id_pent));
            }
        }catch (SQLException e){
            System.out.println("Err when get commue");
        }

        return locationResponseList;
    }

    @Override
    public String getNameById(int id) {
        String res = "";
        String sql = "select name from location where id = ?";
        try(Connection connection = connect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getString("name");
            }
        }catch (SQLException e){
            System.out.println("err when search name");
        }
        return res;
    }
}
