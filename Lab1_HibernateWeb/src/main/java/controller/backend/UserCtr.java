package controller.backend;

import com.google.gson.Gson;
import dto.response.CategoryResp;
import dto.response.ProductResp;
import dto.response.UserResp;
import repository.ICategoryRepository;
import repository.impl.UserRepository;
import search.CategorySearch;
import search.ProductSearch;
import search.UserSearch;
import service.ICategoryService;
import service.IProducrService;
import service.IUserService;
import service.impl.CategoryService;
import service.impl.ProductService;
import service.impl.UserService;

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
//    private UserRepository userRepo = new UserRepository();
    private IProducrService producrService = new ProductService();
    private ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryResp> userList = categoryService.getAll(new CategorySearch());

        Gson gson = new Gson();
        String jsonString = gson.toJson(userList);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print(jsonString);

//        RequestDispatcher requestDispatcher = req.getRequestDispatcher( VariableUtil.pathBeJsp + "user.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
