package org.example.cafeweb.servlet.frontend.order;

import org.example.cafeweb.dto.response.OrderDetailResponse;
import org.example.cafeweb.search.OrderSearch;
import org.example.cafeweb.service.IOrderService;
import org.example.cafeweb.service.impl.OrderService;
import org.example.cafeweb.util.PathUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "order", value = "/order")
public class ServletOderList extends HttpServlet {
    private IOrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderSearch orderSearch = new OrderSearch();
        List<OrderDetailResponse> orderResponses = orderService.getAll(orderSearch);

        req.setAttribute("orderResponses", orderResponses);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PathUtil.pathFE_jsp + "order-list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
