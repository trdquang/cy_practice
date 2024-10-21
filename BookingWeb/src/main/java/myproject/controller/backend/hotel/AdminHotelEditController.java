package myproject.controller.backend.hotel;

import myproject.dto.request.HotelRequest;
import myproject.dto.response.HotelRespone;
import myproject.dto.response.LocationResponse;
import myproject.service.IHotelService;
import myproject.service.ILocationService;
import myproject.service.impl.HotelService;
import myproject.service.impl.LocationService;
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
import java.util.List;

@WebServlet(name = "admin_hotel_edit", value = "/admin_hotel_edit")
@MultipartConfig
public class AdminHotelEditController extends HttpServlet {
    private ILocationService locationService = new LocationService();
    private IHotelService hotelService = new HotelService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_raw = req.getParameter("id");
        int id = Integer.parseInt(id_raw);
        HotelRespone hotelRespone = hotelService.findById(id);
        List<LocationResponse> listProvince = locationService.getAllProvince();

        req.setAttribute("hotelRespone", hotelRespone);
        req.setAttribute("listProvince", listProvince);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VariableUtil.pathBE_jsp + "admin_hotel_edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_raw = req.getParameter("id_hotel");
        int id = Integer.parseInt(id_raw);

        String hotelName = req.getParameter("hotelName");
//        String hotelImage = req.getParameter("hotelImage");
        String province = locationService.getNameById(FunctionUtil.defaultStrToInt(req.getParameter("province")));
        String district = locationService.getNameById(FunctionUtil.defaultStrToInt(req.getParameter("district")));
        String commune = locationService.getNameById(FunctionUtil.defaultStrToInt(req.getParameter("commune")));

        String fileName = "";
//        -------------------Xử lý ảnh
        Part filePart = req.getPart("roomImage");
        String hotelImage = req.getParameter("image");
//        String fileName = null;

        if (filePart != null && filePart.getSize() > 0) {
            fileName = FunctionUtil.nowDay() + filePart.getSubmittedFileName();

            // Đường dẫn lưu tệp
            String uploadPath = getServletContext().getRealPath("") + "uploads";

            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir(); // Tạo thư mục nếu không tồn tại

            filePart.write(uploadPath + File.separator + fileName);
        }else
            fileName = hotelImage;

        HotelRequest hotelRequest = new HotelRequest(id, hotelName, province + ", " + district + ", " + commune, fileName);
        System.out.println("it edit = " + hotelRequest.getIdHotel());
        System.out.println("new name: " + hotelRequest.getNameHotel());
        hotelService.edit(hotelRequest);

        resp.sendRedirect("admin_hotel");

    }

}


