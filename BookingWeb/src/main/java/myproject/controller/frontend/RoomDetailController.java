package myproject.controller.frontend;

import myproject.dto.request.BookingRequest;
import myproject.dto.response.RoomResponse;
import myproject.service.IBookingService;
import myproject.service.IRoomService;
import myproject.service.impl.BookingService;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "room_detail", value = "/room_detail")
public class RoomDetailController extends HttpServlet {
    private IRoomService roomService = new RoomService();
    private IBookingService bookingService = new BookingService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idRoom_raw = req.getParameter("idRoom");
        int idRoom = Integer.parseInt(idRoom_raw);

        String startDate_raw =  req.getParameter("startDate");
        String endDate_raw = req.getParameter("endDate");

        Date startDate = FunctionUtil.parseDetailStringToDate(startDate_raw);
        Date endDate = FunctionUtil.parseDetailStringToDate(endDate_raw);

        long differenceInMillis = endDate.getTime() - startDate.getTime();
        long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMillis);

        RoomResponse roomResponse = roomService.findById(idRoom);
        Double price = differenceInDays *roomResponse.getPrice2();

        System.out.println("startDate = " + startDate);

        req.setAttribute("roomResponse", roomResponse);
        req.setAttribute("startDate", FunctionUtil.parseDateToString(startDate));
        req.setAttribute("endDate", FunctionUtil.parseDateToString(endDate) );
        req.setAttribute("price", price);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VariableUtil.pathFE_jsp + "room_detail.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idRoom_raw = req.getParameter("idRoom");
        int idRoom = Integer.parseInt(idRoom_raw);

        String startDate_raw =  req.getParameter("startDate");
        String endDate_raw = req.getParameter("endDate");

        Date startDate = FunctionUtil.parseStringToDate(startDate_raw);
        Date endDate = FunctionUtil.parseStringToDate(endDate_raw);

        String price_raw = req.getParameter("price");
        Double price = Double.parseDouble(price_raw);

        BookingRequest bookingRequest = new BookingRequest(1, 1, idRoom,
                startDate,
                endDate, price);
        bookingService.add(bookingRequest);
        resp.sendRedirect("home");

    }
}
