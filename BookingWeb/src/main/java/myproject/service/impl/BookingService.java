package myproject.service.impl;

import myproject.dto.request.BookingRequest;
import myproject.dto.response.BookingResponse;
import myproject.dto.response.HotelRespone;
import myproject.search.BookingSearch;
import myproject.service.IBookingService;
import myproject.util.DBConnect;
import myproject.util.FunctionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingService implements IBookingService {
    private DBConnect dbConnect = new DBConnect();

    @Override
    public List<BookingResponse> getAll(BookingSearch bookingSearch) {
        List<BookingResponse> bookingResponseList = new ArrayList<>();
        String sql = "select * from booking bk";
        try(Connection connection = dbConnect.openConnectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idBooking = resultSet.getInt("bk.id_booking");
                int idUser = resultSet.getInt("bk.id_user");
                int idRoom = resultSet.getInt("bk.id_room");
                Date timeCheckin = FunctionUtil.parseStringToDate(resultSet.getString("time_checkin"));
                Date timeCheckout = FunctionUtil.parseStringToDate(resultSet.getString("time_checkout"));
                Double price = resultSet.getDouble("bk.price");;

                BookingResponse bookingResponse = new BookingResponse(idBooking, idUser, idRoom, "", timeCheckin, timeCheckout, price, "0");
                bookingResponseList.add(bookingResponse);
            }
        }catch (SQLException e){
            System.out.println("Err search hotel: " + e);
        }

        return bookingResponseList;
    }

    @Override
    public BookingRequest add(BookingRequest bookingRequest) {
        String sql = "insert into booking (id_booking, id_user, id_room, time_checkin, time_checkout, price) values " +
                " (1, 1, ?, ?, ?, ?)";
        try (Connection connection = dbConnect.openConnectToDB();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, bookingRequest.getIdRoom());
            preparedStatement.setString(2, FunctionUtil.parseDateToString(bookingRequest.getTimeCheckIn()));
            preparedStatement.setString(3, FunctionUtil.parseDateToString(bookingRequest.getTimeCheckout()));
            preparedStatement.setDouble(4, bookingRequest.getPrice());
            preparedStatement.executeUpdate();

            System.out.println("add booking oke");
            return bookingRequest;
        }catch (SQLException e){
            System.out.println("Err when save booking: " + e);
        }
        return bookingRequest;
    }

    @Override
    public int edit(BookingRequest bookingRequest) {
        return 0;
    }

    @Override
    public BookingResponse findById(int id) {
        return null;
    }
}
