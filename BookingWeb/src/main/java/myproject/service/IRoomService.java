package myproject.service;

import myproject.dto.request.HotelRequest;
import myproject.dto.request.RoomRequest;
import myproject.dto.response.HotelRespone;
import myproject.dto.response.RoomResponse;
import myproject.entity.TimePair;
import myproject.search.HotelSearch;
import myproject.search.RoomSearch;

import java.util.List;

public interface IRoomService {
    List<RoomResponse> getAll(RoomSearch roomSearch);
    RoomRequest add(RoomRequest  roomRequest);
    int edit(RoomRequest roomRequest);
    RoomResponse findById(int id);
    List<TimePair> findTimePairByRoomId(int id);
    boolean checkRoomAvaliable(RoomResponse roomResponse, TimePair timePair);
    int activeRoomById(int id);
    int inActiveRoomById(int id);
}
