package org.example.cafeweb.servlet.frontend.cart;

import org.example.cafeweb.dto.response.CartRespone;
import org.example.cafeweb.search.CartSearch;
import org.example.cafeweb.service.ICartService;
import org.example.cafeweb.service.impl.CartService;
import org.example.cafeweb.util.PathUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@WebServlet(name = "cart", value = "/cart")
public class ServletCart extends HttpServlet {
    private Scanner sc = new Scanner(System.in);
    private ICartService cartService = new CartService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartSearch cartSearch = new CartSearch();
        cartSearch.setCustomerNumber(496);
        List<CartRespone> cartResponeList = cartService.getAll(cartSearch);

        req.setAttribute("cartResponeList", cartResponeList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PathUtil.pathFE_jsp + "cart.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
