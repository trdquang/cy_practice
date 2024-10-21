package myproject.controller.backend.room;

import myproject.dto.response.HotelRespone;
import myproject.dto.response.RoomResponse;
import myproject.entity.TimePair;
import myproject.search.HotelSearch;
import myproject.search.RoomSearch;
import myproject.service.IHotelService;
import myproject.service.IRoomService;
import myproject.service.impl.HotelService;
import myproject.service.impl.RoomService;
import myproject.util.FunctionUtil;
import myproject.util.VariableUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@WebServlet(name = "admin_room", value = "/admin_room")
public class AdminRoomController extends HttpServlet {
    private IHotelService hotelService = new HotelService();
    private IRoomService roomService = new RoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomSearch roomSearch = new RoomSearch();
        roomSearch.setLocation("");
//        roomSearch.setTimePair(new TimePair(new Date(), new Date()));
        roomSearch.setTimePair(new TimePair(null, new Date()));
        List<RoomResponse> roomResponseList = roomService.getAll(roomSearch);

        Collections.sort(roomResponseList, new Comparator<RoomResponse>() {
            @Override
            public int compare(RoomResponse o1, RoomResponse o2) {
                return o2.getUpdateDate().compareTo(o1.getUpdateDate());
            }
        });


        int page = Math.max(1, FunctionUtil.defaultStrToInt(req.getParameter("page")));
        int totalPage = (int)Math.ceil(roomResponseList.size()*1.0/ VariableUtil.numRecordOfPage);

        int frontIndex = (page-1) * VariableUtil.numRecordOfPage;
        int endIndex = Math.min(roomResponseList.size(), page*VariableUtil.numRecordOfPage);
        List<RoomResponse> roomResponePagingList = roomResponseList.subList(frontIndex, endIndex);

//        req.setAttribute("hotelResponeList", hotelResponeList);
        req.setAttribute("roomResponePagingList", roomResponePagingList);
        req.setAttribute("page", page);
        req.setAttribute("totalPage", totalPage);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VariableUtil.pathBE_jsp + "admin_room.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
