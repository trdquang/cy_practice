package myproject.controller.frontend;

import myproject.dto.response.RoomResponse;
import myproject.entity.TimePair;
import myproject.search.RoomSearch;
import myproject.service.IRoomService;
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

@WebServlet(name = "search_hotel", value = "/search_hotel")
public class SearchHotelController extends HttpServlet {
    private IRoomService roomService = new RoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String locationName = FunctionUtil.deafultStr(req.getParameter("locationName"));
        Date startDate = FunctionUtil.parseSearchDate(req.getParameter("startDate"));
        Date endDate = FunctionUtil.parseSearchDate(req.getParameter("endDate"));
        String sortBy = req.getParameter("sortBy");

        TimePair timeCheck = new TimePair(startDate, endDate);
        RoomSearch roomSearch = new RoomSearch();
        roomSearch.setLocation(locationName);
        roomSearch.setTimePair(new TimePair(startDate, endDate));

        List<RoomResponse> roomResponseList = roomService.getAll(roomSearch);
        if(sortBy != null && sortBy != ""){
            if (sortBy.equalsIgnoreCase("sortName")) {
                Collections.sort(roomResponseList, new Comparator<RoomResponse>() {
                    @Override
                    public int compare(RoomResponse r1, RoomResponse r2) {
                        return r1.getName().compareTo(r2.getName());  // So sánh tên theo thứ tự từ A-Z
                    }
                });
            }

            if(sortBy.equalsIgnoreCase("sortPrice")){
                Collections.sort(roomResponseList, new Comparator<RoomResponse>() {
                    @Override
                    public int compare(RoomResponse r1, RoomResponse r2) {
                        return Double.compare(r1.getPrice2(), r2.getPrice2());
                    }
                });
            }
        }

        //------------------------Phan trang
        int page = Math.max(1, FunctionUtil.defaultStrToInt(req.getParameter("page")));
        int totalPage = (int)Math.ceil(roomResponseList.size()*1.0/ VariableUtil.numRecordOfPage);

        int frontIndex = (page-1) * VariableUtil.numRecordOfPage;
        int endIndex = Math.min(roomResponseList.size(), page*VariableUtil.numRecordOfPage);
        List<RoomResponse> roomResponePagingList = roomResponseList.subList(frontIndex, endIndex);
        //----------------------------------

        req.setAttribute("roomResponseList", roomResponePagingList);
        req.setAttribute("page", page);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("locationName", locationName);
        req.setAttribute("startDate", startDate);
        req.setAttribute("endDate", endDate);
        req.setAttribute("sortBy", sortBy);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VariableUtil.pathFE_jsp + "search_hotel.jsp");
        requestDispatcher.forward(req, resp);
    }
}
