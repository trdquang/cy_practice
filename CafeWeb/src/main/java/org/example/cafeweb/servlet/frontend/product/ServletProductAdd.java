package org.example.cafeweb.servlet.frontend.product;

import org.example.cafeweb.dto.request.ProductRequest;
import org.example.cafeweb.service.IProductSerice;
import org.example.cafeweb.service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addProduct", value = "/addProduct")
public class ServletProductAdd extends HttpServlet {
    private IProductSerice _productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("name");
        String productLine = req.getParameter("line");

        // Thêm sản phẩm thông qua service
        ProductRequest newProduct = new ProductRequest();
        newProduct.setProductName(productName);
        newProduct.setProductLine(productLine);

        _productService.add(newProduct);
        resp.sendRedirect("http://localhost:8081/cafe/product");
    }
}
