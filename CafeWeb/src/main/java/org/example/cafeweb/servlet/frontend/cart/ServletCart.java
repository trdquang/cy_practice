package org.example.cafeweb.servlet.frontend.cart;

import org.example.cafeweb.dto.pageable.CartPageable;
import org.example.cafeweb.dto.response.CartRespone;
import org.example.cafeweb.search.CartSearch;
import org.example.cafeweb.service.ICartService;
import org.example.cafeweb.service.impl.CartService;
import org.example.cafeweb.util.PathUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;


@WebServlet(name = "cart", value = "/cart")
public class ServletCart extends HttpServlet {
    private Scanner sc = new Scanner(System.in);
    private ICartService cartService = new CartService();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = 1, totalPages = 1;

        CartSearch cartSearch = new CartSearch();
        cartSearch.setCustomerNumber(496);
        List<CartRespone> cartResponeList = cartService.getAll(cartSearch);
        totalPages = (int) Math.ceil((double) cartResponeList.size() / PathUtil.numOfRecord);

        String currentPageParam = req.getParameter("currentPage");
        if (currentPageParam != null && !currentPageParam.isEmpty()) {
            try {
                currentPage = Integer.parseInt(currentPageParam);
            } catch (NumberFormatException e) {
                currentPage = 1;
            }
        }


        if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage >= totalPages) {
            currentPage = totalPages; // Đặt lại về trang cuối cùng nếu vượt quá
        }

        int fromIndex = (currentPage-1) * PathUtil.numOfRecord;
        int toIndex = Math.min(fromIndex + PathUtil.numOfRecord, cartResponeList.size());

        List<CartRespone> cartResponeListPaging = cartResponeList.subList(fromIndex, toIndex);

        //---------------Chuyển jsson
        CartPageable cartPageable = new CartPageable(totalPages, currentPage, "", cartResponeListPaging);
        resp.setContentType("application/json");
        String cartJsonString = this.gson.toJson(cartPageable);
        System.out.println("test = " + cartJsonString);
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(cartJsonString);
        out.flush();

//        ----------------cookie
//        Cookie[] cookies = req.getCookies();
//        Cookie cartCookie = null;
//
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                // Kiểm tra tên cookie
//                if ("cart".equals(cookie.getName())) {
//                    String cartValue = cookie.getValue();
//                    System.out.println("Current value of cart cookie: " + cartValue);
//
//                    // Thêm giá trị mới
//                    cartValue += "yourNewValue"; // Thay "yourNewValue" bằng giá trị bạn muốn thêm
//                    cartCookie = cookie;
//                    cartCookie.setValue(cartValue);
//                    break;
//                }
//            }
//        }
//
//
//
//        if (cartCookie == null) {
//            // Nếu không có cookie, tạo mới
//            cartCookie = new Cookie("cart", "yourNewValue");
//        }
        //        ---------------------

//        req.setAttribute("cartResponeList", cartResponeListPaging);
//        req.setAttribute("currentPage", currentPage);
//        req.setAttribute("totalPages", totalPages);
//
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PathUtil.pathFE_jsp + "cart.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
