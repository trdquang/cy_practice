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
import java.util.Date;
import java.util.List;

@WebServlet(name = "home", value = "/home")
public class HomeController extends HttpServlet {
    private IRoomService roomService = new RoomService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String anh1 = "21_10_2024_05_34_41phongdon.jpg";
        String anh2 = "17_10_2024_14_39_16splendid.jpeg";
        String anh3 = "21_10_2024_02_39_43mariot.jpg";
        req.setAttribute("anh1", anh1);
        req.setAttribute("anh2", anh2);
        req.setAttribute("anh3", anh3);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(VariableUtil.pathFE_jsp + "home.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
