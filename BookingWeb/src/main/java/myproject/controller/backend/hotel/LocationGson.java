package myproject.controller.backend.hotel;

import myproject.dto.response.LocationResponse;
import myproject.service.ILocationService;
import myproject.service.impl.LocationService;
import myproject.util.FunctionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

@WebServlet(name = "location_gson", value = "/location_gson")
public class LocationGson extends HttpServlet {
    private ILocationService locationService = new LocationService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int level = FunctionUtil.defaultStrToInt(req.getParameter("level"));
        int idParent = FunctionUtil.defaultStrToInt(req.getParameter("id_parent"));

        List<LocationResponse> searchResult = new ArrayList<>();

        if(level == 2){
            searchResult = locationService.getAllDistrictByProvince(idParent);
        }else if(level == 3){
            searchResult = locationService.getAllCommueByDistrict(idParent);
        }

        //---------------Chuyển jsson
        resp.setContentType("application/json");
        String searchResultJson = this.gson.toJson(searchResult);
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(searchResultJson);
        out.flush();
    }
}
