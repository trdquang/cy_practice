package myproject.service;

import myproject.dto.request.HotelRequest;
import myproject.dto.response.HotelRespone;
import myproject.search.HotelSearch;

import java.util.List;

public interface IHotelService {
    List<HotelRespone>getAll(HotelSearch hotelSearch);
    HotelRequest add(HotelRequest hotelRequest);
    int edit(HotelRequest hotelRequest);
    HotelRespone findById(int id);
}
