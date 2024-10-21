package myproject.controller.backend.booking;

import myproject.dto.response.BookingResponse;
import myproject.search.BookingSearch;
import myproject.service.IBookingService;
import myproject.service.IHotelService;
import myproject.service.IRoomService;
import myproject.service.impl.BookingService;
import myproject.service.impl.HotelService;
import myproject.service.impl.RoomService;
import myproject.util.VariableUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "admin_booking", value = "/admin_booking")
public class AdminBookingController extends HttpServlet {
    private IHotelService hotelService = new HotelService();
    private IRoomService roomService = new RoomService();
    private IBookingService bookingService = new BookingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookingResponse> bookingResponseList = bookingService.getAll(new BookingSearch());
        req.setAttribute("bookingResponseList", bookingResponseList);
//        super.doGet(req, resp);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VariableUtil.pathBE_jsp + "admin_booking.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
