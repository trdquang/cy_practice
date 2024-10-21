package myproject.service;

import myproject.dto.request.BookingRequest;
import myproject.dto.request.HotelRequest;
import myproject.dto.response.BookingResponse;
import myproject.dto.response.HotelRespone;
import myproject.search.BookingSearch;
import myproject.search.HotelSearch;

import java.util.List;
import java.util.Set;

public interface IBookingService {
    List<BookingResponse> getAll(BookingSearch bookingSearch);
    BookingRequest add(BookingRequest bookingRequest);
    int edit(BookingRequest bookingRequest);
    BookingResponse findById(int id);
}
