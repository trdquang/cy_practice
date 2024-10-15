package org.example.cafeweb.servlet.frontend.product;

import org.example.cafeweb.dto.response.ProductResponse;
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
import java.util.*;

@WebServlet(name = "product", value = "/product")
public class ServletProductSearch extends HttpServlet {
    private IProductSerice _productService = new ProductService();
    private IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameSearch = "";
        String nameLine = "";

       if(req.getParameter("name") != null){
           nameSearch = req.getParameter("name").strip();
       }
        if(req.getParameter("productLine") != null){
            nameLine = req.getParameter("productLine").strip();
        }


        ProductSearch productSearch = new ProductSearch();
        productSearch.setProductName(nameSearch);
        productSearch.setProductVendor("");
        if(nameLine.equalsIgnoreCase("All"))
            productSearch.setProductLine("");
        else
            productSearch.setProductLine(nameLine);

//        System.out.println("Name line = " + nameLine + ", " + productSearch.getProductLine());

        List<ProductResponse> listProduct = _productService.getAll(productSearch, 1);
        Set<String> lineSet = _productService.getAllProductLine(1);

        req.setAttribute("listProduct", listProduct); // Đặt danh sách đã tìm vào yêu cầu
        req.setAttribute("listProductLine", lineSet); // Đặt danh sách đã tìm vào yêu cầu
        req.setAttribute("nameLine", nameLine); // Đặt danh sách đã tìm vào yêu cầu

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PathUtil.pathFE_jsp + "product-list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
