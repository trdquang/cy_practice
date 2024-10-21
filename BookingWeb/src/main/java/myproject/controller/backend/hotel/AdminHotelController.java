package myproject.controller.backend.hotel;

import myproject.dto.response.HotelRespone;
import myproject.search.HotelSearch;
import myproject.service.IHotelService;
import myproject.service.impl.HotelService;
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
import java.util.List;

@WebServlet(name = "admin_hotel", value = "/admin_hotel")
public class AdminHotelController extends HttpServlet {
    private IHotelService hotelService = new HotelService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotelSearch hotelSearch = new HotelSearch();

        List<HotelRespone> hotelResponeList = hotelService.getAll(hotelSearch);
        Collections.sort(hotelResponeList, new Comparator<HotelRespone>() {
            @Override
            public int compare(HotelRespone o1, HotelRespone o2) {
                return o2.getUpdateDate().compareTo(o1.getUpdateDate());
            }
        });


        int page = Math.max(1, FunctionUtil.defaultStrToInt(req.getParameter("page")));
        int totalPage = (int)Math.ceil(hotelResponeList.size()*1.0/VariableUtil.numRecordOfPage);

        int frontIndex = (page-1) * VariableUtil.numRecordOfPage;
        int endIndex = Math.min(hotelResponeList.size(), page*VariableUtil.numRecordOfPage);
        List<HotelRespone> hotelResponePagingList = hotelResponeList.subList(frontIndex, endIndex);

//        req.setAttribute("hotelResponeList", hotelResponeList);
        req.setAttribute("hotelResponePagingList", hotelResponePagingList);
        req.setAttribute("page", page);
        req.setAttribute("totalPage", totalPage);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VariableUtil.pathBE_jsp + "admin_hotel.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
