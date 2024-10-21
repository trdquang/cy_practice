package myproject.controller.backend.room;

import myproject.dto.request.HotelRequest;
import myproject.dto.request.RoomRequest;
import myproject.dto.response.HotelRespone;
import myproject.dto.response.LocationResponse;
import myproject.entity.Room;
import myproject.search.HotelSearch;
import myproject.service.IHotelService;
import myproject.service.IRoomService;
import myproject.service.impl.HotelService;
import myproject.service.impl.RoomService;
import myproject.util.FunctionUtil;
import myproject.util.VariableUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@WebServlet(name = "admin_room_add", value = "/admin_room_add")
@MultipartConfig
public class AdminRoomAddController extends HttpServlet {
    private IRoomService roomService = new RoomService();
    private IHotelService hotelService = new HotelService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HotelSearch hotelSearch = new HotelSearch();
        List<HotelRespone> hotelResponeList = hotelService.getAll(hotelSearch);

        System.out.println("Có " + hotelResponeList.size() + "phòng");
        Collections.sort(hotelResponeList, new Comparator<HotelRespone>() {
            @Override
            public int compare(HotelRespone o1, HotelRespone o2) {
                return o1.getNameHotel().compareTo(o2.getNameHotel());
            }
        });
        System.out.println("Có " + hotelResponeList.size() + "phòng");

        req.setAttribute("hotelResponeList", hotelResponeList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VariableUtil.pathBE_jsp + "admin_room_add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roomName = req.getParameter("roomName");
//        String hotelImage = req.getParameter("hotelImage");
        Double roomPrice1 = FunctionUtil.defaultStrToDouble(req.getParameter("roomPrice1"));
        Double roomPrice2 = FunctionUtil.defaultStrToDouble(req.getParameter("roomPrice2"));
        int idHotel = FunctionUtil.defaultStrToInt(req.getParameter("hotel"));
        int active = FunctionUtil.defaultStrToInt(req.getParameter("active"));

        Part filePart = req.getPart("roomImage");
        String fileName = null;

        if (filePart != null && filePart.getSize() > 0) {
            fileName = FunctionUtil.nowDay() + filePart.getSubmittedFileName();

            // Đường dẫn lưu tệp
            String uploadPath = getServletContext().getRealPath("") + "uploads";

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir(); // Tạo thư mục nếu không tồn tại

            filePart.write(uploadPath + File.separator + fileName);
        }
//            -------------------------

        RoomRequest roomRequest = new RoomRequest(1, roomName, roomPrice1, roomPrice2, idHotel, fileName , active);

        roomService.add(roomRequest);
        resp.sendRedirect("admin_room");
    }
}
