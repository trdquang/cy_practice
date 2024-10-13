package org.example.cafeweb.servlet.backend;

import org.example.cafeweb.search.ProductSearch;
import org.example.cafeweb.service.IOrderService;
import org.example.cafeweb.service.IProductSerice;
import org.example.cafeweb.service.impl.OrderService;
import org.example.cafeweb.service.impl.ProductService;
import org.example.cafeweb.util.PathUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "select-vendor", value = "/select-vendor")
public class SelectVendor extends HttpServlet {
    private IProductSerice _productService = new ProductService();
    private IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PathUtil.pathBE_jsp + "product-select.jsp");
        requestDispatcher.forward(req, resp);
    }
}
