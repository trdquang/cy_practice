package myproject.controller.backend.hotel;

import myproject.dto.request.HotelRequest;
import myproject.dto.response.LocationResponse;
import myproject.service.IHotelService;
import myproject.service.ILocationService;
import myproject.service.impl.HotelService;
import myproject.service.impl.LocationService;
import myproject.util.FunctionUtil;
import myproject.util.VariableUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "admin_hotel_add", value = "/admin_hotel_add")
public class AdminHotelAddController extends HttpServlet {
    private ILocationService locationService = new LocationService();
    private IHotelService hotelService = new HotelService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LocationResponse> listProvince = locationService.getAllProvince();

        req.setAttribute("listProvince", listProvince);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VariableUtil.pathBE_jsp + "admin_hotel_add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hotelName = req.getParameter("hotelName");
        String hotelImage = req.getParameter("hotelImage");
        String province = locationService.getNameById(FunctionUtil.defaultStrToInt(req.getParameter("province")));
        String district = locationService.getNameById(FunctionUtil.defaultStrToInt(req.getParameter("district")));
        String commune = locationService.getNameById(FunctionUtil.defaultStrToInt(req.getParameter("commune")));

        HotelRequest hotelRequest = new HotelRequest(1, hotelName, province + ", " + district + ", " + commune, hotelImage);
        hotelService.add(hotelRequest);
        //        System.out.println(hotelRequest.toString());

        resp.sendRedirect("admin_hotel");

    }
}

