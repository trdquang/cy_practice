package myproject.service.impl;

import myproject.dto.request.RoomRequest;
import myproject.dto.response.HotelRespone;
import myproject.dto.response.RoomResponse;
import myproject.entity.TimePair;
import myproject.search.RoomSearch;
import myproject.service.IRoomService;
import myproject.util.DBConnect;
import myproject.util.FunctionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RoomService implements IRoomService {
    private DBConnect dbConnect = new DBConnect();

    @Override
    public List<RoomResponse> getAll(RoomSearch roomSearch) {
        List<RoomResponse> roomResponseList = new ArrayList<>();
        String sql = "select * from room rm, hotel ht where rm.id_hotel = ht.id_hotel " +
                "and ht.address like ? ";
        try (Connection connection = dbConnect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + roomSearch.getLocation() + "%");
//            preparedStatement.setString(1, "%%");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idRoom = resultSet.getInt("rm.id_room");
                String name = resultSet.getString("rm.name");
                String address = resultSet.getString("ht.address");
                Double price1 = resultSet.getDouble("rm.price1");
                Double price2 = resultSet.getDouble("rm.price2");
                int idHotel = resultSet.getInt("rm.id_hotel");
                String nameHotel = resultSet.getString("ht.name_hotel");
                String image = resultSet.getString("rm.image");
                int active = resultSet.getInt("rm.active");
                Date createDate = FunctionUtil.parseStringToDate(resultSet.getString("rm.create_date"));
                Date updateDate = FunctionUtil.parseStringToDate(resultSet.getString("rm.update_date"));
                List<TimePair> timePairList = findTimePairByRoomId(idRoom);

                RoomResponse roomResponse = new RoomResponse(idRoom, name, address, price1, price2, idHotel, nameHotel, image, active, createDate, updateDate, timePairList);

//                roomResponseList.add(roomResponse);
                if (checkRoomAvaliable(roomResponse, roomSearch.getTimePair()))
                    roomResponseList.add(roomResponse);
            }
        } catch (SQLException e) {
            System.out.println("Err search room: " + e);
        }

        return roomResponseList;
    }

    @Override
    public RoomRequest add(RoomRequest roomRequest) {
        String sql = "insert into room (id_room, name, price1, price2, id_hotel, create_date, update_date, image) values " +
                "(0, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbConnect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, roomRequest.getName());
            preparedStatement.setDouble(2, roomRequest.getPrice1());
            preparedStatement.setDouble(3, roomRequest.getPrice2());
            preparedStatement.setInt(4, roomRequest.getIdHotel());
            preparedStatement.setString(5, FunctionUtil.parseDateToString(new Date()));
            preparedStatement.setString(6, FunctionUtil.parseDateToString(new Date()));
            preparedStatement.setString(7, roomRequest.getImage());

            preparedStatement.executeUpdate();
            System.out.println("add room ok");
        } catch (SQLException e) {
            System.out.println("err when save room: " + e);
        } catch (Exception ex1) {
            System.out.println("err when save room: " + ex1);
        }
        return roomRequest;
    }

    @Override
    public int edit(RoomRequest roomRequest) {
        String sql = "update room" +
                " set name = ?, price1 = ?, price2 = ?, update_date = ? , image = ?, active = ?" +
                " where id_room = ?";
        try (Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, roomRequest.getName());
            preparedStatement.setDouble(2, roomRequest.getPrice1());
            preparedStatement.setDouble(3, roomRequest.getPrice2());
            preparedStatement.setString(4, FunctionUtil.parseDateToString(new Date()));
            preparedStatement.setString(5, roomRequest.getImage());
            preparedStatement.setInt(6, roomRequest.getActive());
            preparedStatement.setInt(7, roomRequest.getIdRoom());

            preparedStatement.executeUpdate();
            System.out.println("update room ok");
            return 1;

        } catch (SQLException e) {
            System.out.println("Err when edit room: " + e);
        }

        return 0;
    }

    @Override
    public RoomResponse findById(int id) {
        //---------------------------------------------
        List<RoomResponse> roomResponseList = new ArrayList<>();
        String sql = "select * from room rm, hotel ht where rm.id_hotel = ht.id_hotel " +
                "and rm.id_room = ? ";
        try (Connection connection = dbConnect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idRoom = resultSet.getInt("rm.id_room");
                String name = resultSet.getString("rm.name");
                String address = resultSet.getString("ht.address");
                Double price1 = resultSet.getDouble("rm.price1");
                Double price2 = resultSet.getDouble("rm.price2");
                int idHotel = resultSet.getInt("rm.id_hotel");
                String nameHotel = resultSet.getString("ht.name_hotel");
                String image = resultSet.getString("rm.image");
                int active = resultSet.getInt("rm.active");
                Date createDate = FunctionUtil.parseStringToDate(resultSet.getString("rm.create_date"));
                Date updateDate = FunctionUtil.parseStringToDate(resultSet.getString("rm.update_date"));
                List<TimePair> timePairList = findTimePairByRoomId(idRoom);

                RoomResponse roomResponse = new RoomResponse(idRoom, name, address, price1, price2, idHotel, nameHotel, image, active, createDate, updateDate, timePairList);

                return roomResponse;
            }
        } catch (SQLException e) {
            System.out.println("Err search room: " + e);
        }
        //---------------------------------------------
        return new RoomResponse();
    }

    @Override
    public List<TimePair> findTimePairByRoomId(int id) {
        List<TimePair> timePairList = new ArrayList<>();
        String sql = "select * from booking where id_room = ?";
        try (Connection connection = dbConnect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Date start = FunctionUtil.parseStringToDate(resultSet.getString("time_checkin"));
                Date end = FunctionUtil.parseStringToDate(resultSet.getString("time_checkout"));
                timePairList.add(new TimePair(start, end));
            }

            Collections.sort(timePairList, new Comparator<TimePair>() {
                @Override
                public int compare(TimePair tp1, TimePair tp2) {
                    // So sánh thời gian bắt đầu của hai TimePair
                    return tp1.getStart().compareTo(tp2.getStart());
                }
            });

        } catch (SQLException e) {
            System.out.println("err when search time pair of room" + e);
        }

        return timePairList;
    }

    @Override
    public boolean checkRoomAvaliable(RoomResponse roomResponse, TimePair timeCheck) {
        List<TimePair> timePairList = roomResponse.getTimeCheckList();
        for (TimePair it : timePairList) {
            if (it.getStart().compareTo(timeCheck.getStart()) <= 0 && it.getEnd().compareTo(timeCheck.getStart()) >= 0)
                return false;

            if (it.getStart().compareTo(timeCheck.getEnd()) <= 0 && it.getEnd().compareTo(timeCheck.getEnd()) >= 0)
                return false;
        }
        return true;
    }

    @Override
    public int activeRoomById(int id) {
        String sql = "update room" +
                " set active = 1" +
                " where id_room = ?";
        try (Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("active ok");
            return 1;
        }catch (SQLException e){
            System.out.println("err when active by it: " + e);
        }
        return 0;
    }

    @Override
    public int inActiveRoomById(int id) {
        String sql = "update room" +
                " set active = 0" +
                " where id_room = ?";
        try (Connection connection = dbConnect.openConnectToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("inactive ok");
            return 1;
        }catch (SQLException e){
            System.out.println("err when active by it: " + e);
        }
        return 0;
    }
}
