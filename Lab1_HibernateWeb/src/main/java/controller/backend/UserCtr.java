package controller.backend;

import com.google.gson.Gson;
import dto.response.CategoryResp;
import dto.response.InformationResp;
import dto.response.ProductResp;
import dto.response.UserResp;
import repository.ICategoryRepository;
import repository.impl.UserRepository;
import search.CategorySearch;
import search.InformationSearch;
import search.ProductSearch;
import search.UserSearch;
import service.ICategoryService;
import service.IInformationService;
import service.IProducrService;
import service.IUserService;
import service.impl.CategoryService;
import service.impl.InformationService;
import service.impl.ProductService;
import service.impl.UserService;
import util.FunctionUtil;
import util.VariableUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "user", value = "/user")
public class UserCtr extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(userList);
//        resp.setContentType("text/plain");
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().print(jsonString);
        int page = Math.max(1, FunctionUtil.convertStrToInt(req.getParameter("page") ));
//        System.out.println("page = " + page);

        UserSearch userSearch = new UserSearch();
        userSearch.setPage(page);
        userSearch.setLimit(VariableUtil.limitLine);

        List<UserResp> userRespList = userService.getAll(userSearch);

        req.setAttribute("userRespList", userRespList);
        req.setAttribute("page", page);
        req.setAttribute("totalPage",userService.getTotalPage(userSearch));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher( VariableUtil.pathBeJsp + "user.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
